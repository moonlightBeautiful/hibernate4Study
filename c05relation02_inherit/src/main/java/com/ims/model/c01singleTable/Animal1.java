package com.ims.model.c01singleTable;

/**
 * 1.单表继承，父子们共用一张表
 */
public class Animal1 {
    private int id;
    private String name;

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
}
