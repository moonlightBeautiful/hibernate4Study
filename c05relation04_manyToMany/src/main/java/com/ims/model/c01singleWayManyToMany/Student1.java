package com.ims.model.c01singleWayManyToMany;

import java.util.HashSet;
import java.util.Set;

public class Student1 {
    private int id;
    private String name;
    private Set<Course1> courses = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course1> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course1> courses) {
        this.courses = courses;
    }
}
