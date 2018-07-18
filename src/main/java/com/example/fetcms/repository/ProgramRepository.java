package com.example.fetcms.repository;

import com.example.fetcms.domain.Program;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProgramRepository extends CrudRepository<Program, Long> {

    public List<Program> findByDepartmentId(Long departmentId);
}
