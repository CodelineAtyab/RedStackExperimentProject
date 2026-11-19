package org.example;

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

    // 1. POST /employees
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        employees.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    // 2. GET /employees
    @GetMapping
    public List<Employee> getAll() {
        return employees;
    }

    // 3. GET /employees/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(notFound(id));
    }

    // 4. PUT /employees/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Employee updated) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                updated.setId(id);
                employees.set(i, updated);
                return ResponseEntity.ok(updated);
            }
        }
        return notFound(id);
    }

    // 5. DELETE /employees/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable String id) {
        boolean removed = employees.removeIf(e -> e.getId().equals(id));
        if (!removed) {
            return notFound(id);
        }
        return ResponseEntity.ok(Map.of("message", "Employee " + id + " was removed."));
    }


    @DeleteMapping
    public ResponseEntity<?> deleteAll(@RequestParam(required = false) String confirm) {
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
