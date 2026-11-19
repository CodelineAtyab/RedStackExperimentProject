package com.reddesk.desk_api.Services;

import com.reddesk.desk_api.Models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    public List<Employee> findAll() {
        return employees;
    }

    public Optional<Employee> findById(String id) {
        return employees.stream()
                .filter(emp -> id.equals(emp.getId()))
                .findFirst();
    }

    public Employee create(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Optional<Employee> update(String id, Employee updatedData) {
        Optional<Employee> existingOpt = findById(id);
        if (existingOpt.isEmpty()) {
            return Optional.empty();
        }
        Employee existing = existingOpt.get();
        if (updatedData.getName() != null) {
            existing.setName(updatedData.getName());
        }
        if (updatedData.getRole() != null) {
            existing.setRole(updatedData.getRole());
        }
        return Optional.of(existing);
    }

    public boolean deleteById(String id) {
        Optional<Employee> existingOpt = findById(id);
        if (existingOpt.isEmpty()) {
            return false;
        }
        employees.remove(existingOpt.get());
        return true;
    }

    public void deleteAll() {
        employees.clear();
    }
}