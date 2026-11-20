
package com.noor.employeesapi.controller;

import com.noor.employeesapi.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final List<Employee> employees = new ArrayList<>();

    // GET all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // GET employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(
            @PathVariable int id) {

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return ResponseEntity.ok(employee);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // POST create employee
    @PostMapping
    public ResponseEntity<Employee> addEmployee(
            @RequestBody Employee employee) {

        for (Employee existing : employees) {
            if (existing.getId() == employee.getId()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        }

        employees.add(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    // PUT update employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable int id,
            @RequestBody Employee updatedEmployee) {

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(updatedEmployee.getName());
                employee.setDepartment(updatedEmployee.getDepartment());

                return ResponseEntity.ok(employee);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(
            @PathVariable int id) {

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }
}
