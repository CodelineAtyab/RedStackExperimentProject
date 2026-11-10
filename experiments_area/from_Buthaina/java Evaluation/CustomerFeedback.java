import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CustomerFeedback {

    static int count = 0;
    static String[] names = new String[100];
    static int[] rating = new int[100];
    static String[] comments = new String[100];
    static String[] products = new String[100];
    static Scanner userInput = new Scanner(System.in);

    // Main method
    public static void main(String[] args) {
        showBanner();
        loadFeedback();
        showAll();

        while (true) {
            showMenu();
            System.out.print("Enter your choice: ");
            String input = userInput.nextLine();

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                continue;
            }

            switch (choice) {
                case 1:
                    addFeedback();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    showAverage();
                    break;
                case 4:
                    searchByProduct();
                    break;
                case 5:
                    saveFeedback();
                    break;
                case 6:
                    exitFeedback();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        }
    }

    // Method to show banner
   static void showBanner() {

    int rows = 6;
    String companyName = "ACME SOLUTIONS";

    for (int i = 1; i <= rows; i++) {

        // Left triangle
        for (int j = 1; j <= i; j++) {
            System.out.print("*");
        }

        // Spaces in the middle
        if (i == 4) {
            System.out.print("  " + companyName + "   ");
        } else {
            for (int j = 1; j <= 18; j++) {
                System.out.print(" ");
            }
        }

        // Right triangle
        for (int j = 1; j <= i; j++) {
            System.out.print("*");
        }

        System.out.println();
    }
}

    // Load feedback method
    static void loadFeedback() {
        int loadedCount = 0;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("feedback.txt"))) {
            String line;

            while ((line = reader.readLine()) != null && count < 100) {
                String[] parts = line.split("\\|", 4);

                if (parts.length == 4) {
                    try {
                        int ratingValue = Integer.parseInt(parts[2]);

                        if (ratingValue >= 1 && ratingValue <= 5
                                && !parts[0].isEmpty()
                                && !parts[1].isEmpty()
                                && !parts[3].isEmpty()) {
                            names[count] = parts[0];
                            products[count] = parts[1];
                            rating[count] = ratingValue;
                            comments[count] = parts[3];
                            count++;
                            loadedCount++;
                        } else {
                            System.out.println("Invalid feedback skipped.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Damaged feedback skipped.");
                    }
                } else {
                    System.out.println("Invalid feedback entry skipped.");
                }
            }

            System.out.println("Loaded " + loadedCount
                    + " feedback entries from feedback.txt");
        } catch (IOException e) {
            System.out.println("No saved feedback found. Starting fresh.");
        }
    }

    // Menu method
    static void showMenu() {
        System.out.println("\n+----------------------------------+");
        System.out.printf("| %-32s |%n", "Customer Feedback Portal");
        System.out.println("+----------------------------------+");
        System.out.printf("| %-32s |%n", "1. Add Feedback");
        System.out.printf("| %-32s |%n", "2. Show All Feedback");
        System.out.printf("| %-32s |%n", "3. Show Average Rating");
        System.out.printf("| %-32s |%n", "4. Search Feedback by Product");
        System.out.printf("| %-32s |%n", "5. Save Feedback to File");
        System.out.printf("| %-32s |%n", "6. Exit");
        System.out.println("+----------------------------------+");
    }

    // Add feedback method
    static void addFeedback() {
        if (count >= 100) {
            System.out.println("Feedback list is full.");
            return;
        }

        System.out.println("---- Submit Feedback ----");

        String name;
        while (true) {
            System.out.print("Customer name: ");
            name = userInput.nextLine();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
            } else {
                break;
            }
        }

        System.out.print("Product name: ");
        String product = userInput.nextLine();

        int ratingValue = 0;
        while (ratingValue < 1 || ratingValue > 5) {
            System.out.print("Rating (1-5): ");
            String input = userInput.nextLine();

            try {
                ratingValue = Integer.parseInt(input);
                if (ratingValue < 1 || ratingValue > 5) {
                    System.out.println("Rating must be a number between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid rating. Please enter a number between 1 and 5.");
            }
        }

        System.out.print("Comment: ");
        String comment = userInput.nextLine();

        names[count] = name;
        products[count] = product;
        rating[count] = ratingValue;
        comments[count] = comment;
        count++;

        System.out.println("Thank you, " + name + "! Feedback has been recorded!");
    }

    // Show all feedback method
    static void showAll() {
        System.out.println("\n---- All Feedback ----");

        if (count == 0) {
            System.out.println("No feedback available.");
            return;
        }

        System.out.printf("%-5s %-12s %-13s %-8s %-30s%n",
                "No.", "Customer", "Product", "Rating", "Comments");

        System.out.println("--------------------------------------");

        for (int i = 0; i < count; i++) {
            System.out.printf("%-5d %-12s %-13s %-8d %-30s%n",
                    i + 1,
                    names[i],
                    products[i],
                    rating[i],
                    comments[i]);
        }
    }

    // Rating report method
    static void showAverage() {
        ArrayList<String> productNames = new ArrayList<>();

        // Build the product list from saved feedback
        for (int i = 0; i < count; i++) {
            boolean productFound = false;

            for (String productName : productNames) {
                if (productName.equalsIgnoreCase(products[i])) {
                    productFound = true;
                    break;
                }
            }

            if (!productFound) {
                productNames.add(products[i]);
            }
        }

        int[][] ratingCounts = new int[productNames.size()][5];

        // Count ratings for each product
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < productNames.size(); j++) {
                if (products[i].equalsIgnoreCase(productNames.get(j))) {
                    ratingCounts[j][rating[i] - 1]++;
                    break;
                }
            }
        }

        System.out.println("\n---- Rating Report ----");

        System.out.printf("%-20s %-5s %-5s %-5s %-5s %-5s %-7s %-8s%n",
                "Product", "1*", "2*", "3*", "4*", "5*",
                "Total", "Average");

        System.out.println("----------------------------------------------------------------");

        for (int i = 0; i < productNames.size(); i++) {
            int totalRatings = 0;
            int sum = 0;

            for (int j = 0; j < 5; j++) {
                totalRatings += ratingCounts[i][j];
                sum += ratingCounts[i][j] * (j + 1);
            }

            double average = 0;
            if (totalRatings > 0) {
                average = (double) sum / totalRatings;
            }

            System.out.printf("%-20s ", productNames.get(i));

            for (int j = 0; j < 5; j++) {
                System.out.printf("%-5d ", ratingCounts[i][j]);
            }

            System.out.printf("%-7d %-8.2f%n", totalRatings, average);
        }
    }

    // Search by product method
    static void searchByProduct() {
        HashMap<String, ArrayList<Integer>> productFeedback =
                new HashMap<>();

        // Group feedback by product
        for (int i = 0; i < count; i++) {
            String product = products[i].toLowerCase();

            productFeedback.putIfAbsent(product, new ArrayList<>());
            productFeedback.get(product).add(i);
        }

        System.out.println("\n--- Search by Product ---");
        System.out.print("Product to search: ");

        String search = userInput.nextLine().toLowerCase();

        if (productFeedback.containsKey(search)) {
            ArrayList<Integer> results = productFeedback.get(search);
            int total = 0;

            System.out.println("Found " + results.size()
                    + " entries for \"" + products[results.get(0)] + "\":");

            for (int index : results) {
                System.out.println(names[index] + " "
                        + rating[index] + " " + comments[index]);

                total += rating[index];
            }

            double average = (double) total / results.size();
            System.out.printf("Average rating: %.2f%n", average);
        } else {
            System.out.println("No feedback found for \"" + search + "\".");
        }
    }

    // Save feedback method
    static void saveFeedback() {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("feedback.txt"))) {
            for (int i = 0; i < count; i++) {
                writer.write(names[i] + "|"
                        + products[i] + "|"
                        + rating[i] + "|" + comments[i]);
                writer.newLine();
            }

            System.out.println("Feedback saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving feedback to file: " + e.getMessage());
        }
    }

    // Exit method
    public static void exitFeedback() {
        System.out.println("Saving feedback...");
        saveFeedback();
        System.out.println("Thank you. Goodbye!");
    }
}
