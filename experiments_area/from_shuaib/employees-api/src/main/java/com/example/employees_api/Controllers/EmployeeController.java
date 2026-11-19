package com.example.employees_api.Controllers;

import com.example.employees_api.Models.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        employees.add(employee);
        return employee;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employees;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable String id) {
        Optional<Employee> employee = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();

        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee with id " + id + " not found.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        Optional<Employee> existingEmployeeOpt = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();

        if (existingEmployeeOpt.isPresent()) {
            Employee employee = existingEmployeeOpt.get();
            employee.setName(updatedEmployee.getName());
            employee.setRole(updatedEmployee.getRole());
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee with id " + id + " not found for update.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
        boolean removed = employees.removeIf(e -> e.getId().equals(id));

        if (removed) {
            return ResponseEntity.ok("Employee with id " + id + " removed successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee with id " + id + " not found for deletion.");
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployees(@RequestParam(required = false) boolean confirm) {
        if (!confirm) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Deletion aborted. You must pass ?confirm=true to delete all employees.");
        }

        employees.clear();
        return ResponseEntity.ok("All employees have been deleted.");
    }
}