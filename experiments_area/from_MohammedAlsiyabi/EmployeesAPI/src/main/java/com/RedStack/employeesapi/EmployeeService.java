package com.teamred.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teamred.employees.Employee;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public Employee createEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }


    public Optional<Employee> getEmployee(String id) {
        return employees.stream()
                .filter(e -> e.getId() != null && e.getId().equals(id))
                .findFirst();
    }

    public Optional<Employee> updateEmployee(String id, Employee updated) {
        Optional<Employee> found = getEmployee(id);
        if (found.isPresent()) {
            int index = employees.indexOf(found.get());
            updated.setId(id);
            employees.set(index, updated);
            return Optional.of(updated);
        }
        return Optional.empty();
    }


    public boolean deleteEmployee(String id) {
        return employees.removeIf(e -> e.getId() != null && e.getId().equals(id));
    }

    public int deleteAllEmployees() {
        int count = employees.size();
        employees.clear();
        return count;
    }
}