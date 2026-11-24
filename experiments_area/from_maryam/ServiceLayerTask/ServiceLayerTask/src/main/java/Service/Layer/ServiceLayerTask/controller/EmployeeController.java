package Service.Layer.ServiceLayerTask.controller;
import Service.Layer.ServiceLayerTask.Employee;
import Service.Layer.ServiceLayerTask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;



    // use @RequestBody receives the employee data from the HTTP request body and converts it into an Employee object
    @PostMapping
     public Employee addEmployee (@RequestBody Employee employee){
        return  employeeService.addEmployee(employee);
    }

    //use @GetMapping to receive a GET request to retrieve all employees
    // Then call getAllEmployees() from the Service and return the list of employees
    @GetMapping
    public List<Employee> getAllEmployees(){

        return employeeService.getAllEmployees();
    }

    //use @GetMapping("/{id}") to receive a GET request with the employee id in the url.
    // and use @PathVariable annotation extracts the ID from the url.
    @GetMapping("/{id}")
    //@PathVariable >>> allows to return different types of responses
    // for example>> employee data if found or an error message if not found.
    public ResponseEntity<?> getEmployee(@PathVariable String id) {

        return employeeService.getEmployee(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable String id, @RequestBody Employee updateEmployee) {
        return employeeService.updateEmployee(id, updateEmployee);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id){

        return employeeService.deleteEmployee(id);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployee(
            @RequestParam(required = false) String confirm) {

        if (!"true".equals(confirm)) {
            return ResponseEntity.badRequest()
                    .body("Please confirm before deleting all employees");
        }

        employeeService.deleteAllEmployees();
        return ResponseEntity.ok("All employees deleted");
    }

}


