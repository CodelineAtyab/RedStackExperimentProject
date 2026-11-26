package ServiceLayer.ServiceLayer2.Service;




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ServiceLayer.ServiceLayer2.Employee;
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
    public Employee getEmployee( String id) {

        Employee foundEmployee = employees.stream().filter((currEmployee) -> {
            return currEmployee.getId().equals(id);
        }).findFirst().orElse(null);

        return foundEmployee;


    }


    public Employee updateEmployee(String id, Employee updateEmployee) {

        Employee foundEmployee = employees.stream().filter((currEmployee) -> {
            return currEmployee.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundEmployee != null) {
            foundEmployee.setName(updateEmployee.getName());
            return foundEmployee;

        }
        return null;




    }


    public Boolean deleteEmployee( String id) {

        Employee foundEmployee = employees.stream().filter((currEmployee) -> {
            return currEmployee.getId().equals(id);
        }).findFirst().orElse(null);

        if (foundEmployee != null) {
            employees.remove(foundEmployee);
            return true;
        }

        return false;
    }


    public Boolean deleteAllEmployees() {
        employees.clear();
        return true;
    }



}






