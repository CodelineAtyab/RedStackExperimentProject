package com.example.employees_api.Services;

import com.example.employees_api.Models.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getAll() {
        return employees;
    }

    public Employee getById(String id) {
        return employees.stream()
                .filter(emp -> id.equals(emp.getId()))
                .findFirst()
                .orElse(null);
    }

    public Employee create(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee update(String id, Employee updatedEmployee) {
        Optional<Employee> match = employees.stream()
                .filter(emp -> id.equals(emp.getId()))
                .findFirst();

        if (match.isEmpty()) {
            return null;
        }

        Employee existing = match.get();
        existing.setName(updatedEmployee.getName());
        return existing;
    }

    public boolean deleteById(String id) {
        return employees.removeIf(emp -> id.equals(emp.getId()));
    }

    public void deleteAll() {
        employees.clear();
    }
}