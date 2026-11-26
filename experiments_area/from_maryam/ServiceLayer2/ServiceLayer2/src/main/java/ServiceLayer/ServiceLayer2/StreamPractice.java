package ServiceLayer.ServiceLayer2;


import java.util.ArrayList;
import java.util.List;

public class StreamPractice {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("1", "Sara", "Developer"));
        employees.add(new Employee("2", "Ali", "Developer"));
        employees.add(new Employee("3", "Noor", "Designer"));


        // Task 1 1: filter
        // filter employees who have the Developer role
        System.out.println("Filter Result:");

        List<Employee> developers = employees.stream()
                .filter(employee -> employee.getRole().equals("Developer"))
                .toList();

        developers.forEach(employee -> System.out.println(employee.getName()));


        // Task 2: map
        // Get the names of all employees
        System.out.println("Employee Names:");

        List<String> names = employees.stream()
                .map(employee -> employee.getName())
                .toList();

        System.out.println(names);


        // Task 3: filter then map
        // filter developers and get their names

        System.out.println("Developers List:");

        List<String> developerNames = employees.stream()
                .filter(employee -> employee.getRole().equals("Developer"))
                .map(employee -> employee.getName())
                .toList();

        System.out.println(developerNames);


        // Task 4: filter + findFtrst
        // find the first employee with ID 2
        System.out.println("Employee Search:");

        Employee foundEmployee = employees.stream()
                .filter(employee -> employee.getId().equals("2"))
                .findFirst()
                .orElse(null);

        if (foundEmployee != null) {
            System.out.println(foundEmployee.getName());
        } else {
            System.out.println("not found");
        }

    }
}
