package com.Employees.EmpAPI.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    public record Employees (String id,String name){};
    List<Employees> emps = new ArrayList<>();

    @GetMapping
    public List<Employees> getEmp(){
        return emps;
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getSpecific(@PathVariable String id){
        for (int i = 0; i < emps.size(); i++) {
            if(emps.get(i).id().equals(id)){
                return ResponseEntity.ok(emps.get(i));
            }
        }return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Employee with ID " + id + " not found.");
    }
    @PostMapping
    public Employees newFeedback(@RequestBody Employees newEmp){
        emps.add(newEmp);
        return newEmp;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable String id,@RequestBody Employees newEmp){
        for (int i = 0; i < emps.size(); i++) {
            if(emps.get(i).id().equals(id)){
                Employees xx = new Employees(emps.get(i).id(), newEmp.name);
                emps.set(i,xx);
                return ResponseEntity.ok(xx);
            }
        }return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Cannot update. Employee with ID " + id + " not found.");
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        for (int i = 0; i < emps.size(); i++) {
            if(emps.get(i).id().equals(id)){
                emps.remove(i);
                return ResponseEntity.ok(emps);
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND) // 404 Not Found
                .body("Cannot delete. Employee with ID " + id + " not found.");
    }
    @DeleteMapping
    public ResponseEntity<?> deleteAll (@RequestParam(required = false) Boolean confirm){
        if (confirm == null || !confirm) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST) // 400 Bad Request
                    .body("Confirmation required. Add ?confirm=true to delete all employees.");
        }

        emps.clear();
        return ResponseEntity.ok("All employees deleted.");

    }
}
