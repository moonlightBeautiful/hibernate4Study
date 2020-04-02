package com.ims.model.c01singleTable;

/**
 * 1.单表继承，父子们共用一张表
 */
public class Cat1 extends Animal1 {
    private double length;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
