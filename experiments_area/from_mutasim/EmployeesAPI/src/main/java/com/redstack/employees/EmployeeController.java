package com.redstack.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final List<Employee> employees = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        employees.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employees;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        return employees.stream().filter(employee -> id.equals(employee.getId())).findFirst()
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> notFound(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Employee replacement) {
        for (int i = 0; i < employees.size(); i++) {
            if (id.equals(employees.get(i).getId())) {
                replacement.setId(id); // The URL identifies the employee being replaced.
                employees.set(i, replacement);
                return ResponseEntity.ok(replacement);
            }
        }
        return notFound(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable String id) {
        boolean removed = employees.removeIf(employee -> id.equals(employee.getId()));
        if (!removed) return notFound(id);
        return ResponseEntity.ok(Map.of("message", "Employee " + id + " removed"));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll(@RequestParam(required = false) String confirm) {
        if (!"true".equals(confirm)) {
            return ResponseEntity.badRequest().body(Map.of("message", "To delete all employees, use ?confirm=true"));
        }
        employees.clear();
        return ResponseEntity.ok(Map.of("message", "All employees removed"));
    }

    private ResponseEntity<Map<String, String>> notFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Employee with id " + id + " not found"));
    }
}
