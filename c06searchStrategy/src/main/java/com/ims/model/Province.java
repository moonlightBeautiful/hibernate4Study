package com.ims.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 单向一对多：一个省对多个市
 * 省有集合属性<市>
 */
public class Province {

    private long id;
    private String name;
    private Set<City> cities = new HashSet<City>();

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

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }
}
