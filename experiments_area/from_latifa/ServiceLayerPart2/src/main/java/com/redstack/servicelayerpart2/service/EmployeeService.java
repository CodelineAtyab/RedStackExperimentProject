package com.redstack.servicelayerpart2.service;

import com.redstack.servicelayerpart2.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {

    private ArrayList<Employee> employeesList = new ArrayList<>();

    // Get all employees
    public ArrayList<Employee> getAllEmployees() {
        return employeesList;
    }

    // Get employee by ID
    public Employee getEmployeeById(String id) {

        return employeesList.stream()
                .filter(currEmployee -> currEmployee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Add employee
    public Employee addEmployee(Employee employeeToAdd) {

        employeesList.add(employeeToAdd);
        return employeeToAdd;
    }

    // Update employee
    public Employee updateEmployee(String id, Employee employeeDetails) {

        return employeesList.stream()
                .filter(currEmployee -> currEmployee.getId().equals(id))
                .findFirst()
                .map(currEmployee -> {
                    currEmployee.setName(employeeDetails.getName());
                    currEmployee.setRole(employeeDetails.getRole());
                    return currEmployee;
                })
                .orElse(null);
    }

    // Delete employee by ID
    public boolean deleteEmployee(String id) {

        return employeesList.removeIf(
                currEmployee -> currEmployee.getId().equals(id)
        );
    }

    // Delete all employees
    public String deleteAllEmployees() {

        employeesList.clear();

        return "All employees deleted successfully!";
    }
}