package com.abdullah.employees;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private ArrayList<Employee> employees = new ArrayList<>();

    // Add an employee from the JSON body.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }

    // Return the complete list.
    @GetMapping
    public ArrayList<Employee> getAllEmployees() {
        return employees;
    }

    // Find one employee using the ID in the URL.
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") String id) {
        return findEmployee(id);
    }

    // Replace the employee's data while keeping the URL's ID.
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable("id") String id,
            @RequestBody Employee updatedEmployee) {

        Employee employee = findEmployee(id);
        employee.setName(updatedEmployee.getName());

        return employee;
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteEmployee(
            @PathVariable("id") String id) {

        Employee employee = findEmployee(id);
        employees.remove(employee);

        return Map.of("message", "Employee " + id + " removed");
    }

    @DeleteMapping
    public Map<String, String> deleteAllEmployees(
            @RequestParam(name = "confirm", required = false)
            String confirm) {

        if (!"true".equals(confirm)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Nothing deleted. Use ?confirm=true to delete all employees."
            );
        }

        employees.clear();

        return Map.of("message", "All employees removed");
    }

    // Reuse the same search for GET one, PUT and DELETE one.
    private Employee findEmployee(String id) {
        for (Employee employee : employees) {
            if (id.equals(employee.getId())) {
                return employee;
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Employee " + id + " not found"
        );
    }
}