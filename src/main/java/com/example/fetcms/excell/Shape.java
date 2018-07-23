package com.example.fetcms.excell;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Shape {

    public static void excellTemplate(XSSFSheet worksheet, int startRowIndex, int startColIndex) {
        worksheet.setColumnWidth(0, 3000);
        worksheet.setColumnWidth(1, 10000);

        Font font = worksheet.getWorkbook().createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);

        XSSFCellStyle headerCellStyle = worksheet.getWorkbook().createCellStyle();
        headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headerCellStyle.setWrapText(true);
        headerCellStyle.setFont(font);
        headerCellStyle.setBorderRight(CellStyle.BORDER_THICK);
        headerCellStyle.setBorderBottom(CellStyle.BORDER_THICK);

        XSSFRow rowHeader = worksheet.createRow((short) startRowIndex);
        rowHeader.setHeight((short) 500);

        XSSFCell cell1 = rowHeader.createCell(startColIndex+0);
        cell1.setCellValue("Chapter Number");
        cell1.setCellStyle(headerCellStyle);

        XSSFCell cell2 = rowHeader.createCell(startColIndex+1);
        cell2.setCellValue("Course Outline");
        cell2.setCellStyle(headerCellStyle);
    }
}
