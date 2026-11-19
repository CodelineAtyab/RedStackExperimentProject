package com.abdullah.employees.service;

import com.abdullah.employees.Employee;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmployeeService {

    private ArrayList<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public ArrayList<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(String id) {
        return findEmployee(id);
    }

    public Employee updateEmployee(String id, Employee updatedEmployee) {
        Employee employee = findEmployee(id);
        employee.setName(updatedEmployee.getName());

        return employee;
    }

    public Map<String, String> deleteEmployee(String id) {
        Employee employee = findEmployee(id);
        employees.remove(employee);

        return Map.of("message", "Employee " + id + " removed");
    }

    public Map<String, String> deleteAllEmployees(String confirm) {
        if (!"true".equals(confirm)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Nothing deleted. Use ?confirm=true to delete all employees."
            );
        }

        employees.clear();

        return Map.of("message", "All employees removed");
    }

    private Employee findEmployee(String id) {
        for (Employee employee : employees) {
            if (id.equals(employee.getId())) {
                return employee;
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Employee " + id + " not found"
        );
    }
}