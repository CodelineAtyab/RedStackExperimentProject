package com.abdullah.employees;

import com.abdullah.employees.service.EmployeeService;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(
            @RequestBody Employee employee) {

        Employee createdEmployee = employeeService.addEmployee(employee);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdEmployee);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(
            @PathVariable("id") String id) {

        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Employee " + id + " not found"));
        }

        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable("id") String id,
            @RequestBody Employee updatedEmployee) {

        Employee employee =
                employeeService.updateEmployee(id, updatedEmployee);

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Employee " + id + " not found"));
        }

        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteEmployee(
            @PathVariable("id") String id) {

        boolean deleted = employeeService.deleteEmployee(id);

        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Employee " + id + " not found"));
        }

        return ResponseEntity.ok(
                Map.of("message", "Employee " + id + " deleted"));
    }

    @DeleteMapping
    public ResponseEntity<Map<String, String>> deleteAllEmployees(
            @RequestParam(name = "confirm", required = false)
            String confirm) {

        boolean deleted = employeeService.deleteAllEmployees(confirm);

        if (!deleted) {
            return ResponseEntity.badRequest().body(
                    Map.of("message",
                            "Nothing deleted. Use ?confirm=true to delete all employees."));
        }

        return ResponseEntity.ok(
                Map.of("message", "All employees deleted"));
    }
}