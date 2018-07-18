package com.example.fetcms.service;

import com.example.fetcms.domain.Department;
import com.example.fetcms.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;


    // get() -gets all the list of topics
    public List<Department> getAllDepartments(){
        //return departments;
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll()
                .forEach(departments::add);
        return departments;
    }

    // add() service post
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    // get() -fetching individual departments
    public Department getDepartment(Long id){
        return departmentRepository.findOne(id);
    }

    // update() -put
    public void updateDepartment(Long id, Department department){
        departmentRepository.save(department);
    }

    // delete()
    public void deleteDepartment(Long id) {
        departmentRepository.delete(id);
    }

}
