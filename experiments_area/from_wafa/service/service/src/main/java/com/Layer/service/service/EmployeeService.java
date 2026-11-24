package com.Layer.service.service;

import com.Layer.service.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public ResponseEntity<?> getEmployee(String id) {
        Employee foundEmployee = employees.stream().filter((currEmployee) -> {
            return currEmployee.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundEmployee != null) {
            return ResponseEntity.ok(foundEmployee);
        }

        return ResponseEntity.status(404).body("Employee not found");
    }

    public ResponseEntity<?> updateEmployee(String id, Employee updateEmployee) {
        Employee foundEmployee = employees.stream().filter((currEmployee) -> {
            return currEmployee.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundEmployee != null) {
            foundEmployee.setName(updateEmployee.getName());
            return ResponseEntity.ok(foundEmployee);
        }

        return ResponseEntity.status(404).body("Employee not found");
    }

    public ResponseEntity<?> deleteEmployee(String id) {
        Employee foundEmployee = employees.stream().filter((currEmployee) -> {
            return currEmployee.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundEmployee != null) {
            employees.remove(foundEmployee);
            return ResponseEntity.ok(foundEmployee.getName() + " removed");
        }

        return ResponseEntity.status(404).body("Employee not found");
    }

    public ResponseEntity<?> deleteAll(Boolean confirm) {
        if (Boolean.TRUE.equals(confirm)) {
            employees.clear();
            return ResponseEntity.ok("All removed");
        }

        return ResponseEntity.status(400).body("all employees deleted");
    }
}