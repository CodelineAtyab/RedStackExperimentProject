package com.Employee.EmployeeManagement;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    public List<Employee> employees= new ArrayList<>();


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

    public ResponseEntity<?> getEmployee(@PathVariable String id) {

        Employee foundEmployee = employees.stream().filter((currEmployee) -> {
            return currEmployee.getId().equals(id);
        }).findFirst().orElse(null);

        if(foundEmployee !=null){
            return ResponseEntity.ok(foundEmployee);
        }

        return ResponseEntity.status(404).body("Employee not found");


    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable String id,
            @RequestBody Employee updateEmployee) {

        Employee foundEmployee = employees.stream().filter((currEmployee) -> {
            return currEmployee.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundEmployee != null) {
            foundEmployee.setName(updateEmployee.getName());
            return ResponseEntity.ok(foundEmployee);
        }

        return ResponseEntity.status(404).body("Employee not found");



    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {

        Employee foundEmployee = employees.stream().filter((currEmployee) -> {
            return currEmployee.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundEmployee != null) {
            employees.remove(foundEmployee);
            return ResponseEntity.ok("Employee deleted");
        }

        return ResponseEntity.status(404).body("Employee not found");
    }

    @DeleteMapping
    public Boolean deleteAll(){
        employees.clear();

        return true;
    }


}
