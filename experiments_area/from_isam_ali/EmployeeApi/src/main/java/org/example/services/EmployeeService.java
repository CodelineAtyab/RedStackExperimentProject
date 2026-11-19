package org.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.example.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    // In-memory data now lives in the service
    private final List<Employee> employees = new ArrayList<>();

    public ResponseEntity<Employee> create(Employee employee) {
        employees.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    public List<Employee> getAll() {
        return employees;
    }

    public ResponseEntity<?> getOne(String id) {
        Employee found = null;
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                found = e;
                break;
            }
        }
        if (found == null) {
            return notFound(id);
        }
        return ResponseEntity.ok(found);
    }

    public ResponseEntity<?> update(String id, Employee updated) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                updated.setId(id);
                employees.set(i, updated);
                return ResponseEntity.ok(updated);
            }
        }
        return notFound(id);
    }

    public ResponseEntity<?> deleteOne(String id) {
        boolean removed = employees.removeIf(e -> e.getId().equals(id));
        if (!removed) {
            return notFound(id);
        }
        return ResponseEntity.ok(Map.of("message", "Employee " + id + " was removed."));
    }

    public ResponseEntity<?> deleteAll(String confirm) {
        if (!"true".equals(confirm)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message",
                            "Nothing was deleted. Add ?confirm=true to delete all employees."));
        }
        employees.clear();
        return ResponseEntity.ok(Map.of("message", "All employees were removed."));
    }

    private ResponseEntity<?> notFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "No employee with id " + id + " exists."));
    }
}