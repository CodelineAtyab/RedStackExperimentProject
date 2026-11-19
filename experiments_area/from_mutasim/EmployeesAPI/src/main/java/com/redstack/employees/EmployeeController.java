package com.redstack.employees;

import com.redstack.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // CREATE EMPLOYEE
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    // GET ALL EMPLOYEES
    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    // GET EMPLOYEE BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {
        return employeeService.getOne(id);
    }

    // UPDATE EMPLOYEE
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable String id,
            @RequestBody Employee replacement) {
        return employeeService.update(id, replacement);
    }

    // DELETE ONE EMPLOYEE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable String id) {
        return employeeService.deleteOne(id);
    }

    // DELETE ALL EMPLOYEES
    @DeleteMapping
    public ResponseEntity<?> deleteAll(
            @RequestParam(required = false) String confirm) {
        return employeeService.deleteAll(confirm);
    }
}