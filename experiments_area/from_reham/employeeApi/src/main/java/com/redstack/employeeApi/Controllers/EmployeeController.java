package com.redstack.employeeApi.Controllers;

import java.util.ArrayList;

import com.redstack.employeeApi.Employee;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    private ArrayList<Employee> employees = new ArrayList<>(); // Store employees here

    @PostMapping// POST - Add employee
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable int id) {
        Employee employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee not found");
        }
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable int id,
            @RequestBody Employee updatedEmployee) {

        Employee employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee not found");
        }

        if (updatedEmployee.getId() != id) {
            return ResponseEntity.badRequest()
                    .body("Employee ID must match the URL ID");
        }

        employee.setName(updatedEmployee.getName());

        return ResponseEntity.ok(employee);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {

        Employee employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee not found");
        }

        employees.removeIf(e -> e.getId() == id);

        return ResponseEntity.ok(
                "Employee " + employee.getName() + " deleted successfully"
        );
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployees(
            @RequestParam(required = false) String confirm) {

        if (!"true".equals(confirm)) {
            return ResponseEntity.badRequest()
                    .body("Please provide confirm=true to delete all employees");
        }

        employees.clear();

        return ResponseEntity.ok("All employees deleted successfully");
    }






}
