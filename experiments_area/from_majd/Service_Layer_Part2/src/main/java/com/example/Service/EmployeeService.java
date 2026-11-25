package com.example.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeService {

    public ArrayList<Employee> alEmployees=new ArrayList<>();


    public ArrayList<Employee> getAllEmployees() {
        return alEmployees;
    }

    public Optional<Employee> getEmployeeById(String id) {
        return alEmployees.stream()
                .filter(Employee -> Employee.id.equals(id))
                .findFirst();
    }


    public Employee addEmployee(Employee Employee) {
        alEmployees.add(Employee);
        return Employee;
    }


    public Optional<Employee> updateEmployee(String id, Employee updatedEmployee) {

        Optional<Employee> existingEmployee = getEmployeeById(id);

        if (existingEmployee.isPresent()) {
            existingEmployee.get().name = updatedEmployee.name;
            return existingEmployee;
        }

        return Optional.empty();
    }


    public boolean deleteEmployee(String id) {
        return alEmployees.removeIf(Employee -> Employee.id.equals(id));
    }

    public void deleteAllEmployees() {
        alEmployees.clear();
    }



}
