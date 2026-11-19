package com.redstack.employees.service;

import com.redstack.employees.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    // GET ALL EMPLOYEES
    public List<Employee> getAll() {
        return employees;
    }

    // CREATE EMPLOYEE
    public ResponseEntity<Employee> create(Employee employee) {
        employees.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    // GET EMPLOYEE BY ID
    public ResponseEntity<?> getOne(String id) {
        return employees.stream()
                .filter(employee -> id.equals(employee.getId()))
                .findFirst()
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> notFound(id));
    }

    // UPDATE EMPLOYEE
    public ResponseEntity<?> update(String id, Employee replacement) {
        for (int i = 0; i < employees.size(); i++) {
            if (id.equals(employees.get(i).getId())) {
                replacement.setId(id);
                employees.set(i, replacement);
                return ResponseEntity.ok(replacement);
            }
        }

        return notFound(id);
    }

    // DELETE ONE EMPLOYEE
    public ResponseEntity<?> deleteOne(String id) {
        boolean removed = employees.removeIf(
                employee -> id.equals(employee.getId())
        );

        if (!removed) {
            return notFound(id);
        }

        return ResponseEntity.ok(
                Map.of("message", "Employee " + id + " removed")
        );
    }

    // DELETE ALL EMPLOYEES
    public ResponseEntity<?> deleteAll(String confirm) {
        if (!"true".equals(confirm)) {
            return ResponseEntity.badRequest().body(
                    Map.of("message",
                            "To delete all employees, use ?confirm=true")
            );
        }

        employees.clear();

        return ResponseEntity.ok(
                Map.of("message", "All employees removed")
        );
    }

    // EMPLOYEE NOT FOUND
    private ResponseEntity<Map<String, String>> notFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message",
                        "Employee with id " + id + " not found"));
    }
}