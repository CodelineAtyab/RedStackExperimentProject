package com.example.Service.Controller;


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
    public ArrayList<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getOneEmployee(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }


    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return employee;
    }

    @PutMapping("/{id}")
    public Optional<Employee> updateEmployee(
            @PathVariable String id,
            @RequestBody Employee updatedEmployee) {

        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable String id) {
        return employeeService.deleteEmployee(id);
    }


    @DeleteMapping
    public void deleteAllEmployees() {
        employeeService.deleteAllEmployees();
    }

}
