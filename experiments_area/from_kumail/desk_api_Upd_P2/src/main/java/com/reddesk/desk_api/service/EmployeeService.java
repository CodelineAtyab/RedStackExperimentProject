package com.reddesk.desk_api.service;

import com.reddesk.desk_api.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(String id) {
        return employees.stream()
                .filter(employee -> employee.id.equals(id))
                .findFirst()
                .orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee updateEmployee(String id, Employee updatedEmployee) {
        return employees.stream()
                .filter(employee -> employee.id.equals(id))
                .findFirst()
                .map(employee -> {
                    employee.name = updatedEmployee.name;
                    return employee;
                })
                .orElse(null);
    }

    public boolean deleteEmployee(String id) {
        return employees.removeIf(
                employee -> employee.id.equals(id)
        );
    }

    public String deleteAllEmployees() {
        employees.clear();
        return "All employees deleted";
    }
}
