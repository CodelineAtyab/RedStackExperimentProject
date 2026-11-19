package org.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final List<Employee> employeeList = new ArrayList<>();

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
        return employee;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        Employee found = employeeList.stream()
                .filter(e -> e.id().equals(id))
                .findFirst()
                .orElse(null);

        if (found == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(found);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee incoming) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).id().equals(id)) {

                Employee updated = new Employee(id, incoming.name());
                employeeList.set(i, updated);
                return ResponseEntity.ok(updated);
            }
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
        boolean removed = employeeList.removeIf(e -> e.id().equals(id));
        if (!removed) {
            return ResponseEntity.status(404).body("Employee with ID " + id + " not found.");
        }
        return ResponseEntity.ok("Successfully deleted employee with ID: " + id);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployees(@RequestParam(required = false) boolean confirm) {
        if (!confirm) {
            return ResponseEntity.status(400)
                    .body("Bad Request: Deleting all employees requires confirmation (?confirm=true).");
        }
        employeeList.clear();
        return ResponseEntity.ok("All employees have been successfully deleted.");
    }




}