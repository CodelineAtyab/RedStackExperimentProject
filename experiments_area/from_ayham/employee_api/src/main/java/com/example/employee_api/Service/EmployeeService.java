package com.example.employee_api.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.employee_api.Exceptions.EmployeeNotFoundException;
import com.example.employee_api.Model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(String id) {
        return employees.stream()
                .filter(employee -> Objects.equals(employee.getId(), id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee with ID " + id + " not found."));
    }

    public Employee createEmployee(Employee newEmployee) {
        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee updateEmployee(String id, Employee updatedEmployee) {
        Employee existingEmployee = getEmployeeById(id);
        updatedEmployee.setId(id);
        employees.set(employees.indexOf(existingEmployee), updatedEmployee);
        return updatedEmployee;
    }

    public String deleteEmployee(String id) {
        Employee employee = getEmployeeById(id);
        employees.removeIf(existingEmployee -> Objects.equals(existingEmployee.getId(), id));
        return "Employee with ID " + employee.getId() + " deleted successfully.";
    }

    public String deleteAllEmployees(boolean confirm) {
        if (!confirm) {
            return "Deletion cancelled. Send confirm=true to delete all employees.";
        }

        employees.clear();
        return "All employees deleted successfully.";
    }
}
