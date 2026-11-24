package com.example.Service.Controller;
import org.springframework.http.ResponseEntity;

import com.example.Service.Employee;
import com.example.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<ArrayList<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneEmployee(@PathVariable String id) {

        Optional<Employee> employee = employeeService.getEmployeeById(id);

        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        }

        return ResponseEntity.status(404).body("Employee " + id + " not found");
    }


    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);

        return ResponseEntity.status(201).body(newEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable String id,
            @RequestBody Employee updatedEmployee) {

        Optional<Employee> employee = employeeService.updateEmployee(id, updatedEmployee);

        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        }

        return ResponseEntity.status(404).body("Employee " + id + " not found");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id) {

        boolean deleted = employeeService.deleteEmployee(id);

        if (deleted) {
            return ResponseEntity.ok("Employee " + id + " deleted");
        }

        return ResponseEntity.status(404).body("Employee " + id + " not found");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployees() {
        employeeService.deleteAllEmployees();

        return ResponseEntity.ok("All employees deleted");
    }
}
