package com.example.fetcms.excell;

import com.example.fetcms.domain.CourseOutline;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Input {

    public static void download(HttpServletResponse response) throws ClassNotFoundException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet worksheet = workbook.createSheet("course_outline");

        int startRowIndex = 0;
        int startColIndex = 0;

        Shape.excellTemplate(worksheet, startRowIndex, startColIndex);

        response.setHeader("Content-Disposition", "attachment; filename=course_outline.xls");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        try {
            // Retrieve the output stream
            ServletOutputStream outputStream = response.getOutputStream();
            // Write to the output stream
            worksheet.getWorkbook().write(outputStream);
            // Flush the stream
            outputStream.flush();
        } catch (Exception e) {
            System.out.println("Unable to write report to the output stream");
        }
    }

    public static List<CourseOutline> ExcellUpload(@RequestParam("file") MultipartFile file) throws
            IndexOutOfBoundsException {
        List<CourseOutline> courseOutlines= new ArrayList<>();

        if (!file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            throw new MultipartException("Only excel files accepted!");
        }else{
            try {

                XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
                Sheet firstSheet = workbook.getSheetAt(0);
                int offset = 0;
                int currentPosition = 0;

                for (Row nextRow : firstSheet) {
                    int column = 0;
                    Iterator<Cell> cellIterator = nextRow.cellIterator();

                    if ((currentPosition++ > offset)) {

                        String chapter_id = null;
                        String content = null;


                        while ((cellIterator.hasNext())) {

                            XSSFCell cell = (XSSFCell) cellIterator.next();

                            switch (cell.getCellType()) { // stop if blank field found
                                case Cell.CELL_TYPE_BLANK:
                                    break;
                            }

                            if (column == 0) {
                                switch (cell.getCellType()) {
                                    case Cell.CELL_TYPE_STRING:
                                        chapter_id = cell.getStringCellValue();
                                        break;

                                    case Cell.CELL_TYPE_NUMERIC:
                                        chapter_id = Integer.toString((int) cell.getNumericCellValue());
                                        break;

                                    case Cell.CELL_TYPE_BOOLEAN:
                                        chapter_id = String.valueOf(cell.getBooleanCellValue());
                                        break;
                                }
                            }
                            if (column == 1) {
                                switch (cell.getCellType()) {
                                    case Cell.CELL_TYPE_STRING:
                                        content = cell.getStringCellValue();
                                        break;

                                    case Cell.CELL_TYPE_NUMERIC:
                                        content = Integer.toString((int) cell.getNumericCellValue());
                                        break;

                                    case Cell.CELL_TYPE_BOOLEAN:
                                        content = String.valueOf(cell.getBooleanCellValue());
                                        break;

                                }

                            }

                            column++;
                        }
                        courseOutlines.add(new CourseOutline(Long.valueOf(chapter_id),content));
                    }

                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return courseOutlines;
    }
}
