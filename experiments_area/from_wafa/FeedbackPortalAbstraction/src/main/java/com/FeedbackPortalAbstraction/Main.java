package com.FeedbackPortalAbstraction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        WebFormFeedback f = new WebFormFeedback("Wafa",1, "Great service", 5);

        System.out.println(f.getSummary());

        //FeedbackPortalEncapsulation f1 = new FeedbackPortalEncapsulation("wafa" , 2, "good service", 4);
        //System.out.println(f1.getSummary());
        // 'FeedbackPortalEncapsulation' is abstract cannot to instantiated because it contains abstract method without bodies and is meant be subclasss
    }
}