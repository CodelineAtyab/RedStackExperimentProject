package com.feedbackportaabstraction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

        public static void main(String[] args) {
            WebFormFeedback f = new WebFormFeedback(1, "Aisha", "Great service", 5);
            System.out.println(f.getSummary());
        }

}