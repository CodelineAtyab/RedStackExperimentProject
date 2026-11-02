import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class feedbackPortalEval {
    private static final String COMPANY_NAME = "ACME SOLUTIONS";
    private static final String MENU_BORDER = "+====================================+";
    private static final Path FEEDBACK_FILE = Paths.get("feedback.txt");
    private static final ArrayList<String> feedbackEntries = new ArrayList<>();
    private static final Map<String, ArrayList<String>> feedbackByProduct = new HashMap<>();

    // Prints company name centered in middle row.
    private static void printBanner(int size) {
        int middleRow = size / 2;

        for (int row = 0; row < size; row++) {
            for (int column = 0; column <= row; column++) {
                System.out.print("* ");
            }
            for (int column = row + 1; column < size; column++) {
                System.out.print("  ");
            }

            if (row == middleRow) {
                System.out.print(COMPANY_NAME );
            } else {
                for (int column = 0; column < COMPANY_NAME.length(); column++) {
                    System.out.print(" ");
                }
            }

            for (int column = 0; column < size - row - 1; column++) {
                System.out.print("  ");
            }
            for (int column = 0; column <= row; column++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    // Displays the available portal actions.
    private static void printMenu() {
        System.out.println(MENU_BORDER);
        System.out.printf("|%s|%n", "      CUSTOMER FEEDBACK PORTAL      ");
        System.out.println(MENU_BORDER);
        printMenuOption("1. Submit Feedback");
        printMenuOption("2. View All Feedback");
        printMenuOption("3. Rating Report");
        printMenuOption("4. Search by Product");
        printMenuOption("5. Save to File");
        printMenuOption("6. Exit");
        System.out.println(MENU_BORDER);
    }

    // Print one menu option using a consistent width.
    private static void printMenuOption(String option) {
        System.out.printf("|   %-33s|%n", option);
    }


    // Validates and stores feedback in the full list and the product lookup map.
    public static void addFeedback(String name, String product, int rating, String comment) {
        if (name == null || name.trim().isEmpty() || product == null || product.trim().isEmpty()
                || comment == null || comment.trim().isEmpty()) {
            System.out.println("Name, product, and comment cannot be empty.");
            return;
        }
        if (rating < 1 || rating > 5) {
            System.out.println("Rating must be between 1 and 5.");
            return;
        }

        String feedbackEntry = name.trim() + ", " + product.trim() + ", " + rating + ", " + comment.trim();
        feedbackEntries.add(feedbackEntry);
        indexFeedbackByProduct(feedbackEntry, product.trim());
    }

    // Adds an entry to the lookup list for its product.
    private static void indexFeedbackByProduct(String feedbackEntry, String product) {
        String productKey = product.toLowerCase();
        if (!feedbackByProduct.containsKey(productKey)) {
            feedbackByProduct.put(productKey, new ArrayList<>());
        }
        feedbackByProduct.get(productKey).add(feedbackEntry);
    }

    // Loads saved entries, validates the entire file, then adds them to memory.
    private static void loadFeedback() {
        try {
            if (!Files.exists(FEEDBACK_FILE)) {
                System.out.println("No saved feedback found. Starting fresh.");
                return;
            }

            ArrayList<String> savedEntries = new ArrayList<>(Files.readAllLines(FEEDBACK_FILE));
            // Stage validated fields so a damaged file cannot partially update the feedback data.
            ArrayList<String[]> parsedEntries = new ArrayList<>();
            for (int lineNumber = 0; lineNumber < savedEntries.size(); lineNumber++) {
                
                String[] fields = savedEntries.get(lineNumber).split(",", 4);
                if (fields.length != 4 || fields[0].trim().isEmpty() || fields[1].trim().isEmpty() || fields[3].trim().isEmpty()) {
                    throw new IOException("Invalid feedback entry on line " + (lineNumber + 1));
                }

                try {
                    int rating = Integer.parseInt(fields[2].trim());
                    if (rating < 1 || rating > 5) {
                        throw new IOException("Rating out of range on line " + (lineNumber + 1));
                    }
                } catch (NumberFormatException exception) {
                    throw new IOException("Invalid rating on line " + (lineNumber + 1), exception);
                }
                parsedEntries.add(fields);
            }

            // Commit entries only after every line has passed validation.
            for (String[] fields : parsedEntries) {
                String entry = String.join(", ", fields);
                feedbackEntries.add(entry);
                indexFeedbackByProduct(entry, fields[1].trim());
            }
            System.out.println("Loaded " + feedbackEntries.size() + " feedback entries from " + FEEDBACK_FILE);
        } catch (IOException | SecurityException exception) {
            System.err.println("Could not load feedback from " + FEEDBACK_FILE + ": " + exception.getMessage());
            System.out.println("No saved feedback found. Starting fresh.");
        }
    }

    // Replaces the saved file with all feedback currently held in memory.
    private static boolean saveFeedback() {
        try {
            Files.write(FEEDBACK_FILE, feedbackEntries);
            return true;
        } catch (IOException exception) {
            System.err.println("Could not save feedback to " + FEEDBACK_FILE + ": " + exception.getMessage());
            return false;
        }
    }


    // Reads a non-empty line, returning null if input ends.
    private static String readRequiredText(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextLine()) {
                return null;
            }

            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field cannot be empty. Please try again.");
        }
    }

    
    // Reads and validates a whole-number rating from 1 through 5.
    private static Integer readRating(Scanner scanner) {
        while (true) {
            System.out.print("Rating (1 to 5): ");
            if (!scanner.hasNextLine()) {
                return null;
            }

            String input = scanner.nextLine().trim();
            try {
                int rating = Integer.parseInt(input);
                if (rating >= 1 && rating <= 5) {
                    return rating;
                }
            } catch (NumberFormatException exception) {
            }
            System.out.println("Invalid rating. Please enter a whole number from 1 to 5.");
        }
    }

    // Prompts for all fields and submits one feedback entry.
    private static boolean submitFeedback(Scanner scanner) {
        String name = readRequiredText(scanner, "Customer name: ");
        if (name == null) {
            return false;
        }

        String product = readRequiredText(scanner, "Product: ");
        if (product == null) {
            return false;
        }

        Integer rating = readRating(scanner);
        if (rating == null) {
            return false;
        }

        String comment = readRequiredText(scanner, "Comment: ");
        if (comment == null) {
            return false;
        }

        addFeedback(name, product, rating, comment);
        System.out.println("Feedback submitted.");
        return true;
    }

    // Displays all feedback entries in a numbered fixed-width table.
    private static void printAllFeedback() {
        if (feedbackEntries.isEmpty()) {
            System.out.println("No feedback entries available.");
            return;
        }

        String[] headers = {"#", "Name", "Product", "Rating", "Comment"};
        int[] widths = {3, 20, 20, 6, 40};

        printFeedbackTableSeparator(widths);
        printFeedbackTableRow(headers, widths);
        printFeedbackTableSeparator(widths);
        for (int row = 0; row < feedbackEntries.size(); row++) {
            String[] fields = feedbackEntries.get(row).split(",", 4);
            String[] values = {
                    Integer.toString(row + 1),
                    fields[0].trim(),
                    fields[1].trim(),
                    fields[2].trim(),
                    fields[3].trim()
            };
            printFeedbackTableRow(values, widths);
        }
        printFeedbackTableSeparator(widths);
    }

    // Finds product feedback and reports its average.
    private static boolean searchByProduct(Scanner scanner) {
        System.out.println("--- Search by Product ---");
        String productQuery = readRequiredText(scanner, "Product to search: ");
        if (productQuery == null) {
            return false;
        }

        ArrayList<String> matchingEntries = feedbackByProduct.get(productQuery.toLowerCase());
        if (matchingEntries == null) {
            System.out.printf("No feedback found for \"%s\".%n", productQuery);
            return true;
        }

        String displayProduct = matchingEntries.get(0).split(",", 4)[1].trim();
        System.out.printf("Found %d entries for \"%s\":%n", matchingEntries.size(), displayProduct);

        int totalRating = 0;
        for (String entry : matchingEntries) {
            String[] fields = entry.split(",", 4);
            int rating = Integer.parseInt(fields[2].trim());
            totalRating += rating;
            System.out.printf("   %-20s %d   %s%n", fields[0].trim(), rating, fields[3].trim());
        }

        System.out.printf("Average rating: %.2f%n", (double) totalRating / matchingEntries.size());
        return true;
    }

    // Prints one row of left-aligned values using the supplied column widths.
    private static void printFeedbackTableRow(String[] values, int[] widths) {
        for (int column = 0; column < values.length; column++) {
            System.out.printf("| %-" + widths[column] + "s ", values[column]);
        }
        System.out.println("|");
    }

    // Prints a horizontal separator matching the supplied table column widths.
    private static void printFeedbackTableSeparator(int[] widths) {
        for (int width : widths) {
            System.out.print("+-");
            for (int character = 0; character < width; character++) {
                System.out.print("-");
            }
            System.out.print("-");
        }
        System.out.println("+");
    }



    // Counts each star rating per product and displays totals and averages.
    private static void printRatingReportPerProduct() {
        if (feedbackEntries.isEmpty()) {
            System.out.println("No feedback entries available.");
            return;
        }

        ArrayList<String> products = new ArrayList<>();
        for (String entry : feedbackEntries) {
            String[] fields = entry.split(",", 4);
            String product = fields[1].trim();
            if (!products.contains(product)) {
                products.add(product);
            }
        }

        int[][] ratingCounts = new int[products.size()][5];
        for (String entry : feedbackEntries) {
            String[] fields = entry.split(",", 4);
            int productRow = products.indexOf(fields[1].trim());
            int ratingColumn = Integer.parseInt(fields[2].trim()) - 1;
            ratingCounts[productRow][ratingColumn]++;
        }

        String[] headers = {"Product", "1 star", "2 stars", "3 stars", "4 stars", "5 stars", "Total", "Average"
        };
        int[] widths = {20, 8, 8, 8, 8, 8, 8, 8};

        printFeedbackTableSeparator(widths);
        printFeedbackTableRow(headers, widths);
        printFeedbackTableSeparator(widths);
        for (int row = 0; row < products.size(); row++) {
            int totalCount = 0;
            int totalScore = 0;
            String[] values = new String[headers.length];
            values[0] = products.get(row);
            for (int rating = 0; rating < 5; rating++) {
                int count = ratingCounts[row][rating];
                values[rating + 1] = Integer.toString(count);
                totalCount += count;
                totalScore += count * (rating + 1);
            }
            values[6] = Integer.toString(totalCount);
            values[7] = String.format("%.2f", (double) totalScore / totalCount);
            printFeedbackTableRow(values, widths);
        }
        printFeedbackTableSeparator(widths);
    }


    // Loads saved data, then repeatedly handles validated menu selections.
    public static void main(String[] args) {
        int bannerSize = 7;
        printBanner(bannerSize);
        loadFeedback();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                printMenu();

                // Keep prompting until the user enters a menu option from 1 through 6.
                int choice;
                while (true) {
                    System.out.print("Enter your choice: ");
                    if (!scanner.hasNextLine()) {
                        return;
                    }

                    String input = scanner.nextLine().trim();
                    try {
                        choice = Integer.parseInt(input);
                    } catch (NumberFormatException exception) {
                        choice = -1;
                    }

                    if (choice >= 1 && choice <= 6) {
                        break;
                    }
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                }

                switch (choice) {
                    case 1:
                        if (!submitFeedback(scanner)) {
                            running = false;
                        }
                        break;
                    case 2:
                        printAllFeedback();
                        break;
                    case 3:
                        printRatingReportPerProduct();
                        break;
                    case 4:
                        if (!searchByProduct(scanner)) {
                            running = false;
                        }
                        break;
                    case 5:
                        if (saveFeedback()) {
                            System.out.println("Saved " + feedbackEntries.size()
                                    + " feedback entries to " + FEEDBACK_FILE);
                        }
                        break;
                    case 6:
                        running = false;
                        System.out.print("Saving feedback... ");
                        if (saveFeedback()) {
                            System.out.println("done.");
                        } else {
                            System.out.println("failed.");
                        }
                        System.out.println(
                                "Thank you for using the Customer Feedback Portal. Goodbye!");
                        break;
                    default:
                        throw new IllegalStateException("Validated menu choice was out of range.");
                }
            }
        }
    }
}
