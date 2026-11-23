package org.example;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final Datastore store;

    public CustomerService(Datastore store) {
        this.store = store;
    }

    public List<Customer> getAll() {
        return store.getCustomers();
    }

    public Optional<Customer> findById(String id) {
        return store.getCustomers().stream()
                .filter(c -> c.id().equals(id))
                .findFirst();
    }

    public Customer create(Customer customer) {
        store.getCustomers().add(customer);
        return customer;
    }
}