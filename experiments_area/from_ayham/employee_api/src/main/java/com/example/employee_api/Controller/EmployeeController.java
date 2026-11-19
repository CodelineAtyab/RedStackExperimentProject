// .\mvnw.cmd spring-boot:run
//
// GET http://localhost:8080/employees
// POST http://localhost:8080/employees {"id":"emp-1","name":"Alex"}
// GET http://localhost:8080/employees/emp-1
// PUT http://localhost:8080/employees/emp-1
// DELETE http://localhost:8080/employees/emp-1
// DELETE http://localhost:8080/employees?confirm=true

package com.example.employee_api.Controller;

import java.util.List;

import com.example.employee_api.Model.Employee;
import com.example.employee_api.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Employee with ID " + id + " not found."));
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee newEmployee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(newEmployee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Employee with ID " + id + " not found."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        return employeeService.deleteEmployee(id)
                .<ResponseEntity<?>>map(employee -> ResponseEntity.ok(
                        "Employee with ID " + employee.getId() + " deleted successfully."))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Employee with ID " + id + " not found."));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployees(
            @RequestParam(required = false, defaultValue = "false") boolean confirm) {
        return ResponseEntity.ok(employeeService.deleteAllEmployees(confirm));
    }
}
