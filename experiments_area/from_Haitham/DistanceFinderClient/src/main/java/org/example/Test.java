package org.example;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class Test {
    public static void main(String[] args) {
        HttpResponse<String> response = Unirest.get("http://192.168.100.164:8091/greet?name=Haitham").asString();
        System.out.println(response.getBody());

    }
}
