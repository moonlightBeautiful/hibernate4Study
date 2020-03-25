package com.ims.model.c02annotation;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 通过注解来映射
 */
@Entity
@Table(name = "c01_t_airplane")
public class Airplane {

    private long id;
    private String name;
    private String color;

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
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

    @Transient
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Airplane [id=" + id + ", name=" + name + "]";
    }


}
