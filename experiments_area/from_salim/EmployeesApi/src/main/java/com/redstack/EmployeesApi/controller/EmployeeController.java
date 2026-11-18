package com.redstack.EmployeesApi.controller;

import com.redstack.EmployeesApi.model.Employee;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    ArrayList<Employee> listOfEmployees = new ArrayList<>();

    @GetMapping
    public ArrayList<Employee> getAllEmployees() {
        return listOfEmployees;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getSpecificEmployee(@PathVariable String id) {
        Optional<Employee> foundEmployee = listOfEmployees.stream()
                .filter(currentEmployee -> currentEmployee.id.equals(id))
                .findFirst();

        if (foundEmployee.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Employee " + id + " not found"));
        }

        return ResponseEntity.ok(foundEmployee.get());
    }

    @PostMapping
    public Employee registerEmployee(@RequestBody Employee incomingEmployee) {
        listOfEmployees.add(incomingEmployee);
        return incomingEmployee;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable String id,
            @RequestBody Employee incomingEmployee) {

        for (int index = 0; index < listOfEmployees.size(); index++) {
            Employee currentEmployee = listOfEmployees.get(index);

            if (currentEmployee.id.equals(id)) {
                incomingEmployee.id = id;
                listOfEmployees.set(index, incomingEmployee);
                return ResponseEntity.ok(incomingEmployee);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Employee " + id + " not found"));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteSpecificEmployee(@PathVariable String id) {
        for (int index = 0; index < listOfEmployees.size(); index++) {
            Employee currentEmployee = listOfEmployees.get(index);

            if (currentEmployee.id.equals(id)) {
                listOfEmployees.remove(index);
                return ResponseEntity.ok(
                        Map.of("message", "Employee " + id + " deleted"));
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Employee " + id + " not found"));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllEmployees(
            @RequestParam(required = false) String confirm) {

        if (!"true".equals(confirm)) {
            return ResponseEntity.badRequest()
                    .body(Map.of(
                            "message",
                            "Nothing deleted. Add ?confirm=true to confirm."));
        }

        listOfEmployees.clear();

        return ResponseEntity.ok(
                Map.of("message", "All employees deleted"));
    }

}
