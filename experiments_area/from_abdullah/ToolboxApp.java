package ToolboxApp;

import java.util.Scanner;

public class ToolboxApp {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            menu();
            choice = readInt("Choose an option: ");

            switch (choice) {
                case 1:
                    celsiusToFahrenheit();
                    break;

                case 2:
                    evenOrOdd();
                    break;

                case 3:
                    maxOfThree();
                    break;

                case 4:
                    factorial();
                    break;

                case 5:
                    multiplicationTable();
                    break;

                case 6:
                    starTriangle();
                    break;

                case 7:
                    isPrime();
                    break;

                case 8:
                    reverseNumber();
                    break;

                case 9:
                    numberPyramid();
                    break;

                case 10:
                    starDiamond();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Enter 0 to 10.");
            }

            System.out.println();

        } while (choice != 0);

        input.close();
    }

    public static void menu() {
        System.out.println("AYS-115's Java Toolbox ");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Even or odd");
        System.out.println("3. Maximum of three numbers");
        System.out.println("4. Factorial");
        System.out.println("5. Multiplication table");
        System.out.println("6. Triangle of stars");
        System.out.println("7. Prime check");
        System.out.println("8. Reverse a number");
        System.out.println("9. Number pyramid");
        System.out.println("10. Diamond of stars");
        System.out.println("0. Exit");
    }

    // for a valid integer
    public static int readInt(String message) {
        System.out.print(message);

        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Enter a whole number.");
            input.next();
            System.out.print(message);
        }

        return input.nextInt();
    }

    // for a valid decimal number
    public static double readDouble(String message) {
        System.out.print(message);

        while (!input.hasNextDouble()) {
            System.out.println("Invalid input. Enter a number.");
            input.next();
            System.out.print(message);
        }

        return input.nextDouble();
    }

    public static void celsiusToFahrenheit() {
        double celsius = readDouble("Enter temperature in Celsius: ");
        double fahrenheit = celsius * 9.0 / 5.0 + 32;

        System.out.println("Fahrenheit: " + fahrenheit);
    }

    public static void evenOrOdd() {
        int number = readInt("Enter an integer: ");

        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }

    public static void maxOfThree() {
        int first = readInt("Enter the first integer: ");
        int second = readInt("Enter the second integer: ");
        int third = readInt("Enter the third integer: ");

        int largest = first;

        if (second > largest) {
            largest = second;
        }

        if (third > largest) {
            largest = third;
        }

        System.out.println("The largest number is " + largest);
    }

    public static void factorial() {
        int number = readInt("Enter a number from 0 to 15: ");

        if (number < 0 || number > 15) {
            System.out.println("Number must be between 0 and 15.");
            return;
        }

        long result = 1;

        for (int i = 1; i <= number; i++) {
            result = result * i;
        }

        System.out.println(number + "! = " + result);
    }

    public static void multiplicationTable() {
        int number = readInt("Enter an integer: ");

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = "
                    + ((long) number * i));
        }
    }

    public static void starTriangle() {
        int rows = readInt("Enter the number of rows: ");

        if (rows <= 0) {
            System.out.println("Rows must be greater than 0.");
            return;
        }

        for (int row = 1; row <= rows; row++) {
            for (int star = 1; star <= row; star++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void isPrime() {
        int number = readInt("Enter an integer greater than 1: ");

        if (number <= 1) {
            System.out.println("Number must be greater than 1.");
            return;
        }

        boolean prime = true;

        for (int i = 2; i <= number / i; i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }

        if (prime) {
            System.out.println(number + " is prime.");
        } else {
            System.out.println(number + " is not prime.");
        }
    }

    public static void reverseNumber() {
        int number = readInt("Enter a positive integer: ");

        if (number <= 0) {
            System.out.println("Number must be greater than 0.");
            return;
        }

        long reversed = 0;

        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number = number / 10;
        }

        System.out.println("Reversed number: " + reversed);
    }

    public static void numberPyramid() {
        int rows = readInt("Enter the number of rows: ");

        if (rows <= 0) {
            System.out.println("Rows must be greater than 0.");
            return;
        }

        for (int row = 1; row <= rows; row++) {
            for (int number = 1; number <= row; number++) {
                System.out.print(number + " ");
            }

            System.out.println();
        }
    }

    public static void starDiamond() {
        int rows = readInt("Enter rows for the top half, including the middle: ");

        if (rows <= 0) {
            System.out.println("Rows must be greater than 0.");
            return;
        }

        // Top half of diamond 
        for (int row = 1; row <= rows; row++) {
            for (int space = 1; space <= rows - row; space++) {
                System.out.print(" ");
            }

            for (int star = 1; star <= row; star++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // Bottom half of diamond.
        for (int row = rows - 1; row >= 1; row--) {
            for (int space = 1; space <= rows - row; space++) {
                System.out.print(" ");
            }

            for (int star = 1; star <= row; star++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}