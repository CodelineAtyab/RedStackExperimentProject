package com.reddesk.desk_api.Controller;

import com.reddesk.desk_api.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    ArrayList<Employee> listOfEmployees =  new ArrayList<>();

    @GetMapping
    public ArrayList<Employee> getAllEmployees() {
        return listOfEmployees;
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Employee> getSpecificEmployee(@PathVariable String id) {

        Employee foundEmployee = listOfEmployees.stream()
                .filter(employee -> employee.id.equals(id))
                .findFirst()
                .orElse(null);
        if (foundEmployee == null) {
            return ResponseEntity.status(404)
                    .body((Employee) Map.of("message", "Employee not found"));
        }

        return ResponseEntity.ok(foundEmployee);
    }

    @PostMapping
    public Employee registerEmployee(@RequestBody Employee incomingEmployeeObj) {

        listOfEmployees.add(incomingEmployeeObj);

        return incomingEmployeeObj;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        Employee foundEmployee = listOfEmployees.stream()
                .filter(employee -> employee.id.equals(id))
                .findFirst()
                .orElse(null);

        if (foundEmployee == null) {
            return ResponseEntity.status(404)
                    .body(Map.of("message", "Employee not found"));
        }

        foundEmployee.name = updatedEmployee.name;
        return ResponseEntity.ok(foundEmployee);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {

        boolean removed = listOfEmployees.removeIf(
                employee -> employee.id.equals(id)
        );

        if (!removed) {
            return ResponseEntity.status(404)
                    .body(Map.of("message", "Employee not found"));
        }

        return ResponseEntity.ok(
                Map.of("message", "Employee deleted")
        );
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllEmployees(
            @RequestParam(required = false) String confirm) {

        if (!"true".equals(confirm)) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "Confirmation required: confirm=true"));
        }

        listOfEmployees.clear();

        return ResponseEntity.ok(
                Map.of("message", "All employees deleted")
        );
    }
}
