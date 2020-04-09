package com.ims.model.c01sharedPrimaryKey;

/**
 * 主
 */
public class People1 {
    private long id;
    private String name;
    private Passport1 passport1;

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

    public Passport1 getPassport1() {
        return passport1;
    }

    public void setPassport1(Passport1 passport1) {
        this.passport1 = passport1;
    }
}
