package com.example.employee_api.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.employee_api.Model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Optional<Employee> getEmployeeById(String id) {
        return employees.stream()
                .filter(employee -> Objects.equals(employee.getId(), id))
                .findFirst();
    }

    public Employee createEmployee(Employee newEmployee) {
        employees.add(newEmployee);
        return newEmployee;
    }

    public Optional<Employee> updateEmployee(String id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = getEmployeeById(id);
        if (existingEmployee.isEmpty()) {
            return Optional.empty();
        }

        updatedEmployee.setId(id);
        employees.set(employees.indexOf(existingEmployee.get()), updatedEmployee);
        return Optional.of(updatedEmployee);
    }

    public Optional<Employee> deleteEmployee(String id) {
        Optional<Employee> employee = getEmployeeById(id);
        if (employee.isEmpty()) {
            return Optional.empty();
        }

        employees.removeIf(existingEmployee -> Objects.equals(existingEmployee.getId(), id));
        return employee;
    }

    public String deleteAllEmployees(boolean confirm) {
        if (!confirm) {
            return "Deletion cancelled. Send confirm=true to delete all employees.";
        }

        employees.clear();
        return "All employees deleted successfully.";
    }
}
