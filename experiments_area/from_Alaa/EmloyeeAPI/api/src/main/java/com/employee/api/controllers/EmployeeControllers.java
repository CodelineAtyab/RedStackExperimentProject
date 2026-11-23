package com.employee.api.controllers;

import com.employee.api.models.Employee;
import com.employee.api.services.EmployeesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeControllers {

    @Autowired
    EmployeesServices employeeService;

    // Add and return an employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        return employeeService.addEmployee(newEmployee);
    }

    // List all employees
    @GetMapping
    public ArrayList<Employee> getListEmployee() {
        return employeeService.getAllEmployees();
    }

    // Get an employee by ID
    @GetMapping(path = "/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    // Update an employee's name by ID
    @PutMapping(path = "/{id}")
    public Employee updateEmployee(@PathVariable String id,
                                   @RequestBody Employee updateEmployee) {
        return employeeService.updateEmployee(id, updateEmployee);
    }

    // Delete an employee by ID
    @DeleteMapping(path = "/{id}")
    public String deleteEmployee(@PathVariable String id) {
        return employeeService.deleteEmployee(id);
    }


    // Delete all employees (requires ?confirm=true)
    @DeleteMapping
    public String deleteAllEmployees(@RequestParam(defaultValue = "false") boolean confirm) {
        return employeeService.deleteAllEmployees(confirm);
    }
}