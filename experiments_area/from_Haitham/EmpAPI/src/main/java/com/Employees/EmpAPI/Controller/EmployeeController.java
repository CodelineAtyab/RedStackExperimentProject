package com.Employees.EmpAPI.Controller;

import com.Employees.EmpAPI.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    public record Employees (String id,String name){};
    @Autowired
    EmployeeService employeeService;


    @GetMapping
    public ResponseEntity<?> getEmp(){
        List<Employees> emp = employeeService.getAllEmp();
        return ResponseEntity.ok(emp);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getSpecific(@PathVariable String id){
        Employees emp = employeeService.getSpecificId(id);
        if(emp != null){
            return ResponseEntity.ok(emp);
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Employee with ID " + id + " not found.");
        }
    }


    @PostMapping
    public ResponseEntity<Employees> newFeedback(@RequestBody Employees newEmp){
        Employees saved = employeeService.newFeedbackk(newEmp);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable String id,@RequestBody Employees newEmp){
        Employees updated = employeeService.updatee(id, newEmp);
        if(updated != null) {
            return ResponseEntity.ok(updated);
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Cannot update. Employee with ID " + id + " not found.");
        }
    }



    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
         boolean check = employeeService.deletee(id);
         if(check){
            return ResponseEntity.ok("Employee " + id + " deleted.");

         }else {
             return ResponseEntity
                     .status(HttpStatus.NOT_FOUND) // 404 Not Found
                     .body("Cannot delete. Employee with ID " + id + " not found.");
         }
    }



    @DeleteMapping
    public ResponseEntity<?> deleteAll (@RequestParam(required = false) Boolean confirm){
        boolean check = employeeService.deleteAlll(confirm);
        if(!check){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST) // 400 Bad Request
                    .body("Confirmation required. Add ?confirm=true to delete all employees.");
        }else {
            return ResponseEntity.ok("All employees deleted.");
        }

    }
}
