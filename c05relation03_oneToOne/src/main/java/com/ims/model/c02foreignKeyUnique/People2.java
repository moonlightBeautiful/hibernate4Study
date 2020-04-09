package com.ims.model.c02foreignKeyUnique;

/**
 * 主
 */
public class People2 {
    private long id;
    private String name;
    private Passport2 passport2;

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

    public Passport2 getPassport2() {
        return passport2;
    }

    public void setPassport2(Passport2 passport2) {
        this.passport2 = passport2;
    }
}
