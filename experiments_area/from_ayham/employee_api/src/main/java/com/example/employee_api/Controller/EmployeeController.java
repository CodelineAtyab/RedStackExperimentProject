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
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee newEmployee) {
        return employeeService.createEmployee(newEmployee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(id, updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable String id) {
        return employeeService.deleteEmployee(id);
    }

    @DeleteMapping
    public String deleteAllEmployees(@RequestParam(required = false, defaultValue = "false") boolean confirm) {
        return employeeService.deleteAllEmployees(confirm);
    }
}
