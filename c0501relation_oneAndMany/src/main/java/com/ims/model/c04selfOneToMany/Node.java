package com.ims.model.c04selfOneToMany;

import java.util.HashSet;
import java.util.Set;

/**
 * 自身一对多：自身既是子（集合）又是父（自身属性）
 */
public class Node {

    private long id;
    private String name;

    private Node parentNode;//自己是父

    private Set<Node> childNodes = new HashSet<Node>(); //又是子

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

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public Set<Node> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(Set<Node> childNodes) {
        this.childNodes = childNodes;
    }


    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentNode=" + parentNode +
                ", childNodes=" + childNodes +
                '}';
    }
}
