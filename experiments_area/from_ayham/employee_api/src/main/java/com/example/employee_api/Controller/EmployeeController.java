// .\mvnw.cmd spring-boot:run

// GET http://localhost:8080/employees          list all
// POST http://localhost:8080/employees          add one:  {"id":"emp-1","name":"Alex"}
// GET http://localhost:8080/employees/emp-1     get one by ID
// PUT http://localhost:8080/employees/emp-1     update one by ID
// DELETE http://localhost:8080/employees/emp-1   delete one by ID
// DELETE http://localhost:8080/employees?confirm=true         delete all employees 

package com.example.employee_api.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.employee_api.Exceptions.EmployeeNotFoundException;
import com.example.employee_api.Model.Employee;
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
    public Employee getEmployeeById(@PathVariable String id) {
        for (Employee employee : employees) {
            if (Objects.equals(employee.getId(), id)) {
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
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (Objects.equals(employees.get(i).getId(), id)) {
                updatedEmployee.setId(id);
                employees.set(i, updatedEmployee);
                return updatedEmployee;
            }
        }
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable String id) {
        boolean exists = employees.stream().anyMatch(employee -> Objects.equals(employee.getId(), id));
        if (!exists) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }

        employees.removeIf(employee -> Objects.equals(employee.getId(), id));
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
