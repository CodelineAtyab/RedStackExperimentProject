package com.Employees.EmpAPI.Models;

public class Customer {
    public String id;
    public String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public Object id() {
        return this.id;
    }
}