package com.example.fetcms.service;


import com.example.fetcms.domain.Department;
import com.example.fetcms.domain.Program;
import com.example.fetcms.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgramService {


    @Autowired
    private ProgramRepository programRepository;

    // get() -gets all the list of programs irrespective of the department
    public List<Program> getAllPrograms(){
        //return departments;
        List<Program> programs = new ArrayList<>();
        programRepository.findAll()
                .forEach(programs::add);
        return programs;
    }

    // get() -gets all the list of programs of a particular department
    public List<Program> getAllProgramsPerDepartment(Long departmentId){
        //return departments;
        List<Program> programs = new ArrayList<>();
        programRepository.findByDepartmentId(departmentId)
                .forEach(programs::add);
        return programs;
    }

    // add() service post
    public void addProgram(Program program) {
        programRepository.save(program);
    }

    // get() -fetching individual programs
    public Program getProgram(Long id){
        return programRepository.findOne(id);
    }

    // update() -put
    public void updateProgram(Program program){
        programRepository.save(program);
    }

    // delete()
    public void deleteProgram(Long id) {
        programRepository.delete(id);
    }
}
