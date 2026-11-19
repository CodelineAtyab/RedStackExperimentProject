import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.HashMap;
import java.util.ArrayList;

import java.util.Scanner;

public class CustomerFeedbackPortal {

    static Scanner scanner = new Scanner(System.in);

    static String[] customerName = new String[100];
    static String[] productName = new String[100];
    static int[] customerRating = new int[100];
    static String[] customerComment = new String[100];

    static int feedbackCount = 0;

    public static void main(String[] args) {

        logoBanner();
        loadFeedback();

        int choiceNum = 0;

        while (choiceNum != 6) {
            showMenu();

            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                scanner.next();
                continue; // back to the menu
            }

            choiceNum = scanner.nextInt();
            scanner.nextLine();

            switch (choiceNum) {
                case 1:
                    submitFeedback();
                    break;
                case 2:
                    viewAllFeedback();
                    break;
                case 3:
                    ratingReport();
                    break;
                case 4:
                    searchByProduct();
                    break;
                case 5:
                    saveFeedback();
                    break;
                case 6:
                    System.out.println("Thank you for using the Customer Feedback Portal. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                    break;
            }
        }
        scanner.close();

    }

    public static void logoBanner() {
        String nameCompany = "ACME SOLUTIONS ";
        for (int rows = 0; rows < 6; rows++) {

            for (int left = 0; left < rows + 1; left++) {

                System.out.print("* ");

                if (left == rows) {
                    if (rows == 3) {
                        System.out.print("       ");
                        System.out.print(nameCompany);
                        System.out.print("      ");
                    } else
                        for (int space = 10; space > rows; space--) {
                            System.out.print("    ");
                        }

                    for (int right = 0; right < left + 1; right++) {

                        System.out.print(" *");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void loadFeedback() {
        try (BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {

                if (feedbackCount >= 100) {
                    break;
                }

                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    customerName[feedbackCount] = parts[0];
                    productName[feedbackCount] = parts[1];
                    customerRating[feedbackCount] = Integer.parseInt(parts[2]);
                    customerComment[feedbackCount] = parts[3];
                    feedbackCount++;
                }
            }
            System.out.println("Loaded " + feedbackCount + " feedback entries from feedback.txt ");

        } catch (IOException e) {
            System.out.println("No saved feedback found. Starting fresh.");
        }
    }

    public static void showMenu() {
        System.out.println("+==================================+");
        System.out.println("|     CUSTOMER FEEDBACK PORTAL     |");
        System.out.println("+==================================+");
        System.out.println("|1. Submit Feedback                |");
        System.out.println("|2. View All Feedback              |");
        System.out.println("|3. Rating Report                  |");
        System.out.println("|4. Search by Product              |");
        System.out.println("|5. Save to File                   |");
        System.out.println("|6. Exit                           |");
        System.out.println("+==================================+");
    }

    public static void submitFeedback() {

        System.out.println("--- Submit Feedback ---");

        if (feedbackCount >= 100) {
            System.out.println("Feedback storage is full!");
            return;
        }

        try {
            // customer name validation
            String name;
            while (true) {
                System.out.print("Customer name: ");
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty.");
                    continue;
                }
                break;

            }

            // product name validation
            String product;
            while (true) {
                System.out.print("Product: ");
                product = scanner.nextLine().trim();
                if (product.isEmpty()) {
                    System.out.println("Product name cannot be empty.");
                    continue;
                }
                break;
            }

            // Rating validation (1-5)
            int rating = 0;
            while (true) {
                System.out.print("Rating (1-5): ");
                if (scanner.hasNextInt()) {
                    rating = scanner.nextInt();
                    scanner.nextLine();

                    if (rating >= 1 && rating <= 5) {
                        break;

                    } else {
                        System.out.println("Rating must be a number from 1 to 5.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter an integer between 1 and 5.");
                    scanner.next();
                }
            }

            // comment validation
            String comment;
            while (true) {
                System.out.print("Comment: ");
                comment = scanner.nextLine().trim();
                if (comment.isEmpty()) {
                    System.out.println("Comment cannot be empty.");
                    continue;
                }
                break;
            }

            customerName[feedbackCount] = name;
            productName[feedbackCount] = product;
            customerRating[feedbackCount] = rating;
            customerComment[feedbackCount] = comment;

            feedbackCount++;

            System.out.println("Thank you, " + name + "! Your feedback has been recorded.");

        } catch (Exception e) {
            System.out.println("Error: Invalid input format.");
        }
    }

    public static void viewAllFeedback() {

        if (feedbackCount == 0) {
            System.out.println("No feedback has been submitted yet.");
            return; // exit no run for remaining code
        }

        System.out.println("No.  Customer      Product       Rating  Comment");
        System.out.println("---  ------------  ------------  ------  -----------------");

        for (int i = 0; i < feedbackCount; i++) {
            if (customerName[i] != null) {

                System.out.printf("%-3d  %-12s  %-12s  %-6d  %-14s %n",
                        (i + 1), customerName[i], productName[i], customerRating[i], customerComment[i]);
            }
        }
    }

    public static void ratingReport() {
        if (feedbackCount == 0) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        // Get unique product names

        ArrayList<String> product = new ArrayList<>(); // store product names

        for (int i = 0; i < feedbackCount; i++) {
            if (!product.contains(productName[i])) { // checks product name if exists or no in ArrayList
                product.add(productName[i]);
            }
        }

        // Create 2D array for product ratings
        int[][] reportProduct = new int[product.size()][5]; // row ->number unique products - col -> (1-5)ratings

        for (int i = 0; i < feedbackCount; i++) {
            int productIndex = product.indexOf(productName[i]); // searches for the product name
            int ratingIndex = customerRating[i] - 1; // ex user enter 5(1-5) rating this will be (5-1) = 4 index
                                                     // array(0-4)

            reportProduct[productIndex][ratingIndex]++; // changes the value product star column from 0 to 1 and from 1
                                                        // to 2 ..
        }

        // Print rating report

        System.out.printf("%-15s %3s %3s %3s %3s %3s %7s %8s%n",
                "Product", "1*", "2*", "3*", "4*", "5*", "Total", "Average");

        System.out.println("--------------  --- --- --- ---  ---  ------ ---------");

        for (int row = 0; row < product.size(); row++) {

            int totalRating = 0;
            int sum = 0;
            double average = 0.0;

            System.out.printf("%-15s", product.get(row)); // product name at index

            for (int col = 0; col < 5; col++) {
                System.out.printf("%4d", reportProduct[row][col]); // how many customers gave rating to product

                totalRating += reportProduct[row][col];
                sum += reportProduct[row][col] * (col + 1);
            }

            if (totalRating > 0) {
                average = (double) sum / totalRating;
            }

            System.out.printf("%7d %8.2f%n", totalRating, average);
        }

        // Ratings overview
        System.out.println("\nRatings overview");

        for (int star = 5; star >= 1; star--) {

            int count = 0; // count how many customers gave the current star rating across all products

            for (int row = 0; row < product.size(); row++) {
                count += reportProduct[row][star - 1];
            }

            System.out.print(star + " stars | ");

            for (int b = 0; b < count; b++) {
                System.out.print("*");
            }

            System.out.println(" (" + count + ")");
        }
    }

    public static void searchByProduct() {

        if (feedbackCount == 0) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        HashMap<String, Integer> feedbackByProduct = new HashMap<>(); // name product -> key-count of product ->value

        for (int i = 0; i < feedbackCount; i++) {
            if (productName[i] != null) {
                String prod = productName[i].trim().toLowerCase();

                if (feedbackByProduct.get(prod) == null) {
                    feedbackByProduct.put(prod, 1); // new product adds the product with count 1
                } else {
                    feedbackByProduct.put(prod, feedbackByProduct.get(prod) + 1);// already exists increase count by 1
                }
            }
        }

        System.out.println("--- Search by Product ---");

        System.out.print("Product to search: ");
        String searchProduct = scanner.nextLine().trim().toLowerCase();

        if (feedbackByProduct.get(searchProduct) == null) { // check product if enter or no in the HashMap
            System.out.println("No feedback found for \"" + searchProduct + "\".");
            return;
        } else {
            System.out.println("Found " + feedbackByProduct.get(searchProduct)
                    + " entries for \"" + searchProduct + "\":");
        }

        double sum = 0; // total ratings of founded same product
        int count = 0; // numbrt of entries found

        for (int i = 0; i < feedbackCount; i++) {
            if (productName[i] != null && productName[i].trim().equalsIgnoreCase(searchProduct)) { // ignoring uppercase
                                                                                                   // and lowercase

                System.out.println(customerName[i] + "  "
                        + customerRating[i] + "  "
                        + customerComment[i]);

                sum = sum + customerRating[i];
                count++;
            }
        }

        double average = sum / count;
        System.out.println("Average rating: " + average);

    }

    public static void saveFeedback() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt"))) {
            for (int i = 0; i < feedbackCount; i++) {
                writer.write(
                        customerName[i] + "|" + productName[i] + "|" + customerRating[i] + "|" + customerComment[i]);
                writer.newLine();
            }
            System.out.println("Saved " + feedbackCount + " feedback entries to feedback.txt");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
