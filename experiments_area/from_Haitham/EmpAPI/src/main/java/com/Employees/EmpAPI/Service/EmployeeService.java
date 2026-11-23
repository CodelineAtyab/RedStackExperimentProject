package com.Employees.EmpAPI.Service;

import com.Employees.EmpAPI.Controller.EmployeeController;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<EmployeeController.Employees> emps = new ArrayList<>();


    public List<EmployeeController.Employees> getAllEmp(){

        return emps;
    }


    public EmployeeController.Employees getSpecificId(String id){
        for (int i = 0; i < emps.size(); i++) {
            if(emps.get(i).id().equals(id)){
                return emps.get(i);
            }
        }return null;
    }

    public EmployeeController.Employees newFeedbackk(EmployeeController.Employees newEmp) {
        emps.add(newEmp);
        return newEmp;
    }


    public EmployeeController.Employees updatee(String id, EmployeeController.Employees newEmp){
        for (int i = 0; i < emps.size(); i++) {
            if(emps.get(i).id().equals(id)){
                EmployeeController.Employees xx = new EmployeeController.Employees(emps.get(i).id(), newEmp.name());
                emps.set(i,xx);
                return xx;
            }
        }return null;
    }

    public boolean deletee( String id) {
        for (int i = 0; i < emps.size(); i++) {
            if(emps.get(i).id().equals(id)){
                emps.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAlll (Boolean confirm){
        if (confirm == null || !confirm) {
            return false;
        }

        emps.clear();
        return true;

    }

}
