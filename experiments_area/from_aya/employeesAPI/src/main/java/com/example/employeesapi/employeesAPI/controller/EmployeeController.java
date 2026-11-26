package com.example.employeesapi.employeesAPI.controller;

import com.example.employeesapi.employeesAPI.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>();


    // POST
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }


    //Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return new ResponseEntity<>(employee, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable String id,
            @RequestBody Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employee.setName(updatedEmployee.getName());
                return new ResponseEntity<>(employee, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("nothing deleted", HttpStatus.NOT_FOUND);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                employees.remove(i);
                return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("nothing deleted", HttpStatus.NOT_FOUND);
    }

    //Delete all emp
    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployees(
            @RequestParam(required = false) String confirm) {
        if (!"true".equals(confirm)) {
            return new ResponseEntity<>(
                    "Please confirm deletion using confirm=true",
                    HttpStatus.BAD_REQUEST
            );
        }

        employees.clear();
        return new ResponseEntity<>(
                "all removed",
                HttpStatus.OK
        );
    }
}