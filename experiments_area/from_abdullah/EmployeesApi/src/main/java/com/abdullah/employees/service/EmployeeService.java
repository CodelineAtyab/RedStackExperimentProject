package com.abdullah.employees.service;

import com.abdullah.employees.Employee;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private ArrayList<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public ArrayList<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(String id) {
        return employees.stream()
                .filter(employee -> id.equals(employee.getId()))
                .findFirst()
                .orElse(null);
    }

    public Employee updateEmployee(String id, Employee updatedEmployee) {
        Employee employee = getEmployee(id);

        if (employee == null) {
            return null;
        }

        employee.setName(updatedEmployee.getName());
        return employee;
    }

    public boolean deleteEmployee(String id) {
        Employee employee = getEmployee(id);

        if (employee == null) {
            return false;
        }

        employees.remove(employee);
        return true;
    }

    public boolean deleteAllEmployees(String confirm) {
        if (!"true".equals(confirm)) {
            return false;
        }

        employees.clear();
        return true;
    }
}