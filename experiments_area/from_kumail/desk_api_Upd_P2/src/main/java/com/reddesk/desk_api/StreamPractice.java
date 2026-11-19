
package com.reddesk.desk_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice {

    static class PracticeEmployee {

        String id;
        String name;
        String role;

        PracticeEmployee(String id, String name, String role) {
            this.id = id;
            this.name = name;
            this.role = role;
        }

        @Override
        public String toString() {
            return name + " - " + role;
        }
    }

    public static void main(String[] args) {

        List<PracticeEmployee> employees = Arrays.asList(
                new PracticeEmployee("1", "Kumail", "SOC analysis"),
                new PracticeEmployee("2", "Haitham", "Developer"),
                new PracticeEmployee("3", "Majd", "Designer")
        );

        System.out.println("--- Task 1: Developers ---");

        employees.stream()
                .filter(employee -> employee.role.equals("Developer"))
                .forEach(System.out::println);


        System.out.println("--- Task 2: Employee Names ---");

        List<String> names = employees.stream()
                .map(employee -> employee.name)
                .collect(Collectors.toList());

        System.out.println(names);

        System.out.println("--- Task 3: Developer Names ---");

        List<String> developerNames = employees.stream()
                .filter(employee -> employee.role.equals("Developer"))
                .map(employee -> employee.name)
                .collect(Collectors.toList());

        System.out.println(developerNames);

        System.out.println("--- Task 4: Find Employee ---");

        String id = "1";

        String result = employees.stream()
                .filter(employee -> employee.id.equals(id))
                .findFirst()
                .map(employee -> employee.name)
                .orElse("Employee not found");

        System.out.println(result);
    }
}
