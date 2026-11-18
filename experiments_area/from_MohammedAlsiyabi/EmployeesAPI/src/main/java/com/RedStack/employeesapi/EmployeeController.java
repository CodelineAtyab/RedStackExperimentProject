package com.teamred.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    private final List<Employee> employees = new ArrayList<>();


    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }


    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable String id) {
        Optional<Employee> found = findById(id);
        if (found.isEmpty()) {
            return notFound(id);
        }
        return ResponseEntity.ok(found.get());
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id,
                                            @RequestBody Employee updated) {
        Optional<Employee> found = findById(id);
        if (found.isEmpty()) {
            return notFound(id);
        }
        int index = employees.indexOf(found.get());
        updated.setId(id); // the id in the URL decides which employee is replaced
        employees.set(index, updated);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        boolean removed = employees.removeIf(e -> e.getId().equals(id));
        if (!removed) {
            return notFound(id);
        }
        return ResponseEntity.ok(Map.of("message", "Employee with id " + id + " was deleted"));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllEmployees(@RequestParam(required = false) String confirm) {
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
