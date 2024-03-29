package com.example.spring1.student;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.spring1.Course.Course;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")

    @Column(updatable = false)
    private long id;

    @Column(nullable = false, columnDefinition = "text")
    private String name;

    @Column(nullable = false, unique = true, columnDefinition = "text")
    private String email;

    @Column(nullable = false, columnDefinition = "Date")
    private LocalDate dob;
    @Transient
    private Integer age;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudent", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Set<Course> Courses = new HashSet<>();

    public Student() {
    }

    public Student(long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", email='" + getEmail() + "'" +
                ", dob='" + getDob() + "'" +
                ", age='" + getAge() + "'" +
                "}";
    }

}
