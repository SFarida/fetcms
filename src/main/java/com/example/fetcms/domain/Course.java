package com.example.fetcms.domain;



import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private long id;
    private String course_code;
    private String course_title;
    private int course_value;
    private int semester;
    private int level;
    private String course_master;
    private  String department;
    private String program;


    @ManyToMany(cascade = CascadeType.ALL)
    //@JsonBackReference
    @JoinTable(name = "course_courseOutline",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "courseOutline_id", referencedColumnName = "courseOutline_id"))

    private Set<CourseOutline> courseOutline = new HashSet<CourseOutline>();
    //private  CourseOutline courseOutline;
    public Course(){
    }


    public Course(long id, String course_code, String course_title, int course_value, int semester, int level, String course_master, String department, String program, Set<CourseOutline> courseOutline){
        this.id = id;
        this.course_code = course_code;
        this.course_title = course_title;
        this.course_value = course_value;
        this.semester = semester;
        this.level = level;
        this.course_master = course_master;
        this.department = department;
        this.program = program;
        this.courseOutline = courseOutline;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public int getCourse_value() {
        return course_value;
    }

    public void setCourse_value(int course_value) {
        this.course_value = course_value;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCourse_master() {
        return course_master;
    }

    public void setCourse_master(String course_master) {
        this.course_master = course_master;
    }

    public String getDepartment_name() {
        return department;
    }

    public void setDepartment_name(String department_name) {
        this.department = department_name;
    }

    public String getProgram_name() {
        return program;
    }

    public void setProgram_name(String program_name) {
        this.program = program_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Set<CourseOutline> getCourseOutline() {
        return courseOutline;
    }

    public void setCourseOutline(Set<CourseOutline> courseOutline) {
        this.courseOutline = courseOutline;
    }
}
