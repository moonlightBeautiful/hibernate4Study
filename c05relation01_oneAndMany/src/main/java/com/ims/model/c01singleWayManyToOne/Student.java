package com.ims.model.c01singleWayManyToOne;

/**
 * 单向多对一：多个学生对一个学校
 * 学生有学校属性
 */
public class Student {

    private long id;
    private String name;
    private School school;    //多对一，多个学生对一个学校

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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }


}
