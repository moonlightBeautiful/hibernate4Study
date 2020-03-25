package com.ims.model.c01xml;

/**
 * 通过xml来映射
 */
public class Car {

    private long id;
    private String name;
    private String color;
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

    @Override
    public String toString() {
        return "Car [id=" + id + ", name=" + name + "]";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
