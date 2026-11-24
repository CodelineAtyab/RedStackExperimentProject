package com.reddesk.desk_api.model;

public class Customer {
    public String id;
    public String name;
    public String passHash;

    public Customer() {}

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
