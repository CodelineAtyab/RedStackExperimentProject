package com.redstack.EmployeesApi.service;

import com.redstack.EmployeesApi.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Optional<Employee> getEmployeeById(String id) {
        return employees.stream()
                .filter(employee -> employee.id.equals(id))
                .findFirst();
    }

    public Employee createEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Optional<Employee> updateEmployee(String id, Employee changes) {
        Optional<Employee> foundEmployee = getEmployeeById(id);

        if (foundEmployee.isEmpty()) {
            return Optional.empty();
        }

        Employee employee = foundEmployee.get();

        if (changes.name != null) {
            employee.name = changes.name;
        }

        return Optional.of(employee);
    }

    public Optional<Employee> deleteEmployee(String id) {
        Optional<Employee> foundEmployee = getEmployeeById(id);

        foundEmployee.ifPresent(employees::remove);
        return foundEmployee;
    }

    public boolean deleteAllEmployees(String confirm) {
        if (!"true".equals(confirm)) {
            return false;
        }

        employees.clear();
        return true;
    }
}