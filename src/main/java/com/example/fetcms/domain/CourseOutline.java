package com.example.fetcms.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "courseOutline")
public class CourseOutline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseOutline_id")
    private long courseOutline_id;

    @Column(name = "chapter_id")
    private Long chapter;

    @Column(name = "content")
    private String content;


    @ManyToOne
    @JsonBackReference
    @JoinTable(name = "course_courseOutline",
            joinColumns = @JoinColumn(name = "courseOutline_id", referencedColumnName = "courseOutline_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"))

    private Course course;

    public CourseOutline(){
    }

    public CourseOutline(Long chapter, String content){
        this.chapter = chapter;
        this.content = content;
    }

    public long getCourseOutline_id() {
        return courseOutline_id;
    }

    public void setCourseOutline_id(long courseOutline_id) {
        this.courseOutline_id = courseOutline_id;
    }

    public Long getChapter() {
        return chapter;
    }

    public void setChapter(Long chapter) {
        this.chapter = chapter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
