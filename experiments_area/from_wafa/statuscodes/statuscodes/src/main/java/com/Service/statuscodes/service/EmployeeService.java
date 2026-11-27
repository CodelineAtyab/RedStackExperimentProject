package com.Service.statuscodes.service;

import com.Service.statuscodes.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.status(200).body(employees);
    }

    public ResponseEntity<?> getEmployee(String id) {
        Employee foundEmployee = employees.stream().filter((currEmployee) -> {
            return currEmployee.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundEmployee != null) {
            return ResponseEntity.status(200).body(foundEmployee);
        }

        return ResponseEntity.status(404).body("Employee " + id + " not found");
    }

    public ResponseEntity<Employee> addEmployee(Employee employee) {
        employees.add(employee);
        return ResponseEntity.status(201).body(employee);
    }

    public ResponseEntity<?> updateEmployee(String id, Employee updateEmployee) {
        Employee foundEmployee = employees.stream().filter((currEmployee) -> {
            return currEmployee.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundEmployee != null) {
            if (updateEmployee.getName() != null) {
                foundEmployee.setName(updateEmployee.getName());
            }
            if (updateEmployee.getRole() != null) {
                foundEmployee.setRole(updateEmployee.getRole());
            }
            return ResponseEntity.status(200).body(foundEmployee);
        }

        return ResponseEntity.status(404).body("Employee " + id + " not found");
    }

    public ResponseEntity<?> deleteEmployee(String id) {
        Employee foundEmployee = employees.stream().filter((currEmployee) -> {
            return currEmployee.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundEmployee != null) {
            employees.remove(foundEmployee);
            return ResponseEntity.status(200).body("Employee " + id + " deleted");
        }

        return ResponseEntity.status(404).body("Employee " + id + " not found");
    }

    public ResponseEntity<?> deleteAll(Boolean confirm) {
        employees.clear();
        return ResponseEntity.status(200).body("All employees deleted");
    }
}