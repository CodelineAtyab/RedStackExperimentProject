package com.Employees.EmpAPI.Service;

import com.Employees.EmpAPI.Controller.EmployeeController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<EmployeeController.Employees> emps = new ArrayList<>();


    public List<EmployeeController.Employees> getAllEmp(){
        return emps;
    }


    public ResponseEntity<?> getSpecificId(String id){
        for (int i = 0; i < emps.size(); i++) {
            if(emps.get(i).id().equals(id)){
                return ResponseEntity.ok(emps.get(i));
            }
        }return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Employee with ID " + id + " not found.");
    }

    public EmployeeController.Employees newFeedbackk(EmployeeController.Employees newEmp) {
        emps.add(newEmp);
        return newEmp;
    }


    public ResponseEntity<?> updatee(String id, EmployeeController.Employees newEmp){
        for (int i = 0; i < emps.size(); i++) {
            if(emps.get(i).id().equals(id)){
                EmployeeController.Employees xx = new EmployeeController.Employees(emps.get(i).id(), newEmp.name());
                emps.set(i,xx);
                return ResponseEntity.ok(xx);
            }
        }return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Cannot update. Employee with ID " + id + " not found.");
    }

    public ResponseEntity<?> deletee( String id) {
        for (int i = 0; i < emps.size(); i++) {
            if(emps.get(i).id().equals(id)){
                emps.remove(i);
                return ResponseEntity.ok(emps);
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND) // 404 Not Found
                .body("Cannot delete. Employee with ID " + id + " not found.");
    }

    public ResponseEntity<?> deleteAlll (Boolean confirm){
        if (confirm == null || !confirm) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST) // 400 Bad Request
                    .body("Confirmation required. Add ?confirm=true to delete all employees.");
        }

        emps.clear();
        return ResponseEntity.ok("All employees deleted.");

    }

}
