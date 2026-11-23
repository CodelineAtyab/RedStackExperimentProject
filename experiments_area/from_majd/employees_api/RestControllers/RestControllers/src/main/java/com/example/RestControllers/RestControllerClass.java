package com.example.RestControllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;

@RestController
@RequestMapping("/Employee")

public class RestControllerClass {

    public ArrayList<Employee> employees=new ArrayList<>();
    @GetMapping

    public ArrayList<Employee> getAllEmployees(){

        return employees;
    }

    @GetMapping("/{id}")

    public Employee getOneEmployee(@PathVariable  String id){

        for(Employee EmployeeData: employees){

            if(EmployeeData.getId().equals(id))
                return EmployeeData;

        }
        return null;
    }

    @PostMapping
    public Employee addNewEmployee(@RequestBody Employee newEmployee){

        employees.add(newEmployee);

        return newEmployee;
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id,
                                            @RequestBody Employee employee) {

        for (Employee e : employees) {

            if (e.getId().equals(id)) {

                e.setName(employee.getName());

                return ResponseEntity.ok(e);
            }
        }

        return ResponseEntity.status(404).body("Employee not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {

        for (Employee customer : employees) {

            if (customer.getId().equals(id)) {

                employees.remove(customer);

                return ResponseEntity.ok("Employee deleted successfully");
            }
        }

        return ResponseEntity.status(404).body("Employee not found");
    }



    @DeleteMapping
    public ResponseEntity<?> deleteAllEmployees(@RequestParam String confirm) {

        if (!confirm.equals("true")) {
            return ResponseEntity.badRequest().body("Confirmation required");
        }

        employees.clear();

        return ResponseEntity.ok("All employees deleted");
    }


}