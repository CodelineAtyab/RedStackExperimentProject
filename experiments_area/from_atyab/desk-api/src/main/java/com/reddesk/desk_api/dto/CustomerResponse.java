package com.reddesk.desk_api.dto;

public class CustomerResponse {
    public String customerId;
    public String message;
    public String messageType;

    public CustomerResponse(String message, String messageType) {
        this.message = message;
        this.messageType = messageType;
    }

    public CustomerResponse setCustomerId(String customerId, String customerName) {
        this.customerId = customerId + ":" + customerName;
        return this;
    }
}
