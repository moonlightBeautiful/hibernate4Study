package com.ims.model.c03childrenTables;

/**
 * 3.多独立子表继承：一个子类映射到一张独立表，存储它所有的属性，表之间都是独立的，没有关联的。
 */
public class Animal3 {
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
