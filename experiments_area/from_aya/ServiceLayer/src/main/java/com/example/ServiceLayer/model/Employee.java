package com.example.ServiceLayer.model;

public class Employee {

    private String id;
    private String name;

    //create constractore..

    public Employee() {
    }

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }



    //Getter
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }


   // setter
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}