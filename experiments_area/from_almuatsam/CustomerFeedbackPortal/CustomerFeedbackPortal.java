import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Customer Feedback Portal: collects, reports on and stores customer feedback.
 */
public class CustomerFeedbackPortal {

    static final String COMPANY_NAME = "ACME SOLUTIONS";
    static final String FILE_NAME = "feedback.txt";
    static final String SEPARATOR = "|";
    static final int BANNER_ROWS = 6;
    static final int MIN_RATING = 1;
    static final int MAX_RATING = 5;

    static final Scanner scanner = new Scanner(System.in);
    static final ArrayList<Feedback> feedbackList = new ArrayList<>();

    /** One customer feedback entry. */
    static class Feedback {
        String customer;
        String product;
        int rating;
        String comment;

        Feedback(String customer, String product, int rating, String comment) {
            this.customer = customer;
            this.product = product;
            this.rating = rating;
            this.comment = comment;
        }
    }

    public static void main(String[] args) {
        printBanner();
        loadFeedback();

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readMenuChoice();
            switch (choice) {
                case 1:
                    submitFeedback();
                    break;
                case 2:
                    viewAllFeedback();
                    break;
                case 3:
                    showRatingReport();
                    break;
                case 4:
                    searchByProduct();
                    break;
                case 5:
                    saveFeedback(false);
                    break;
                case 6:
                    exitProgram();
                    running = false;
                    break;
                default:
                    break;
            }
        }
    }

    // ---------------------------------------------------------------- banner

    /** Prints a star triangle, the company name in the middle row, and its mirror image. */
    static void printBanner() {
        int width = BANNER_ROWS;
        int middleRow = BANNER_ROWS / 2;
        String name = " " + COMPANY_NAME + " ";

        for (int row = 1; row <= BANNER_ROWS; row++) {
            StringBuilder line = new StringBuilder();

            // left triangle, padded to a fixed width
            for (int col = 1; col <= width; col++) {
                line.append(col <= row ? '*' : ' ');
            }

            // middle: company name on one row, blanks on the others
            if (row == middleRow) {
                line.append(name);
            } else {
                for (int i = 0; i < name.length(); i++) {
                    line.append(' ');
                }
            }

            // right triangle (mirror image)
            for (int col = 1; col <= width; col++) {
                line.append(col > width - row ? '*' : ' ');
            }
            System.out.println(line);
        }
        System.out.println();
    }

    // ---------------------------------------------------------------- menu

    static void printMenu() {
        String border = "+====================================+";
        System.out.println();
        System.out.println(border);
        System.out.println("|      CUSTOMER FEEDBACK PORTAL      |");
        System.out.println(border);
        System.out.println(menuLine("1. Submit Feedback"));
        System.out.println(menuLine("2. View All Feedback"));
        System.out.println(menuLine("3. Rating Report"));
        System.out.println(menuLine("4. Search by Product"));
        System.out.println(menuLine("5. Save to File"));
        System.out.println(menuLine("6. Exit"));
        System.out.println(border);
    }

    /** Pads a menu option so the right border stays aligned. */
    static String menuLine(String text) {
        return String.format("|   %-33s|", text);
    }

    /** Keeps asking until the user enters a whole number from 1 to 6. */
    static int readMenuChoice() {
        while (true) {
            System.out.print("Enter your choice: ");
            String input = readLine();
            try {
                int choice = Integer.parseInt(input.trim());
                if (choice >= 1 && choice <= 6) {
                    return choice;
                }
            } catch (NumberFormatException e) {
                // falls through to the error message below
            }
            System.out.println("Invalid choice. Please enter a number from 1 to 6.");
        }
    }

    /** Reads a line; if input has ended (Ctrl+D / Ctrl+Z), saves and quits cleanly. */
    static String readLine() {
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println();
            exitProgram();
            System.exit(0);
            return "";
        }
    }

    // ---------------------------------------------------------------- loading

    static void loadFeedback() {
        int loaded = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Feedback entry = parseLine(line);
                if (entry != null) {
                    feedbackList.add(entry);
                    loaded++;
                }
            }
        } catch (IOException e) {
            // missing or unreadable file: start fresh
            loaded = 0;
        }

        if (loaded == 0) {
            System.out.println("No saved feedback found. Starting fresh.");
        } else {
            System.out.println("Loaded " + loaded + " feedback entries from " + FILE_NAME);
        }
    }

    /** Turns "customer|product|rating|comment" into a Feedback, or null if the line is damaged. */
    static Feedback parseLine(String line) {
        String[] parts = line.split("\\" + SEPARATOR, -1);
        if (parts.length != 4) {
            return null;
        }
        try {
            int rating = Integer.parseInt(parts[2].trim());
            if (rating < MIN_RATING || rating > MAX_RATING
                    || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                return null;
            }
            return new Feedback(parts[0].trim(), parts[1].trim(), rating, parts[3].trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // ---------------------------------------------------------------- submit

    static void submitFeedback() {
        System.out.println("--- Submit Feedback ---");
        String customer = readNonEmpty("Customer name: ", "Name cannot be empty.");
        String product = readNonEmpty("Product: ", "Product cannot be empty.");
        int rating = readRating();
        System.out.print("Comment: ");
        String comment = clean(readLine());

        feedbackList.add(new Feedback(customer, product, rating, comment));
        System.out.println("Thank you, " + customer + "! Your feedback has been recorded.");
    }

    static String readNonEmpty(String prompt, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String value = clean(readLine());
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println(errorMessage);
        }
    }

    static int readRating() {
        while (true) {
            System.out.print("Rating (" + MIN_RATING + "-" + MAX_RATING + "): ");
            try {
                int rating = Integer.parseInt(readLine().trim());
                if (rating >= MIN_RATING && rating <= MAX_RATING) {
                    return rating;
                }
            } catch (NumberFormatException e) {
                // falls through to the error message below
            }
            System.out.println("Rating must be a number from " + MIN_RATING + " to " + MAX_RATING + ".");
        }
    }

    /** Trims text and removes the file separator so saved lines stay parseable. */
    static String clean(String text) {
        return text.replace(SEPARATOR, " ").trim();
    }

    // ---------------------------------------------------------------- view

    static void viewAllFeedback() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }
        System.out.println();
        System.out.printf("%-4s %-12s %-14s %-7s %s%n", "No.", "Customer", "Product", "Rating", "Comment");
        System.out.printf("%-4s %-12s %-14s %-7s %s%n", "---", "--------", "-------", "------", "-------");
        for (int i = 0; i < feedbackList.size(); i++) {
            Feedback f = feedbackList.get(i);
            System.out.printf("%-4d %-12s %-14s %-7d %s%n",
                    i + 1, f.customer, f.product, f.rating, f.comment);
        }
    }

    // ---------------------------------------------------------------- report

    static void showRatingReport() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        // one row per distinct product (case-insensitive), in order of first appearance
        ArrayList<String> products = new ArrayList<>();
        for (Feedback f : feedbackList) {
            if (indexOfProduct(products, f.product) == -1) {
                products.add(f.product);
            }
        }

        // counts[product][star - 1]
        int[][] counts = new int[products.size()][MAX_RATING];
        for (Feedback f : feedbackList) {
            counts[indexOfProduct(products, f.product)][f.rating - 1]++;
        }

        System.out.println();
        System.out.printf("%-14s", "Product");
        for (int star = MIN_RATING; star <= MAX_RATING; star++) {
            System.out.printf("%-5s", star + "*");
        }
        System.out.printf("%-7s %s%n", "Total", "Average");
        System.out.printf("%-14s", "-------");
        for (int star = MIN_RATING; star <= MAX_RATING; star++) {
            System.out.printf("%-5s", "---");
        }
        System.out.printf("%-7s %s%n", "-----", "-------");

        int[] starTotals = new int[MAX_RATING];
        for (int p = 0; p < products.size(); p++) {
            int total = 0;
            int weighted = 0;
            System.out.printf("%-14s", products.get(p));
            for (int s = 0; s < MAX_RATING; s++) {
                System.out.printf("%-5d", counts[p][s]);
                total += counts[p][s];
                weighted += counts[p][s] * (s + 1);
                starTotals[s] += counts[p][s];
            }
            System.out.printf("%-7d %.2f%n", total, (double) weighted / total);
        }

        System.out.println();
        System.out.println("Ratings overview");
        for (int s = MAX_RATING - 1; s >= 0; s--) {
            StringBuilder bar = new StringBuilder();
            for (int i = 0; i < starTotals[s]; i++) {
                bar.append('*');
            }
            String label = (s + 1) + (s == 0 ? " star " : " stars");
            System.out.printf("%s | %-10s (%d)%n", label, bar, starTotals[s]);
        }
    }

    static int indexOfProduct(ArrayList<String> products, String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    // ---------------------------------------------------------------- search

    static void searchByProduct() {
        System.out.println("--- Search by Product ---");
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        // key = lower-case product name, value = all entries for that product
        HashMap<String, ArrayList<Feedback>> byProduct = new HashMap<>();
        for (Feedback f : feedbackList) {
            String key = f.product.toLowerCase();
            if (!byProduct.containsKey(key)) {
                byProduct.put(key, new ArrayList<Feedback>());
            }
            byProduct.get(key).add(f);
        }

        String query = readNonEmpty("Product to search: ", "Product name cannot be empty.");
        ArrayList<Feedback> matches = byProduct.get(query.toLowerCase());

        if (matches == null) {
            System.out.println("No feedback found for \"" + query + "\".");
            return;
        }

        int sum = 0;
        System.out.println("Found " + matches.size() + " entries for \"" + matches.get(0).product + "\":");
        for (Feedback f : matches) {
            System.out.printf("%-8s %-3d %s%n", f.customer, f.rating, f.comment);
            sum += f.rating;
        }
        System.out.printf("Average rating: %.2f%n", (double) sum / matches.size());
    }

    // ---------------------------------------------------------------- saving

    /** Writes all feedback to the file; returns true on success. */
    static boolean saveFeedback(boolean quiet) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Feedback f : feedbackList) {
                writer.println(f.customer + SEPARATOR + f.product + SEPARATOR
                        + f.rating + SEPARATOR + f.comment);
            }
            if (writer.checkError()) {
                throw new IOException("write failed");
            }
        } catch (IOException e) {
            System.out.println("Could not save feedback to " + FILE_NAME + ": " + e.getMessage());
            return false;
        }
        if (!quiet) {
            System.out.println("Saved " + feedbackList.size() + " feedback entries to " + FILE_NAME);
        }
        return true;
    }

    static void exitProgram() {
        System.out.print("Saving feedback... ");
        if (saveFeedback(true)) {
            System.out.println("done.");
        }
        System.out.println("Thank you for using the Customer Feedback Portal. Goodbye!");
    }
}
