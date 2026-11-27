package com.example.ServiceLayer.controller;

import com.example.ServiceLayer.model.Employee;
import com.example.ServiceLayer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // POST
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable String id) {
        return employeeService.getEmployee(id);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable String id,
            @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        return employeeService.deleteEmployee(id);
    }

    // Delete all employees
    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployees(
            @RequestParam(required = false) String confirm) {
        return employeeService.deleteAllEmployees(confirm);
    }
}
