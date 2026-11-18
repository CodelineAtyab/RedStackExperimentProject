package com.redstack.feedbackcrudcustomerlink.store;

import java.util.ArrayList;
import java.util.List;

import com.redstack.feedbackcrudcustomerlink.model.Customer;
import com.redstack.feedbackcrudcustomerlink.model.Feedback;

public class InMemoryDataStore {

    public static final List<Customer> customers = new ArrayList<>();
    public static final List<Feedback> feedbackList = new ArrayList<>();
}
