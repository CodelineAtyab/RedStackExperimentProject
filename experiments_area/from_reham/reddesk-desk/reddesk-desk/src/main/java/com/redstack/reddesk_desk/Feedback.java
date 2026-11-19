package com.redstack.reddesk_desk;
import java.util.ArrayList;

public class Feedback {
    //Declare Var
    public Integer id;
    public String name ;
    public String message ;

    public Feedback() {}
    //Constructor to help create an object
    public Feedback(Integer id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }
}
