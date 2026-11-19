package com.employee.api.controllers;

import com.employee.api.models.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeControllers {

    // Stores employees in an ArrayList
    ArrayList<Employee> employees = new ArrayList<>();

    // Adding and returning an employee
    @PostMapping
    public Employee AddEmloyee(@RequestBody Employee newEmployee) {
        employees.add(newEmployee); // Add the new employee to the list
        return newEmployee; // Return the added employee
    }

    // Listing all employees
    @GetMapping
    public ArrayList<Employee> getListEmployee() {
        return employees; // Return the entire employee list
    }

    // Getting an employee by ID
    @GetMapping(path = "/{id}")
    public Employee getEmployeeByid(@PathVariable String id) {

        // Search for an employee whose ID matches the provided ID
        Employee employee = employees.stream()
                .filter(e -> e.id.equals(id))
                .findFirst()
                .orElse(null);

        // If the employee does not exist, return 404 Not Found
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }

        return employee; // Return the found employee (200 OK)
    }

    // Updating an employee's name by ID
    @PutMapping(path = "/{id}")
    public Employee updateEmployeeid(@PathVariable String id, @RequestBody Employee updateEmployee) {

        // Search for the employee that needs to be updated
        Employee findEmployee = employees.stream()
                .filter(e -> e.id.equals(id))
                .findFirst()
                .orElse(null);

        // If the employee does not exist, return 404 Not Found
        if (findEmployee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }

        // Update the existing employee's name
        findEmployee.name = updateEmployee.name;

        return findEmployee; // Return the updated employee (200 OK)
    }

    // Deleting an employee by ID
    @DeleteMapping(path = "/{id}")
    public String deleteEmployeeid(@PathVariable String id) {

        // Search for the employee to be deleted
        Employee deleteEmployee = employees.stream()
                .filter(e -> e.id.equals(id))
                .findFirst()
                .orElse(null);

        // If the employee does not exist, return 404 Not Found
        if (deleteEmployee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }

        // Remove the employee from the list
        employees.remove(deleteEmployee);

        return deleteEmployee.name + " removed"; // Return a confirmation message (200 OK)
    }

    // Emptying the entire employee list (requires confirmation)
    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployees(
            @RequestParam(defaultValue = "false") boolean confirm) {

        // If confirmation is not true do not delete anything.
        if (!confirm) {
            return ResponseEntity.badRequest()
                    .body("Deletion not allowed. Please use ?confirm=true to delete all employees.");
        }

        // If confirmation is true, clear the entire employee list
        employees.clear();

        // Return a successful response
        return ResponseEntity.ok("All employees have been deleted successfully.");
    }
}