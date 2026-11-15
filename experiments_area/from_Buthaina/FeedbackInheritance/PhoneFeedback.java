package com.FeedbackInheritance;



    public class PhoneFeedback extends Feedback {

        // Extra private fields
        private String phoneNumber;
        private int callMinutes;

        // Constructor
        public PhoneFeedback(int id, String customerName,
                             String message, int rating,
                             String phoneNumber, int callMinutes) {

            super(id, customerName, message, rating);

            this.phoneNumber = phoneNumber;
            this.callMinutes = callMinutes;
        }

        // Getters
        public String getPhoneNumber() {
            return phoneNumber;
        }

        public int getCallMinutes() {
            return callMinutes;
        }

        // Implement abstract method
        @Override
        public String getSummary() {
            return "[Phone] " + getCustomerName()
                    + " " + getPhoneNumber() + ", "
                    + getCallMinutes() + " min: "
                    + getMessage() + " (" + getRating() + "/5)";
        }
    }

