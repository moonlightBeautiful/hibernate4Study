package com.ims.model.c02foreignKeyUnique;

/**
 * 从
 */
public class Passport2 {
    private long id;
    private String name;
    private People2 people2;

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

    public People2 getPeople2() {
        return people2;
    }

    public void setPeople2(People2 people2) {
        this.people2 = people2;
    }
}
