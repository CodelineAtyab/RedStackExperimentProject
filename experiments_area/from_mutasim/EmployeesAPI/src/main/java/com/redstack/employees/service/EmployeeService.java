package com.redstack.employees.service;

import com.redstack.employees.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    // GET ALL EMPLOYEES
    public List<Employee> getAll() {
        return employees;
    }

    // CREATE EMPLOYEE
    public Employee create(Employee employee) {
        employees.add(employee);
        return employee;
    }

    // GET EMPLOYEE BY ID
    public Optional<Employee> getOne(String id) {
        return employees.stream()
                .filter(employee -> id.equals(employee.getId()))
                .findFirst();
    }

    // UPDATE EMPLOYEE
    public Optional<Employee> update(String id, Employee replacement) {

        for (int i = 0; i < employees.size(); i++) {

            if (id.equals(employees.get(i).getId())) {

                // URL ID takes priority over request body ID
                replacement.setId(id);

                employees.set(i, replacement);

                return Optional.of(replacement);
            }
        }

        return Optional.empty();
    }

    // DELETE ONE EMPLOYEE
    public boolean deleteOne(String id) {

        return employees.removeIf(
                employee -> id.equals(employee.getId())
        );
    }

    // DELETE ALL EMPLOYEES
    public void deleteAll() {
        employees.clear();
    }
}