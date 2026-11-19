package com.employee.api.controllers;

import com.employee.api.models.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeControllers {
    ArrayList<Employee> ListEmployees = new ArrayList<>();

    @PostMapping // adding and returning an employee
    public Employee AddEmloyee(@RequestBody Employee newEmployee) {
        ListEmployees.add(newEmployee);
        return newEmployee;
    }

    @GetMapping // listing all employees
    public ArrayList<Employee> getListEmployee() {
        return ListEmployees;
    }

    @GetMapping(path = "/{id}") // get employee by id
    public Employee getEmployeeByid(@PathVariable String id) {
        return ListEmployees.stream()
                .filter(employee -> employee.id.equals(id))
                .findFirst()
                .orElse(null);
    }

    @PutMapping(path = "/{id}") // updating the name
    public Employee updateEmployeeid(@PathVariable String id, @RequestBody Employee updateEmployee) {
        Employee findEmployee = ListEmployees.stream()
                .filter(employee -> employee.id.equals(id))
                .findFirst()
                .orElse(null);

        if (findEmployee != null) {
            findEmployee.name = updateEmployee.name;
        }
        return findEmployee;
    }

    @DeleteMapping(path = "/{id}") // deleting an employee by id
    public String deleteEmployeeid(@PathVariable String id) {
        Employee deleteEmployee = ListEmployees.stream()
                .filter(employee -> employee.id.equals(id))
                .findFirst()
                .orElse(null);

        if (deleteEmployee != null) {
            ListEmployees.remove(deleteEmployee);
            return deleteEmployee.name + " removed";
        }
        return "Employee not found";
    }

    @DeleteMapping // emptying the entire list
    public ArrayList<Employee> deleteAllEmployees() {
        ListEmployees.clear();
        return ListEmployees;
    }
}
