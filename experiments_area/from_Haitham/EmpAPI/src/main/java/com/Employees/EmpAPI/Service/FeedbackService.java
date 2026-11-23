package com.Employees.EmpAPI.Service;

import com.Employees.EmpAPI.Controller.CustomerController;
import com.Employees.EmpAPI.Controller.FeedbackController;
import com.Employees.EmpAPI.Models.Customer;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {
    public static List<FeedbackController.Feedback> listOfFeedback = new ArrayList<>();


    public List<FeedbackController.Feedback> getAllFeedback(){

        return listOfFeedback;
    }


    public FeedbackController.Feedback getSpecificId(String id){
        for (int i = 0; i < listOfFeedback.size(); i++) {
            if(listOfFeedback.get(i).id().equals(id)){
                return listOfFeedback.get(i);
            }
        }return null;
    }

    public FeedbackController.Feedback newFeedbackk(FeedbackController.Feedback newFeed) {
        if (newFeed.customerId() == null || newFeed.customerId().isEmpty()) {
            return null;
        }
        boolean customerExists = false;
        for (Customer customer : CustomerController.listOfCustomers) {
            if (customer.id().equals(newFeed.customerId())) {
                customerExists = true;
                break;
            }
        }
        if (!customerExists) {
            return null;
        }
        listOfFeedback.add(newFeed);
        return newFeed;
    }


    public FeedbackController.Feedback updatee(String id, FeedbackController.Feedback newFeed){
        for (int i = 0; i < listOfFeedback.size(); i++) {
            if(listOfFeedback.get(i).id().equals(id)){
                FeedbackController.Feedback xx = new FeedbackController.Feedback(listOfFeedback.get(i).id(), newFeed.message(), listOfFeedback.get(i).customerId());
                listOfFeedback.set(i,xx);
                return xx;
            }
        }return null;
    }

    public boolean deletee( String id) {
        for (int i = 0; i < listOfFeedback.size(); i++) {
            if(listOfFeedback.get(i).id().equals(id)){
                listOfFeedback.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAlll (Boolean confirm){
        if (confirm == null || !confirm) {
            return false;
        }

        listOfFeedback.clear();
        return true;

    }

}
