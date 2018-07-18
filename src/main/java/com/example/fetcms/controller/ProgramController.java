package com.example.fetcms.controller;

import com.example.fetcms.domain.Department;
import com.example.fetcms.domain.Program;
import com.example.fetcms.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgramController {

    @Autowired
    private ProgramService programService;

    // get -view() -all programs irrespective of the department
    @RequestMapping("/departments/programs")
    public List<Program> getAllPrograms(){

        return programService.getAllPrograms();
    }

    // get -view()
    @RequestMapping("/departments/{id}/programs")
    public List<Program> getAllProgramsPerDeparment(@PathVariable Long id){
        return programService.getAllProgramsPerDepartment(id);
    }

    // get() -individual fetch
    @RequestMapping("/departments/{departmentId}/programs/{id}")
    public Program getDepartment(@PathVariable Long id){
        return programService.getProgram(id);
    }

    // post -add()
    @RequestMapping(method=RequestMethod.POST, value="/departments/{departmentId}/programs")
    public void addProgram(@RequestBody Program program, @PathVariable Long departmentId){
        program.setDepartment(new Department(departmentId, "",""));
        programService.addProgram(program);
    }

    // put -update()
    @RequestMapping(method=RequestMethod.PUT, value="/departments/{departmentId}/programs/{id}")
    public void updateTopic(@RequestBody Program program, @PathVariable Long id, @PathVariable Long departmentId){
        program.setDepartment(new Department(departmentId, "",""));
        programService.updateProgram(program);
    }

    // delete()
    @RequestMapping(method=RequestMethod.DELETE, value="/departments/{departmentId}/programs/{id}")
    public void deleteProgram(@PathVariable Long id){
        programService.deleteProgram(id);
    }

}
