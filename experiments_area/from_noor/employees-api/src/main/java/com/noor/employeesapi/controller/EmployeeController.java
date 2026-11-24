package com.noor.employeesapi.controller;

import com.noor.employeesapi.model.Employee;
import com.noor.employeesapi.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // GET all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // GET employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) {
            return ResponseEntity.status(404)
                    .body("Employee " + id + " not found");
        }

        return ResponseEntity.ok(employee);
    }

    // POST create employee
    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        Employee created = employeeService.addEmployee(employee);

        if (created == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Employee " + employee.getId() + " already exists");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PUT update employee
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable int id,
            @RequestBody Employee updatedEmployee) {

        Employee employee = employeeService.updateEmployee(id, updatedEmployee);

        if (employee == null) {
            return ResponseEntity.status(404)
                    .body("Employee " + id + " not found");
        }

        return ResponseEntity.ok(employee);
    }

    // DELETE employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        String result = employeeService.deleteEmployee(id);

        if ("Employee not found".equals(result)) {
            return ResponseEntity.status(404)
                    .body("Employee " + id + " not found");
        }

        return ResponseEntity.ok(result);
    }

    // DELETE all employees
    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployees() {
        return ResponseEntity.ok(employeeService.deleteAllEmployees());
    }
}