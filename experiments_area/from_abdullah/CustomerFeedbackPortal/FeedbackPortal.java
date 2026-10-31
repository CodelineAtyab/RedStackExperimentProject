import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FeedbackPortal {

    static Scanner input = new Scanner(System.in);

    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> products = new ArrayList<>();
    static ArrayList<Integer> ratings = new ArrayList<>();
    static ArrayList<String> comments = new ArrayList<>();

    // The key is a product name; the value is the list of feedback positions.
    static HashMap<String, ArrayList<Integer>> productGroups = new HashMap<>();

    public static void main(String[] args) {
        printBanner();
        loadFeedback();

        boolean exit = false;

        while (!exit) {
            showMenu();
            System.out.print("Enter your choice: ");
            String choiceText = input.nextLine();

            int choice;

            try {
                choice = Integer.parseInt(choiceText);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                continue;
            }

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
                    if (saveFeedback()) {
                        System.out.println("Saved " + names.size()
                                + " feedback entries to feedback.txt");
                    }
                    break;
                case 6:
                    System.out.print("Saving feedback... ");
                    if (saveFeedback()) {
                        System.out.println("done.");
                    }
                    System.out.println("Thank you for using the Customer Feedback Portal. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                    break;
            }
        }

        input.close();
    }

    public static void printBanner() {
        String companyName = "OASIS TECH";
        int rows = 6;
        int bannerWidth = 36;

        System.out.println();

        for (int row = 1; row <= rows; row++) {
            // Print stars on the left.
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }

            int gapWidth = bannerWidth - (row * 2);

            if (row == 4) {
                int leftPadding = (gapWidth - companyName.length()) / 2;
                int rightPadding = gapWidth - companyName.length() - leftPadding;

                for (int space = 0; space < leftPadding; space++) {
                    System.out.print(" ");
                }

                System.out.print(companyName);

                for (int space = 0; space < rightPadding; space++) {
                    System.out.print(" ");
                }
            } else {
                for (int space = 0; space < gapWidth; space++) {
                    System.out.print(" ");
                }
            }

            // Print the matching stars on the right.
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void loadFeedback() {
        int loaded = 0;
        int skipped = 0;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("feedback.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", -1);

                if (parts.length == 4) {
                    try {
                        String name = parts[0].trim();
                        String product = parts[1].trim();
                        int rating = Integer.parseInt(parts[2].trim());
                        String comment = parts[3].trim();

                        if (!name.isEmpty() && !product.isEmpty()
                                && !comment.isEmpty()
                                && rating >= 1 && rating <= 5) {
                            storeFeedback(name, product, rating, comment);
                            loaded++;
                        } else {
                            skipped++;
                        }
                    } catch (NumberFormatException e) {
                        skipped++;
                    }
                } else {
                    skipped++;
                }
            }

            System.out.println("Loaded " + loaded
                    + " feedback entries from feedback.txt");

            if (skipped > 0) {
                System.out.println("Skipped " + skipped
                        + " damaged feedback line(s).");
            }

        } catch (FileNotFoundException e) {
            System.out.println("No saved feedback found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Could not read feedback.txt. Starting with saved entries already loaded.");
        }
    }

    public static void showMenu() {
        System.out.println();
        System.out.println("+====================================+");
        System.out.println("|      CUSTOMER FEEDBACK PORTAL      |");
        System.out.println("+====================================+");
        System.out.println("|   1. Submit Feedback               |");
        System.out.println("|   2. View All Feedback             |");
        System.out.println("|   3. Rating Report                 |");
        System.out.println("|   4. Search by Product             |");
        System.out.println("|   5. Save to File                  |");
        System.out.println("|   6. Exit                          |");
        System.out.println("+====================================+");
    }

    public static void submitFeedback() {
        System.out.println("\n--- Submit Feedback ---");

        String name = readText("Customer name: ", "Name");
        String product = readText("Product: ", "Product");
        int rating = readRating();
        String comment = readText("Comment: ", "Comment");

        storeFeedback(name, product, rating, comment);

        System.out.println("Thank you, " + name
                + "! Your feedback has been recorded.");
    }

    public static String readText(String prompt, String fieldName) {
        while (true) {
            System.out.print(prompt);
            String value = input.nextLine().trim();

            if (value.isEmpty()) {
                System.out.println(fieldName + " cannot be empty.");
            } else if (value.contains("|")) {
                System.out.println("Please do not use the | character.");
            } else {
                return value;
            }
        }
    }

    public static int readRating() {
        while (true) {
            System.out.print("Rating (1-5): ");
            String ratingText = input.nextLine();

            try {
                int rating = Integer.parseInt(ratingText);

                if (rating >= 1 && rating <= 5) {
                    return rating;
                } else {
                    System.out.println("Rating must be a number from 1 to 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Rating must be a number from 1 to 5.");
            }
        }
    }

    public static void storeFeedback(String name, String product,
                                     int rating, String comment) {
        int position = names.size();

        names.add(name);
        products.add(product);
        ratings.add(rating);
        comments.add(comment);

        String productKey = product.toLowerCase();

        if (!productGroups.containsKey(productKey)) {
            productGroups.put(productKey, new ArrayList<Integer>());
        }

        productGroups.get(productKey).add(position);
    }

    public static void viewAllFeedback() {
        if (names.size() == 0) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        System.out.printf("%-5s %-18s %-18s %-8s %s%n",
                "No.", "Customer", "Product", "Rating", "Comment");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%-5d %-18s %-18s %-8d %s%n",
                    i + 1, names.get(i), products.get(i),
                    ratings.get(i), comments.get(i));
        }
    }

    public static void showRatingReport() {
        if (names.size() == 0) {
            System.out.println("No feedback is available for the rating report.");
            return;
        }

        ArrayList<String> uniqueProducts = new ArrayList<>();

        // Find each different product name.
        for (int i = 0; i < products.size(); i++) {
            boolean alreadyAdded = false;

            for (int j = 0; j < uniqueProducts.size(); j++) {
                if (products.get(i).equalsIgnoreCase(uniqueProducts.get(j))) {
                    alreadyAdded = true;
                }
            }

            if (!alreadyAdded) {
                uniqueProducts.add(products.get(i));
            }
        }

        // Each row is a product. The five columns count ratings from 1 to 5.
        int[][] ratingCounts = new int[uniqueProducts.size()][5];
        int[] allRatings = new int[5];

        // Count the ratings in the 2D array.
        for (int i = 0; i < products.size(); i++) {
            for (int productRow = 0; productRow < uniqueProducts.size(); productRow++) {
                if (products.get(i).equalsIgnoreCase(uniqueProducts.get(productRow))) {
                    int ratingColumn = ratings.get(i) - 1;
                    ratingCounts[productRow][ratingColumn]++;
                    allRatings[ratingColumn]++;
                }
            }
        }

        System.out.printf("%-18s %4s %4s %4s %4s %4s %7s %9s%n",
                "Product", "1*", "2*", "3*", "4*", "5*", "Total", "Average");
        System.out.println("--------------------------------------------------------------------------");

        for (int productRow = 0; productRow < uniqueProducts.size(); productRow++) {
            int total = 0;
            int ratingSum = 0;

            System.out.printf("%-18s", uniqueProducts.get(productRow));

            for (int ratingColumn = 0; ratingColumn < 5; ratingColumn++) {
                int numberOfRatings = ratingCounts[productRow][ratingColumn];

                System.out.printf("%5d", numberOfRatings);
                total = total + numberOfRatings;
                ratingSum = ratingSum + (numberOfRatings * (ratingColumn + 1));
            }

            double average = (double) ratingSum / total;
            System.out.printf("%8d %9.2f%n", total, average);
        }

        System.out.println("\nRatings overview");

        for (int starValue = 5; starValue >= 1; starValue--) {
            System.out.print(starValue + " stars | ");

            for (int i = 0; i < allRatings[starValue - 1]; i++) {
                System.out.print("*");
            }

            System.out.println(" (" + allRatings[starValue - 1] + ")");
        }
    }

    public static void searchByProduct() {
        if (names.size() == 0) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        System.out.println("\n--- Search by Product ---");
        String productToSearch = readText("Product to search: ", "Product");
        String productKey = productToSearch.toLowerCase();

        if (!productGroups.containsKey(productKey)) {
            System.out.println("No feedback found for \"" + productToSearch + "\".");
            return;
        }

        ArrayList<Integer> positions = productGroups.get(productKey);
        String displayName = products.get(positions.get(0));
        int totalRating = 0;

        System.out.println("Found " + positions.size()
                + " entries for \"" + displayName + "\":");

        for (int i = 0; i < positions.size(); i++) {
            int position = positions.get(i);

            System.out.println("   " + names.get(position)
                    + "   " + ratings.get(position)
                    + "   " + comments.get(position));

            totalRating = totalRating + ratings.get(position);
        }

        double average = (double) totalRating / positions.size();
        System.out.printf("Average rating: %.2f%n", average);
    }

    public static boolean saveFeedback() {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("feedback.txt"))) {

            for (int i = 0; i < names.size(); i++) {
                writer.write(names.get(i) + "|"
                        + products.get(i) + "|"
                        + ratings.get(i) + "|"
                        + comments.get(i));
                writer.newLine();
            }

            return true;
        } catch (IOException e) {
            System.out.println("Error saving feedback: " + e.getMessage());
            return false;
        }
    }
}