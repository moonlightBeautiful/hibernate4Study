package com.ims.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 集合映射
 */
public class People {

    private long id;
    private String name;
    private Set<String> dogs;   //无序不重复
    private List<String> cats;  //有序重复
    private List<String> horses;  //有序不重复
    private Map<String, String> pigs;

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


    public Set<String> getDogs() {
        return dogs;
    }

    public void setDogs(Set<String> dogs) {
        this.dogs = dogs;
    }

    public List<String> getCats() {
        return cats;
    }

    public void setCats(List<String> cats) {
        this.cats = cats;
    }

    public List<String> getHorses() {
        return horses;
    }

    public void setHorses(List<String> horses) {
        this.horses = horses;
    }

    public Map<String, String> getPigs() {
        return pigs;
    }

    public void setPigs(Map<String, String> pigs) {
        this.pigs = pigs;
    }
}
