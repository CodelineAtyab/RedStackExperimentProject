package com.redstack.EmployeesApi.controller;


import com.redstack.EmployeesApi.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
//Sets the main URL for all endpoints
@RequestMapping("/employees")
public class EmployeeController {
    ArrayList<Employee> employeesList = new ArrayList<>();

    //Returns and get all employees
    @GetMapping
    public ArrayList<Employee> getAllEmployees(){
        return employeesList;
    }

    //get one employee by id
    @GetMapping("/{id}") // URL contains an ID
    public ResponseEntity<?> getEmployeeById(@PathVariable String id) {

        // Search in employeesList
        for (Employee currEmployee : employeesList) {

            if (currEmployee.id.equals(id)) {
                //ResponseEntity.ok() returns HTTP status 200 OK.
                return ResponseEntity.ok(currEmployee);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Employee not found!"));
    }

    //Add employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee newEmployee){
        employeesList.add(newEmployee);
        return newEmployee;
    }

    //put Or Replace data , update
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable String id,
            @RequestBody Employee updatedEmployee) {

        for (Employee currEmployee : employeesList) {

            if (currEmployee.id.equals(id)) {

                currEmployee.name = updatedEmployee.name;
                return ResponseEntity.ok(currEmployee);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Employee not found!"));
    }

    // Delete specific employee
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {

        Employee foundEmployee = null;

        for (Employee currEmployee : employeesList) {

            if (currEmployee.id.equals(id)) {
                foundEmployee = currEmployee;
                break;
            }
        }

        if (foundEmployee != null) {

            employeesList.remove(foundEmployee);
            return ResponseEntity.ok(
                    Map.of("message", "Employee deleted successfully!")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", "Employee not found!"));
    }

    // Delete all employees with confirmation
    @DeleteMapping
    public ResponseEntity<?> deleteAllEmployees(
            @RequestParam(required = false) String confirm) {

        if (!"true".equals(confirm)) {

            return ResponseEntity.badRequest()
                    .body(Map.of("message", "Please confirm before deleting all employees!"));
        }
        employeesList.clear();
        return ResponseEntity.ok(
                Map.of("message", "All employees deleted successfully!")
        );
    }



}
















