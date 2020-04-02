package com.ims.model.c02fatherTableAndChildrenTables;

/**
 * 2.一个父表+多个子表继承，父表存公共信息，字表存自子的信息
 */
public class Animal2 {
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
