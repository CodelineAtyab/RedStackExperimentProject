
package com.redstack.servicelayerpart2.controller;

import com.redstack.servicelayerpart2.model.Employee;
import com.redstack.servicelayerpart2.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeManager;

    // Get all employees
    @GetMapping
    public ResponseEntity<ArrayList<Employee>> getAllEmployees() {

        return ResponseEntity.ok(employeeManager.getAllEmployees());
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String id) {

        Employee employee = employeeManager.getEmployeeById(id);

        if (employee == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee " + id + " not found");
        }

        return ResponseEntity.ok(employee);
    }

    // Add employee
    @PostMapping
    public ResponseEntity<Employee> addEmployee(
            @RequestBody Employee employeeToAdd) {

        Employee createdEmployee = employeeManager.addEmployee(employeeToAdd);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdEmployee);
    }

    // Update employee
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable String id,
            @RequestBody Employee employeeDetails) {

        Employee updatedEmployee =
                employeeManager.updateEmployee(id, employeeDetails);

        if (updatedEmployee == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee " + id + " not found");
        }

        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable String id) {

        boolean deleted = employeeManager.deleteEmployee(id);

        if (!deleted) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee " + id + " not found");
        }

        return ResponseEntity.ok("Employee " + id + " deleted");
    }

    // Delete all employees
    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployees() {

        String message = employeeManager.deleteAllEmployees();

        return ResponseEntity.ok(message);
    }
}
