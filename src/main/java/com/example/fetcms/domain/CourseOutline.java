package com.example.fetcms.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "content")
public class CourseOutline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "courseOutline_id")
    private long id;
    private String chapter;
    private String content;


    @ManyToOne
    @JsonBackReference
    @JoinTable(name = "course_courseOutline",
            joinColumns = @JoinColumn(name = "courseOutline_id", referencedColumnName = "courseOutline_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"))

    private Course course;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
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
