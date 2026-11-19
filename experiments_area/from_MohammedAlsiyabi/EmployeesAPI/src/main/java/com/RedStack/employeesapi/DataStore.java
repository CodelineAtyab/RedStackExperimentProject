package com.teamred.employees;

import java.util.ArrayList;
import java.util.List;

public class DataStore {

    public static final List<Customer> customers = new ArrayList<>();
    public static final List<Feedback> feedbacks = new ArrayList<>();

    private DataStore() {
    }
}
