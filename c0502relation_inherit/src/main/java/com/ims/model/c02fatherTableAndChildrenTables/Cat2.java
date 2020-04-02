package com.ims.model.c02fatherTableAndChildrenTables;

/**
 * 2.一个父表多个字表继承，父表存公共信息，字表存自子的信息
 */
public class Cat2 extends Animal2 {
    private double length;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
