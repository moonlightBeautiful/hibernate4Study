package com.ims.model.c03childrenTables;

/**
 * 3.多独立子表继承：一个子类映射到一张独立表，存储它所有的属性，表之间都是独立的，没有关联的。
 */
public class Cat3 extends Animal3 {
    private double length;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
