package com.abdullah.employees;

import com.abdullah.employees.service.EmployeeService;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping
    public ArrayList<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") String id) {
        return employeeService.getEmployee(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable("id") String id,
            @RequestBody Employee updatedEmployee) {

        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteEmployee(
            @PathVariable("id") String id) {

        return employeeService.deleteEmployee(id);
    }

    @DeleteMapping
    public Map<String, String> deleteAllEmployees(
            @RequestParam(name = "confirm", required = false)
            String confirm) {

        return employeeService.deleteAllEmployees(confirm);
    }
}