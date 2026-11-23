package org.example.controllers;

import java.util.List;

import org.example.Employee;
import org.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // Spring creates the service and gives it to us (no "new")
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        return employeeService.getOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Employee updated) {
        return employeeService.update(id, updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable String id) {
        return employeeService.deleteOne(id);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll(@RequestParam(required = false) String confirm) {
        return employeeService.deleteAll(confirm);
    }
}