package com.example.fetcms.repository;

import com.example.fetcms.domain.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    public List<Course> findByProgramId(Long programId);
}
