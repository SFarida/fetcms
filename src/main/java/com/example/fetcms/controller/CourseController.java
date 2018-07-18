package com.example.fetcms.controller;

import com.example.fetcms.domain.Course;
import com.example.fetcms.domain.Department;
import com.example.fetcms.domain.Program;
import com.example.fetcms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

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