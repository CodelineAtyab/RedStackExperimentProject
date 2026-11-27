package com.redstack.employeeApi;

public class Employee{
    private int id;
    private String name;

    public  Employee() {}

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    //ID Getter & Setter
    public int getId() {return id;}
    public void setId(int id) { this.id = id;}

    //Name Getter & Setter
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

}