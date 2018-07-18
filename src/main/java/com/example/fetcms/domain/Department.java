package com.example.fetcms.domain;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private long id;
    private String name;
    private String hod; // Head of Department




    public Department(){
    }



    public Department(long id, String name, String hod){
        this.id = id;
        this.name = name;
        this.hod = hod;
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

    public String getHod() {
        return hod;
    }

    public void setHod(String hod) {
        this.hod = hod;
    }
}
