package com.Employees.EmpAPI;

import java.util.ArrayList;
import java.util.List;

public class StreamPractice {
    public record Emp (String id, String name, String role){}


    public static void main(String[] args) {
        List<Emp> employees = new ArrayList<>();
        employees.add(new Emp("1","Sara","Developer"));
        employees.add(new Emp("2","Ali","Developer"));
        employees.add(new Emp("3","Noor","Designer"));
        employees.add(new Emp("4","Omar","Manager"));
        employees.add(new Emp("5","Mona","Tester"));

        System.out.println("--- Task 1: Developers ---");
        List<Emp> task1 = employees.stream().filter((empl)-> empl.role().equals("Developer")).toList();
        System.out.println(task1);

        System.out.println("--- Task 2: All Employee Names ---");
        List<String> task2 = employees.stream().map(emp -> emp.name()).toList();
        System.out.println(task2);

        System.out.println("--- Task 3: Developer Names ---");
        List<String> task3 = employees.stream().filter((emps) ->emps.role().equals("Developer")).map(emp -> emp.name()).toList();
        System.out.println(task3);

        System.out.println("--- Task 4: Find Employee by ID ---");
        Emp task4 = employees.stream().filter((employe)->employe.id().equals("22")).findFirst().orElse(null) ;
        if(task4 == null){
            System.out.println("not found");
        }else {
            System.out.println( task4);
        }

    }
}
