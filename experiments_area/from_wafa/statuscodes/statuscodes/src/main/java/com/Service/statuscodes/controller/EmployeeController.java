package com.Service.statuscodes.controller;

import com.Service.statuscodes.model.Employee;
import com.Service.statuscodes.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable String id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable String id,
            @RequestBody Employee updateEmployee) {
        return employeeService.updateEmployee(id, updateEmployee);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchEmployee(
            @PathVariable String id,
            @RequestBody Employee updateEmployee) {
        return employeeService.updateEmployee(id, updateEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        return employeeService.deleteEmployee(id);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll(@RequestParam(required = false) Boolean confirm) {
        return employeeService.deleteAll(confirm);
    }
}
