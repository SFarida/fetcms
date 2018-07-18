package com.example.fetcms.repository;

import com.example.fetcms.domain.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface    CourseRepository extends CrudRepository<Course, Long> {

    @Query(value = "SELECT * FROM course WHERE level = ?1", nativeQuery = true)
    List<Course> findByLevel(int level);

    @Query(value = "SELECT * FROM course WHERE course_code = ?1", nativeQuery = true)
    List<Course> findByCode(int course_code);

    @Query(value = "SELECT * FROM course WHERE level = ?1 and program = ?2 and semester = ?3 ", nativeQuery = true)
    List<Course> findByFilter(int level, String program, int semester);
}
