import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FeedbackPortal {

    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> products = new ArrayList<>();
    static ArrayList<Integer> ratings = new ArrayList<>();
    static ArrayList<String> comments = new ArrayList<>();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String fileName = "feedback.txt";

        printBanner("ACME SOLUTIONS");
        loadFromFile(fileName);

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readChoice();

            switch (choice) {
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
                    if (saveToFile(fileName)) {
                        System.out.println("Saved " + names.size() + " feedback entries to " + fileName);
                    }
                    break;
                case 6:
                    System.out.print("Saving feedback... ");
                    saveToFile(fileName);
                    System.out.println("done.");
                    System.out.println("Thank you for using the Customer Feedback Portal. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        }
    }

    // 1. LOGO BANNER
    // Each row = left triangle + middle part + right triangle
    static void printBanner(String company) {
        int rows = 7;
        int middleRow = 4;

        for (int row = 1; row <= rows; row++) {

            // left triangle -> Row 1 prints * and then 6 spaces
            for (int i = 1; i <= rows; i++) {
                if (i <= row) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            // middle -> one space on each side
            if (row == middleRow) {
                System.out.print(" " + company + " ");
            } else {
                for (int i = 0; i < company.length() + 2; i++) {
                    System.out.print(" ");
                }
            }

            // right triangle -> 6 spaces 1 star
            for (int i = 1; i <= rows; i++) {
                if (i <= rows - row) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }

            System.out.println();
        }
        System.out.println();
    }

    // 2. LOAD FROM FILE
    // name|product|rating|comment
    static void loadFromFile(String fileName) {
        int count = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();

            while (line != null) {
                String[] parts = line.split("\\|", 4);

                if (parts.length == 4) {
                    try {
                        int rating = Integer.parseInt(parts[2]);
                        if (rating >= 1 && rating <= 5) {
                            names.add(parts[0]);
                            products.add(parts[1]);
                            ratings.add(rating);
                            comments.add(parts[3]);
                            count++;
                        }
                    } catch (NumberFormatException e) {
                    }
                }

                line = reader.readLine();
            }
            reader.close();
            System.out.println("Loaded " + count + " feedback entries from " + fileName);

        } catch (IOException e) {
            System.out.println("No saved feedback found. Starting fresh.");
        }
        System.out.println();
    }

    // 3. MENU
    static void printMenu() {
        System.out.println();
        System.out.println("+====================================+");
        System.out.println("|       CUSTOMER FEEDBACK PORTAL     |");
        System.out.println("+====================================+");
        System.out.println("| 1. Submit Feedback                 |");
        System.out.println("| 2. View All Feedback               |");
        System.out.println("| 3. Rating Report                   |");
        System.out.println("| 4. Search by Product               |");
        System.out.println("| 5. Save to File                    |");
        System.out.println("| 6. Exit                            |");
        System.out.println("+====================================+");
    }

    static int readChoice() {
        System.out.print("Enter your choice: ");
        try {
            return Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // 4. SUBMIT FEEDBACK
    static void submitFeedback() {
        System.out.println();
        System.out.println("--- Submit Feedback ---");

        String name = readText("Customer name: ", "Name cannot be empty.");
        String product = readText("Product: ", "Product cannot be empty.");
        int rating = readRating();

        System.out.print("Comment: ");
        String comment = input.nextLine().trim().replace("|", "/");

        names.add(name);
        products.add(product);
        ratings.add(rating);
        comments.add(comment);

        System.out.println("Thank you, " + name + "! Your feedback has been recorded.");
    }

    static String readText(String question, String errorMessage) {
        while (true) {
            System.out.print(question);
            String text = input.nextLine().trim().replace("|", "/");

            if (!text.isEmpty()) {
                return text;
            }
            System.out.println(errorMessage);
        }
    }

    static int readRating() {
        while (true) {
            System.out.print("Rating (1-5): ");
            try {
                int rating = Integer.parseInt(input.nextLine().trim());
                if (rating >= 1 && rating <= 5) {
                    return rating;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Rating must be a number from 1 to 5.");
        }
    }

    // 5. VIEW ALL FEEDBACK
    static void viewAllFeedback() {
        System.out.println();

        if (names.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        System.out.println(padRight("No.", 4) + padRight("Customer", 12) + padRight("Product", 14)
                + padRight("Rating", 8) + "Comment");
        System.out.println(padRight("---", 4) + padRight("--------", 12) + padRight("-------", 14)
                + padRight("------", 8) + "-----------------");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(padRight(String.valueOf(i + 1), 4) + padRight(names.get(i), 12)
                    + padRight(products.get(i), 14) + padRight(String.valueOf(ratings.get(i)), 8)
                    + comments.get(i));
        }
    }

    // 6. RATING REPORT
    static void ratingReport() {
        System.out.println();

        if (names.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        // Step 1: make a list of the different products (each product once)
        ArrayList<String> uniqueProducts = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            boolean alreadyThere = false;
            for (int j = 0; j < uniqueProducts.size(); j++) {
                if (uniqueProducts.get(j).equalsIgnoreCase(products.get(i))) {
                    alreadyThere = true;
                }
            }
            if (!alreadyThere) {
                uniqueProducts.add(products.get(i));
            }
        }

        // Step 2: count the ratings.
        // counts[row][column]: row = product, column = stars (column 0 means 1 star)
        int[][] counts = new int[uniqueProducts.size()][5];
        for (int i = 0; i < products.size(); i++) {
            int column = ratings.get(i) - 1;
            for (int row = 0; row < uniqueProducts.size(); row++) {
                if (uniqueProducts.get(row).equalsIgnoreCase(products.get(i))) {
                    counts[row][column]++;
                }
            }
        }

        // Step 3: print the grid
        System.out.println(padRight("Product", 14) + "1*  2*  3*  4*  5*  " + padRight("Total", 7) + "Average");
        System.out.println("--------------------------------------------------");

        int[] starTotals = new int[5]; // how many ratings each star value got in total

        for (int row = 0; row < uniqueProducts.size(); row++) {
            int total = 0;
            int sum = 0;

            System.out.print(padRight(uniqueProducts.get(row), 14));
            for (int column = 0; column < 5; column++) {
                int howMany = counts[row][column];
                System.out.print(padRight(String.valueOf(howMany), 4));

                total = total + howMany;
                sum = sum + howMany * (column + 1);
                starTotals[column] = starTotals[column] + howMany;
            }

            double average = (double) sum / total;
            System.out.println(padRight(String.valueOf(total), 7) + Math.round(average * 100) / 100.0);
        }

        // Step 4: draw the bars, from 5 stars down to 1 star
        System.out.println();
        System.out.println("Ratings overview");
        for (int star = 5; star >= 1; star--) {
            String label = star + " stars";
            if (star == 1) {
                label = "1 star ";
            }

            System.out.print(label + " | ");
            for (int i = 0; i < starTotals[star - 1]; i++) {
                System.out.print("*");
            }
            System.out.println(" (" + starTotals[star - 1] + ")");
        }
    }

    // 7. SEARCH BY PRODUCT
    static void searchByProduct() {
        System.out.println();
        System.out.println("--- Search by Product ---");

        HashMap<String, ArrayList<Integer>> groups = new HashMap<>();
        for (int i = 0; i < products.size(); i++) {
            String key = products.get(i).toLowerCase();

            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<Integer>());
            }
            groups.get(key).add(i);
        }

        String search = readText("Product to search: ", "Product name cannot be empty.");
        ArrayList<Integer> found = groups.get(search.toLowerCase());

        if (found == null) {
            System.out.println("No feedback found for \"" + search + "\".");
            return;
        }

        int firstPosition = found.get(0);
        System.out.println("Found " + found.size() + " entries for \""
                + products.get(firstPosition) + "\":");
        System.out.println();
        int sum = 0;
        for (int k = 0; k < found.size(); k++) {
            int i = found.get(k);
            System.out.println("  " + padRight(names.get(i), 12) + padRight(String.valueOf(ratings.get(i)), 4)
                    + comments.get(i));
            sum = sum + ratings.get(i);
        }
        System.out.println();
        double average = (double) sum / found.size();
        System.out.println("Average rating: " + Math.round(average * 100) / 100.0);
    }

    // 8. SAVE TO FILE
    static boolean saveToFile(String fileName) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));

            for (int i = 0; i < names.size(); i++) {
                writer.println(names.get(i) + "|" + products.get(i) + "|"
                        + ratings.get(i) + "|" + comments.get(i));
            }

            writer.close();
            return true;

        } catch (IOException e) {
            System.out.println("Error: could not save to " + fileName);
            return false;
        }
    }

    // adds spaces after the text until it is "width" characters long
    static String padRight(String text, int width) {
        String result = text;
        while (result.length() < width) {
            result = result + " ";
        }
        return result;
    }
}