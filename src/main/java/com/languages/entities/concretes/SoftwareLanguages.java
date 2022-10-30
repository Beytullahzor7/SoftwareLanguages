package com.languages.entities.concretes;

public class SoftwareLanguages {

    private int id;
    private String name;

    public SoftwareLanguages() {
    }

    public SoftwareLanguages(String name) {
        this.name = name;
    }

    public SoftwareLanguages(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
