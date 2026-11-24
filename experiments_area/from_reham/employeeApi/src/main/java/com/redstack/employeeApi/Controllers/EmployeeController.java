package com.redstack.employeeApi.Controllers;

import java.util.ArrayList;
import java.util.List;
import com.redstack.employeeApi.Employee;
import com.redstack.employeeApi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    private ArrayList<Employee> employees = new ArrayList<>(); // Store employees here
    // 2. POST - Add employee
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(
                employeeService.addEmployee(employee),
                HttpStatus.CREATED
        );
    }

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
    // 3. GET one employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable int id) {

        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee not found");
        }

        return ResponseEntity.ok(employee);
    }

    // 4. PUT - Update employee
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable int id,
            @RequestBody Employee updatedEmployee) {

        if (updatedEmployee.getId() != id) {
            return ResponseEntity.badRequest()
                    .body("Employee ID must match the URL ID");
        }

        Employee employee = employeeService.updateEmployee(id, updatedEmployee);

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee not found");
        }

        return ResponseEntity.ok(employee);
    }

    // 5. DELETE one employee
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {

        Employee employee = employeeService.deleteEmployee(id);

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee not found");
        }

        return ResponseEntity.ok(
                "Employee " + employee.getName() + " deleted successfully"
        );
    }



    // 6. DELETE all employees
    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployees(
            @RequestParam(required = false) String confirm) {

        if (!"true".equals(confirm)) {
            return ResponseEntity.badRequest()
                    .body("Please provide confirm=true to delete all employees");
        }

        employeeService.deleteAllEmployees();

        return ResponseEntity.ok("All employees deleted successfully");
    }
}






