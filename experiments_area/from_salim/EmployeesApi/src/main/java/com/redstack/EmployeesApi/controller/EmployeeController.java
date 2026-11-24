package com.redstack.EmployeesApi.controller;

import com.redstack.EmployeesApi.service.EmployeeService;
import com.redstack.EmployeesApi.model.Employee;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);

        if (employee.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Employee " + id + " not found"));
        }

        return ResponseEntity.ok(employee.get());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(
            @RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdEmployee);
    }

    //@PutMapping("/{id}")
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable String id,
            @RequestBody Employee updatedEmployee) {

        Optional<Employee> employee =
                employeeService.updateEmployee(id, updatedEmployee);

        if (employee.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Employee " + id + " not found"));
        }

        return ResponseEntity.ok(employee.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        Optional<Employee> employee = employeeService.deleteEmployee(id);

        if (employee.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Employee " + id + " not found"));
        }

        return ResponseEntity.ok(
                Map.of("message", "Employee " + id + " deleted"));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllEmployees(
            @RequestParam(required = false) String confirm) {

        boolean deleted = employeeService.deleteAllEmployees(confirm);

        if (!deleted) {
            return ResponseEntity.badRequest()
                    .body(Map.of(
                            "message",
                            "Nothing deleted. Add ?confirm=true to confirm."));
        }

        return ResponseEntity.ok(
                Map.of("message", "All employees deleted"));
    }
}
