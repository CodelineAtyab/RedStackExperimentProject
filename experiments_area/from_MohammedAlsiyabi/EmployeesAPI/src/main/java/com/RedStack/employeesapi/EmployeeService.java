package com.teamred.employees.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamred.employees.Employee;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public ResponseEntity<Employee> createEmployee(Employee employee) {
        employees.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public ResponseEntity<?> getEmployee(String id) {
        Optional<Employee> found = findById(id);
        if (found.isEmpty()) {
            return notFound(id);
        }
        return ResponseEntity.ok(found.get());
    }

    public ResponseEntity<?> updateEmployee(String id, Employee updated) {
        Optional<Employee> found = findById(id);
        if (found.isEmpty()) {
            return notFound(id);
        }
        int index = employees.indexOf(found.get());
        updated.setId(id); // the id in the URL decides which employee is replaced
        employees.set(index, updated);
        return ResponseEntity.ok(updated);
    }

    public ResponseEntity<?> deleteEmployee(String id) {
        boolean removed = employees.removeIf(e -> e.getId().equals(id));
        if (!removed) {
            return notFound(id);
        }
        return ResponseEntity.ok(Map.of("message", "Employee with id " + id + " was deleted"));
    }

    public ResponseEntity<?> deleteAllEmployees(String confirm) {
        if (!"true".equals(confirm)) {
            return ResponseEntity.badRequest().body(Map.of(
                    "message", "Nothing deleted. Send DELETE /employees?confirm=true to delete all employees."));
        }
        int count = employees.size();
        employees.clear();
        return ResponseEntity.ok(Map.of("message", "All employees deleted (" + count + " removed)"));
    }

    private Optional<Employee> findById(String id) {
        return employees.stream()
                .filter(e -> e.getId() != null && e.getId().equals(id))
                .findFirst();
    }

    private ResponseEntity<Map<String, String>> notFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Employee with id " + id + " not found"));
    }
}