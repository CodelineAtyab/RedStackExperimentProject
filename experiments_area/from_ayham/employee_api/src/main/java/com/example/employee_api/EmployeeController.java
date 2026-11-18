// .\mvnw.cmd spring-boot:run

package com.example.employee_api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>();

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee newEmployee) {
        employees.add(newEmployee);
        return newEmployee;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                updatedEmployee.setId(id);
                employees.set(i, updatedEmployee);
                return updatedEmployee;
            }
        }
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        boolean exists = employees.stream().anyMatch(employee -> employee.getId() == id);
        if (!exists) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }

        employees.removeIf(employee -> employee.getId() == id);
        return "Employee with ID " + id + " deleted successfully.";
    }

    @DeleteMapping
    public String deleteAllEmployees(@RequestParam(required = false, defaultValue = "false") boolean confirm) {
        if (!confirm) {
            return "Deletion cancelled. Send confirm=true to delete all employees.";
        }

        employees.clear();
        return "All employees deleted successfully.";
    }
}
