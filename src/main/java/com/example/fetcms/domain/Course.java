package com.example.fetcms.domain;

import javax.persistence.*;

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

    //@ManyToOne
    //private Program program;

    //private Department department;

    // Foreign key department_id


    public Course(){
    }


    public Course(long id, String course_code, String course_title, int course_value, int semester, int level, String course_master, long programId, long departmentId){
        this.id = id;
        this.course_code = course_code;
        this.course_title = course_title;
        this.course_value = course_value;
        this.semester = semester;
        this.level = level;
        this.course_master = course_master;
        //this.program = new Program(programId, "", departmentId);
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")

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

   /* public Program getProgram() {
        return program;
    }

   // public void setProgram(Program program) {
        this.program = program;
    }*/
}
