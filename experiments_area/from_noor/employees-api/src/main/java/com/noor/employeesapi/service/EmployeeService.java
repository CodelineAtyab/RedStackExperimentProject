
package com.noor.employeesapi.service;

import com.noor.employeesapi.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    // GET all employees
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // GET employee by ID
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // POST create employee
    public Employee addEmployee(Employee employee) {
        for (Employee existing : employees) {
            if (existing.getId() == employee.getId()) {
                return null;
            }
        }

        employees.add(employee);
        return employee;
    }

    // PUT update employee
    public Employee updateEmployee(int id, Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(updatedEmployee.getName());
                employee.setDepartment(updatedEmployee.getDepartment());
                return employee;
            }
        }
        return null;
    }

    // DELETE employee
    public String deleteEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                return "Employee deleted successfully";
            }
        }
        return "Employee not found";
    }

    // DELETE all employees
    public String deleteAllEmployees() {
        employees.clear();
        return "All employees deleted successfully";
    }
}
