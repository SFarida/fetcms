package com.example.fetcms.service;

import com.example.fetcms.domain.Course;
import com.example.fetcms.domain.Program;
import com.example.fetcms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // get() -gets all the list of courses irrespective of the program
    /*
    public List<Course> getAllCourses(){
        List<Course> courses = new ArrayList<>();
        CourseRepository.findAll()
                .forEach(courses::add);
        return courses;
    }
    */
/*
    // get() -gets all the list of courses of a particular program
    public List<Course> getAllCoursesPerProgram(Long programId){
        List<Course> courses = new ArrayList<>();
        courseRepository.findByProgramId(programId)
                .forEach(courses::add);
        return courses;
    }
*/
    // add() service post
    public void addCourse(Course course) {
        courseRepository.save(course);
    }
/*
    // get() -fetching individual courses
    public Course getCourse(Long id){
        return courseRepository.findOne(id);
    }

    // update() -put
    public void updateCourse(Course course){
        courseRepository.save(course);
    }

    // delete()
    public void deleteCourse(Long id) {
        courseRepository.delete(id);
    }
   */
}
