package com.ims.model.c01singleTable;

/**
 * 1.单表继承，父子们共用一张表
 */
public class Dog1 extends Animal1 {
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
