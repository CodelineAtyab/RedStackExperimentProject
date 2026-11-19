package com.teamred.employees;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamred.employees.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable String id) {
        Optional<Employee> found = employeeService.getEmployee(id);
        if (found.isPresent()) {
            return ResponseEntity.ok(found.get());
        }
        return notFound(id);
    }


    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(employee));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id,
                                            @RequestBody Employee updated) {
        Optional<Employee> result = employeeService.updateEmployee(id, updated);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return notFound(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
        if (employeeService.deleteEmployee(id)) {
            return ResponseEntity.ok("Employee " + id + " deleted");
        }
        return notFound(id);
    }


    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployees() {
        int count = employeeService.deleteAllEmployees();
        return ResponseEntity.ok("All employees deleted (" + count + " removed)");
    }

    private <T> ResponseEntity<T> notFound(String id) {
        @SuppressWarnings("unchecked")
        ResponseEntity<T> response = (ResponseEntity<T>) ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Employee " + id + " not found");
        return response;
    }
}