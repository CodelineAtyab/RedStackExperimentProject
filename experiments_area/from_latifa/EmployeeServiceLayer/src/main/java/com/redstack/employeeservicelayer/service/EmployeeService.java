package com.redstack.employeeservicelayer.service;

import com.redstack.employeeservicelayer.model.Employee;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class EmployeeService {
    private ArrayList<Employee> employeesList = new ArrayList<>();

    //get all employees
    public ArrayList<Employee> getAllEmployees(){
        return employeesList;
    }
    //get employee by id
    public Employee getEmployeeById(String id){
        for(Employee currEmployee : employeesList){
            if(currEmployee.id.equals(id)){
                return currEmployee;
            }
        }
        return null;
    }
    //add employee
    public Employee addEmployee(Employee employeeToAdd){
        employeesList.add(employeeToAdd);
        return employeeToAdd;
    }
    //update employee
    public Employee updateEmployee(String id, Employee employeeDetails){
        for(Employee currEmployee : employeesList){
            if(currEmployee.id.equals(id)){
                currEmployee.name = employeeDetails.name;
                return currEmployee;
            }
        }
        return null;
    }
    //delete employee by id
    public String deleteEmployee(String id){
        for(Employee currEmployee : employeesList){
            if(currEmployee.id.equals(id)){
                employeesList.remove(currEmployee);
                return "Employee deleted successfully!";
            }
        }
        return "Employee not found!";
    }
    //delete all employees
    public String deleteAllEmployees(String confirm){
        if(!"true".equals(confirm)){
            return "Please confirm before deleting all employees!";
        }
        employeesList.clear();
        return "All employees deleted successfully!";
    }
}
