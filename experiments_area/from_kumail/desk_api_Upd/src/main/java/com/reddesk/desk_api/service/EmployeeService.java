package com.reddesk.desk_api.service;

import com.reddesk.desk_api.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Get employee by ID
    public Employee getEmployeeById(String id) {
        return employees.stream()
                .filter(employee -> employee.id.equals(id))
                .findFirst()
                .orElse(null);
    }

    // Create employee
    public Employee createEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    // Update employee
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

    // Delete one employee
    public String deleteEmployee(String id) {
        boolean removed = employees.removeIf(
                employee -> employee.id.equals(id)
        );

        if (removed) {
            return "Employee deleted";
        }

        return "Employee not found";
    }

    // Delete all employees
    public String deleteAllEmployees() {
        employees.clear();
        return "All employees deleted";
    }
}
