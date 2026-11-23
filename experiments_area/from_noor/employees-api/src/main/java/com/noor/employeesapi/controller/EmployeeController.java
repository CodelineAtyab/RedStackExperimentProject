
package com.noor.employeesapi.controller;

import com.noor.employeesapi.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final List<Employee> employeeList = new ArrayList<>();

    // GET all employees   http://localhost:8080/employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // GET employee by ID     http://localhost:8080/employees/2
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(
            @PathVariable int id) {

        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                return ResponseEntity.ok(emp);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // POST create employee
    @PostMapping
    public ResponseEntity<Employee> addEmployee(
            @RequestBody Employee employee) {

        for (Employee existing : employeeList) {
            if (existing.getId() == employee.getId()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        }

        employeeList.add(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    // PUT update employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable int id,
            @RequestBody Employee updatedEmp) {

        for (Employee emp: employeeList) {
            if (emp.getId() == id) {
                emp.setName(updatedEmp.getName());
                emp.setDepartment(updatedEmp.getDepartment());

                return ResponseEntity.ok(emp);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(
            @PathVariable int id) {

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                employeeList.remove(i);
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }
}
