package com.redstack.employeeservicelayer.controller;
import com.redstack.employeeservicelayer.service.EmployeeService;
import com.redstack.employeeservicelayer.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeManager;

    // Get all employees
    @GetMapping
    public ArrayList<Employee> getAllEmployees(){
        return employeeManager.getAllEmployees();
    }
    // Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return employeeManager.getEmployeeById(id);
    }
    //Add employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employeeToAdd){
        return employeeManager.addEmployee(employeeToAdd);
    }
    //Update employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employeeDetails){

        return employeeManager.updateEmployee(id, employeeDetails);
    }
    //Delete employee by id
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable String id){
        return employeeManager.deleteEmployee(id);
    }
    //Delete all employees
    @DeleteMapping
    public String deleteAllEmployees(@RequestParam(required = false) String confirm){

        return employeeManager.deleteAllEmployees(confirm);
    }


}
