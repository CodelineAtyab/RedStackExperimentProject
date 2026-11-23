package org.example.controllers;

import java.util.List;
import java.util.Optional;

import org.example.Employee;
import org.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        Optional<Employee> found = employeeService.getOne(id);
        if (found.isPresent()) {
            return ResponseEntity.ok(found.get());
        }
        return notFound(id);
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee created = employeeService.create(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Employee updated) {
        Optional<Employee> result = employeeService.update(id, updated);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return notFound(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable String id) {
        if (employeeService.deleteOne(id)) {
            return ResponseEntity.ok("Employee " + id + " deleted");
        }
        return notFound(id);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll(@RequestParam(required = false) String confirm) {
        if (!"true".equals(confirm)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Nothing was deleted. Add ?confirm=true to delete all employees.");
        }
        employeeService.deleteAll();
        return ResponseEntity.ok("All employees deleted");
    }

    private ResponseEntity<String> notFound(String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Employee " + id + " not found");
    }
}