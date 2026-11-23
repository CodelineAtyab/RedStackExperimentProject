package com.employee.api.services;

import com.employee.api.models.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
public class EmployeesServices {

    private final ArrayList<Employee> employees = new ArrayList<>();

    // Add an employee and return it
    public Employee addEmployee(Employee newEmployee) {
        employees.add(newEmployee);
        return newEmployee;
    }

    // Return all employees
    public ArrayList<Employee> getAllEmployees() {
        return employees;
    }

    // Return one employee by ID, or throw 404
    public Employee getEmployeeById(String id) {
        return employees.stream()
                .filter(e -> e.id.equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Employee not found"));
    }

    // Update an employee's name, or throw 404
    public Employee updateEmployee(String id, Employee updatedEmployee) {
        Employee existing = getEmployeeById(id);
        existing.name = updatedEmployee.name;
        return existing;
    }

    // Delete an employee by ID and return a confirmation message, or throw 404
    public String deleteEmployee(String id) {
        Employee toDelete = getEmployeeById(id);
        employees.remove(toDelete);
        return toDelete.name + " removed";
    }

    // Remove every employee, only when confirm is true, or throw 400
    public String deleteAllEmployees(boolean confirm) {
        if (!confirm) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Deletion not allowed. Please use ?confirm=true to delete all employees.");
        }
        employees.clear();
        return "All employees have been deleted successfully.";
    }
}