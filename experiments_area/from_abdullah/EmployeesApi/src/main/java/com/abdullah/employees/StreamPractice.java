package com.abdullah.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamPractice {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(createEmployee("1", "Sara"));
        employees.add(createEmployee("2", "Ali"));
        employees.add(createEmployee("3", "Salim"));
        employees.add(createEmployee("4", "Noor"));

        System.out.println("--- Task 1: names starting with S ---");

        employees.stream()
                .filter(employee -> employee.getName().startsWith("S"))
                .forEach(employee -> System.out.println(
                        employee.getId() + " - " + employee.getName()));

        System.out.println("--- Task 2: all names ---");

        List<String> names = employees.stream()
                .map(employee -> employee.getName())
                .toList();

        System.out.println(names);

        System.out.println("--- Task 3: filter then map ---");

        List<String> selectedNames = employees.stream()
                .filter(employee -> employee.getName().startsWith("S"))
                .map(employee -> employee.getName())
                .toList();

        System.out.println(selectedNames);

        System.out.println("--- Task 4: find employee ---");

        printEmployee(employees, "2");
        printEmployee(employees, "99");
    }

    private static Employee createEmployee(String id, String name) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        return employee;
    }

    private static void printEmployee(
            ArrayList<Employee> employees, String id) {

        Optional<Employee> found = employees.stream()
                .filter(employee -> id.equals(employee.getId()))
                .findFirst();

        if (found.isPresent()) {
            System.out.println(id + ": " + found.get().getName());
        } else {
            System.out.println(id + ": not found");
        }
    }
}