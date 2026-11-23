
package com.noor.employeesapi.controller;

import com.noor.employeesapi.model.Employee;
import com.noor.employeesapi.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    // GET all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // GET employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    // POST create employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // PUT update employee
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable int id,
            @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    // DELETE employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }

    // DELETE all employees
    @DeleteMapping
    public String deleteAllEmployees() {
        return employeeService.deleteAllEmployees();
    }
}
