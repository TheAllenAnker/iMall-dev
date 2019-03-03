package com.delicate.iMall.bean;

public class ProductCategory {
    private String id;
    private int level;
    private String name;
    private int status;

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id='" + id + '\'' +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
