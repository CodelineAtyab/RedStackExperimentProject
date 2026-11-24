package com.redstack.employeeApi.services;

import com.redstack.employeeApi.Employee;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    // 2. POST - Add employee
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    // 3. GET one employee by ID
    public Employee getEmployee(int id) {

        Employee employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

        return employee;
    }

    // 4. PUT - Update employee
    public Employee updateEmployee(int id, Employee updatedEmployee) {

        Employee employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

        if (employee == null) {
            return null;
        }

        if (updatedEmployee.getId() != id) {
            return null;
        }

        employee.setName(updatedEmployee.getName());

        return employee;
    }


    // 5. DELETE one employee
    public Employee deleteEmployee(int id) {

        Employee employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);

        if (employee == null) {
            return null;
        }

        employees.remove(employee);

        return employee;
    }


    // 6. DELETE all employees
    public void deleteAllEmployees() {
        employees.clear();
    }


}
