package com.example.fetcms.controller;

import com.example.fetcms.domain.Department;
import com.example.fetcms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    // get -view()
    @RequestMapping("/departments")
    public List<Department> getAllDepartment(){

        return departmentService.getAllDepartments();
    }

    // get() -individual fetch
    @RequestMapping("/departments/{id}")
    public Department getDepartment(@PathVariable Long id){
        return departmentService.getDepartment(id);
    }

    // post -add()
    @RequestMapping(method=RequestMethod.POST, value="/departments")
    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }

    // put -update() ------*******check again
    @RequestMapping(method=RequestMethod.PUT, value="/departments/{id}")
    public void updateTopic(@RequestBody Department department, @PathVariable Long id){
        departmentService.updateDepartment(id, department);
    }

    // delete()
    @RequestMapping(method=RequestMethod.DELETE, value="/departments/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
    }
}
