package com.example.fetcms.controller;

import com.example.fetcms.domain.Course;
import com.example.fetcms.domain.CourseOutline;
import com.example.fetcms.excell.Input;
import com.example.fetcms.report.GeneratePdfReport;
import com.example.fetcms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> courses;
        courses = (List<Course>) courseRepository.findAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping( "/courses/level/{level}")
    public ResponseEntity<List<Course>> getAllCourseByLevel(@PathVariable int level){
        List<Course> courses;
        courses = courseRepository.findByLevel(level);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping( "/courses/course_code/{course_code}")
    public ResponseEntity<List<Course>> getAllCourseByCode(@PathVariable String course_code){
        List<Course> courses;
        courses = courseRepository.findByCode(course_code);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping( "/Courses/{level}/{program}/{semester}")
    public ResponseEntity<List<Course>> getAllCourseByFilter(@PathVariable int level, @PathVariable String program, @PathVariable int semester){
        List<Course> courses;
        courses = courseRepository.findByFilter(level, program, semester);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST, value="/courses")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Course newcourse;
        newcourse = courseRepository.save(course);
        return new ResponseEntity<>(newcourse, HttpStatus.OK);
    }

    @RequestMapping("/courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
        Course particularCourse;
        particularCourse = courseRepository.findOne(id);
        return new ResponseEntity<>(particularCourse, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id){
        courseRepository.delete(id);
        return new ResponseEntity<>("delete", HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/courses/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long id){
        Course updatedcourse;
        updatedcourse = courseRepository.save(course);
        return new ResponseEntity<>(updatedcourse, HttpStatus.OK);
    }






    //***********************************Excell************************************//
    @RequestMapping(
            value = "/excelSheet",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE
    )
    public void downloadExcel(HttpServletResponse response) throws ClassNotFoundException, IOException {

        Input.download(response);
    }


    @RequestMapping(
            value = "/upload",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<List<CourseOutline>> customersFormUpload(@RequestParam("file") MultipartFile file) throws
            IOException {
        List<CourseOutline> output;
        output =Input.ExcellUpload(file);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }


    @RequestMapping("/all")
    public void allClass() {
        Class<?> current = Course.class;
        while (current.getSuperclass() != null) { // we don't want to process Object.class
            // do something with current's fields
            current = current.getSuperclass();
            System.out.println(current);
        }
    }




    //************************************Pdf Report********************************//

    @RequestMapping(value = "/pdfreport", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> pdfReport(@RequestBody List<Course> courselist) throws IOException {

        //  List<Course> courselist=courseRepository.findAll();

        ByteArrayInputStream bis = GeneratePdfReport.courseReport(courselist);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.add("Content-Disposition", "offline; filename = courses.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }


    //@Autowired
    //private CourseService courseService;

    // get -view() -all courses irrespective of the program
    /*
    @RequestMapping("/departments/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }
    */

    /*
    // get -view()
    @RequestMapping("/departments/programs/{id}/courses")
    public List<Course> getAllCoursesPerProgram(@PathVariable Long id){
        return courseService.getAllCoursesPerProgram(id);
    }

    // get() -individual fetch
    @RequestMapping("/departments/{departmentId}/programs/{programId}/courses/{id}")
    public Course getProgram(@PathVariable Long id){
        return courseService.getCourse(id);
    }
*/
    /*
    // post -add()
    @RequestMapping(method=RequestMethod.POST, value="/departments/{departmentId}/programs/{programId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable Long programId, @PathVariable Long departmentId){
        course.setProgram(new Program(programId, "", departmentId));
        courseService.addCourse(course);
    }
/*
    // put -update()
    @RequestMapping(method=RequestMethod.PUT, value="/departments/{departmentId}/programs/{programId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable Long id, @PathVariable Long departmentId, @PathVariable Long programId){
        course.setProgram(new Program(programId, "",departmentId));
        courseService.updateCourse(course);
    }

    // delete()
    @RequestMapping(method=RequestMethod.DELETE, value="/departments/{departmentId}/programs/{programId}/courses/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
    */
}
