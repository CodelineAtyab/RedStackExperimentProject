package ServiceLayer.ServiceLayer2.Controller;

import ServiceLayer.ServiceLayer2.Employee;
import ServiceLayer.ServiceLayer2.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){

        Employee newEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.status(201).body(newEmployee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable String id){
        Employee foundEmployee = employeeService.getEmployee(id);

        if(foundEmployee !=null){

            return ResponseEntity.ok(foundEmployee);
        }

        return ResponseEntity.status(404).body("Employee " + id + " not found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id , @RequestBody Employee updateEmployee){
        Employee foundEmployee = employeeService.updateEmployee(id,updateEmployee );

        if(foundEmployee !=null){

            return ResponseEntity.ok(foundEmployee);
        }

        return ResponseEntity.status(404).body("Employee " + id + " not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id){

        Boolean deleted = employeeService.deleteEmployee(id);

        if(deleted){

            return ResponseEntity.ok("Employee " + id + " deleted");
        }

        return ResponseEntity.status(404).body("Employee " + id + " not found");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployee() {

        employeeService.deleteAllEmployees();
        return ResponseEntity.ok("All employees deleted");
    }


}

