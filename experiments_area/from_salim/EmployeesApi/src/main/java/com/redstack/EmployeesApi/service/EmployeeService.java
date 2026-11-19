package com.redstack.EmployeesApi.service;

import com.redstack.EmployeesApi.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(String id) {
        return employees.stream()
                .filter(employee -> employee.id.equals(id))
                .findFirst()
                .orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee updateEmployee(String id, Employee updatedEmployee) {
        return employees.stream()
                .filter(employee -> employee.id.equals(id))
                .findFirst()
                .map(employee -> {
                    employee.name = updatedEmployee.name;
                    return employee;
                })
                .orElse(null);
    }

    public String deleteEmployee(String id) {
        boolean removed = employees.removeIf(
                employee -> employee.id.equals(id));

        if (removed) {
            return "Employee deleted";
        }

        return "Employee not found";
    }

    public String deleteAllEmployees(String confirm) {
        if (!"true".equals(confirm)) {
            return "Nothing deleted. Add ?confirm=true to confirm.";
        }

        employees.clear();
        return "All employees deleted";
    }
}