package com.redstack.employees;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class InMemoryStore {
    public final List<Customer> customers = new ArrayList<>();
    public final List<Feedback> feedback = new ArrayList<>();
}