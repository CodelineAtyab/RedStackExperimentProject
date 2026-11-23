package com.example.Feedback.CRUD.API;


public class Feedback {

    private String id;
    private String name;
    private String message;


    public Feedback(String id, String name, String message){
        this.id=id;
        this.name=name;
        this.message=message;

    }


    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }


    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message=message;
    }


}
