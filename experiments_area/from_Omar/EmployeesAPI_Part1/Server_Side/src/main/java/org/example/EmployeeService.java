package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getAll() {
        return employeeList;
    }

    public ResponseEntity<Employee> getById(String id) {
        Employee found = employeeList.stream()
                .filter(e -> e.id().equals(id))
                .findFirst()
                .orElse(null);

        if (found == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(found);
    }

    public Employee create(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public ResponseEntity<Employee> update(String id, Employee incoming) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).id().equals(id)) {
                Employee updated = new Employee(id, incoming.name(), incoming.role());
                employeeList.set(i, updated);
                return ResponseEntity.ok(updated);
            }
        }
        return ResponseEntity.status(404).build();
    }

    public ResponseEntity<String> deleteById(String id) {
        boolean removed = employeeList.removeIf(e -> e.id().equals(id));
        if (!removed) {
            return ResponseEntity.status(404).body("Employee with ID " + id + " not found.");
        }
        return ResponseEntity.ok("Successfully deleted employee with ID: " + id);
    }

    public ResponseEntity<String> deleteAll(boolean confirm) {
        if (!confirm) {
            return ResponseEntity.status(400)
                    .body("Bad Request: Deleting all employees requires confirmation (?confirm=true).");
        }
        employeeList.clear();
        return ResponseEntity.ok("All employees have been successfully deleted.");
    }
}