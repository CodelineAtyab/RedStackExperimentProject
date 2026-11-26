package org.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getAll() {
        return employees;
    }

    public Optional<Employee> getOne(String id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public Employee create(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Optional<Employee> update(String id, Employee updated) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                updated.setId(id);
                employees.set(i, updated);
                return Optional.of(updated);
            }
        }
        return Optional.empty();
    }

    public boolean deleteOne(String id) {
        return employees.removeIf(e -> e.getId().equals(id));
    }

    public void deleteAll() {
        employees.clear();
    }
}