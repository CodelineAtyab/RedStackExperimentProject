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
    public List<Employees> getEmp(){
        return employeeService.getAllEmp();
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getSpecific(@PathVariable String id){return employeeService.getSpecificId(id);}


    @PostMapping
    public Employees newFeedback(@RequestBody Employees newEmp){return employeeService.newFeedbackk(newEmp);}


    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable String id,@RequestBody Employees newEmp){return employeeService.updatee(id, newEmp);}



    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {return employeeService.deletee(id);}



    @DeleteMapping
    public ResponseEntity<?> deleteAll (@RequestParam(required = false) Boolean confirm){return employeeService.deleteAlll(confirm);}
}
