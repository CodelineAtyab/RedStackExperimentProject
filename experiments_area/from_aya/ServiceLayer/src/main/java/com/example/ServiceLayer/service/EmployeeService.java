package com.example.ServiceLayer.service;

import com.example.ServiceLayer.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    // POST
    public ResponseEntity<Employee> addEmployee(Employee employee) {
        employees.add(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Get employee by ID
    public ResponseEntity<?> getEmployee(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return new ResponseEntity<>(employee, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
    }

    // PUT
    public ResponseEntity<?> updateEmployee(String id, Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employee.setName(updatedEmployee.getName());
                return new ResponseEntity<>(employee, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("nothing deleted", HttpStatus.NOT_FOUND);
    }

    // DELETE
    public ResponseEntity<?> deleteEmployee(String id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                employees.remove(i);
                return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("nothing deleted", HttpStatus.NOT_FOUND);
    }

    // Delete all employees
    public ResponseEntity<String> deleteAllEmployees(String confirm) {
        if (!"true".equals(confirm)) {
            return new ResponseEntity<>(
                    "Please confirm deletion using confirm=true",
                    HttpStatus.BAD_REQUEST
            );
        }

        employees.clear();
        return new ResponseEntity<>(
                "all removed",
                HttpStatus.OK
        );
    }
}
