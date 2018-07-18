package com.example.fetcms.domain;

import javax.persistence.*;

@Entity
@Table(name = "program")
public class Program {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "program_id")
    private long id;
    private String name;
    @ManyToOne
    private Department department;

    // Foreign key department_id


    public Program(){
    }


    public Program(long id, String name, long departmentId){
        this.id = id;
        this.name = name;
        this.department = new Department(departmentId, "", "");
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    public Department getDepartment(){
        return department;
    }

    public void setDepartment(Department department){
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
