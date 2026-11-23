package com.redstack.EmployeesApi.model;

public class Employee {
    public String id;
    public String name;
    //create and initialize an object
    public Employee() {

    }
    //Constructor that receives two values
    public Employee(String id, String name) {
            this.id = id;
            this.name = name;
        }

}
