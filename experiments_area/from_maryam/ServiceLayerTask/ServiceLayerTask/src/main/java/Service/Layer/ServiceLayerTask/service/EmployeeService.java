package Service.Layer.ServiceLayerTask.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Service.Layer.ServiceLayerTask.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    // her use ArrayList too store the data
    public List<Employee> employees= new ArrayList<>();



    public Employee addEmployee( Employee employee){

        employees.add(employee);
        return employee;
    }


    public List<Employee> getAllEmployees(){
        return employees;

    }

    // it receives an employee id and uses>> by use stream() and filter() to search for an employee id matches the requested id.
    // then findFirst() gets the first matching employee and orElse(null) returns null if no employee is found
    public ResponseEntity<?> getEmployee( String id) {

        Employee foundEmployee = employees.stream().filter((currEmployee) -> {
            return currEmployee.getId().equals(id);
        }).findFirst().orElse(null);

        if(foundEmployee !=null){
            return ResponseEntity.ok(foundEmployee);
        }

        return ResponseEntity.status(404).body("Employee not found");


    }


    public ResponseEntity<?> updateEmployee(
            String id,
            Employee updateEmployee) {

        Employee foundEmployee = employees.stream().filter((currEmployee) -> {
            return currEmployee.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundEmployee != null) {
            foundEmployee.setName(updateEmployee.getName());
            return ResponseEntity.ok(foundEmployee);
        }

        return ResponseEntity.status(404).body("Employee not found");



    }


    public ResponseEntity<?> deleteEmployee( String id) {

        Employee foundEmployee = employees.stream().filter((currEmployee) -> {
            return currEmployee.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundEmployee != null) {
            employees.remove(foundEmployee);
            return ResponseEntity.ok("Employee deleted");
        }

        return ResponseEntity.status(404).body("Employee not found");
    }


    public Boolean deleteAllEmployees() {
        employees.clear();
        return true;
    }



}


