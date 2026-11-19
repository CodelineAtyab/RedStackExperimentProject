package com.redstack.employees;

import com.redstack.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // GET ALL EMPLOYEES - 200 OK
    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {

        List<Employee> employees = employeeService.getAll();

        return ResponseEntity.ok(employees);
    }

    // GET EMPLOYEE BY ID - 200 OR 404
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable String id) {

        return employeeService.getOne(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> notFound(id));
    }

    // CREATE EMPLOYEE - 201 CREATED
    @PostMapping
    public ResponseEntity<Employee> create(
            @RequestBody Employee employee) {

        Employee createdEmployee = employeeService.create(employee);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdEmployee);
    }

    // UPDATE EMPLOYEE - 200 OR 404
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable String id,
            @RequestBody Employee replacement) {

        return employeeService.update(id, replacement)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> notFound(id));
    }

    // DELETE ONE EMPLOYEE - 200 OR 404
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable String id) {

        boolean removed = employeeService.deleteOne(id);

        if (!removed) {
            return notFound(id);
        }

        return ResponseEntity.ok(
                Map.of("message", "Employee " + id + " removed")
        );
    }

    // DELETE ALL EMPLOYEES - 200 OR 400
    @DeleteMapping
    public ResponseEntity<?> deleteAll(
            @RequestParam(required = false) String confirm) {

        // Preserve confirmation behavior from Part 1
        if (!"true".equals(confirm)) {

            return ResponseEntity.badRequest().body(
                    Map.of(
                            "message",
                            "To delete all employees, use ?confirm=true"
                    )
            );
        }

        employeeService.deleteAll();

        return ResponseEntity.ok(
                Map.of("message", "All employees removed")
        );
    }

    // HELPER METHOD - 404 NOT FOUND
    private ResponseEntity<Map<String, String>> notFound(String id) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        Map.of(
                                "message",
                                "Employee with id " + id + " not found"
                        )
                );
    }
}