import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class CustomerFeedbackPortal {

    static ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();

    static class Feedback {
        String name, product, comment;
        int rating;
    }

    static Scanner scanner = new Scanner(System.in);

    static String fileName = "feedback.txt";

    public static void main(String[] args) {

        printLogo();
        System.out.println();
        loadFeedback();

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice == 1) {
                    submitFeedback();
                } else if (choice == 2) {
                    viewFeedback();
                } else if (choice == 3) {
                    ratingReport();
                } else if (choice == 4) {
                    searchProduct();
                } else if (choice == 5) {
                    saveFeedback();
                } else if (choice == 6) {
                    System.out.println("Saving feedback...");
                    if (saveFeedback()) {
                        System.out.println("Saving feedback... done.");
                    } else {
                        System.out.println("Warning: feedback could not be saved.");
                    }
                    System.out.println("Thank you for using the Customer Feedback Portal. Goodbye!");
                    running = false;
                } else {
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }

            System.out.println();
        }
        scanner.close();
    }

    // Company Banner
    static void printLogo() {
        int rows = 6;
        String company = "ACME SOLUTIONS";
        int minGap = company.length() + 16;
        for (int row = 1; row <= rows; row++) {
            // Print left triangle
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }

            int gap = minGap + 2 * (rows - row);

            if (row == rows / 2 + 1) {
                int before = (gap - company.length()) / 2;
                int after = gap - company.length() - before;
                for (int s = 0; s < before; s++) {
                    System.out.print(" ");
                }
                System.out.print(company);
                for (int s = 0; s < after; s++) {
                    System.out.print(" ");
                }
            } else {
                for (int s = 0; s < gap; s++) {
                    System.out.print(" ");
                }
            }

            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }


    // Menu
    public static void printMenu() {
        System.out.println("+========================================+");
        System.out.printf("| %-38s |%n", "CUSTOMER FEEDBACK PORTAL");
        System.out.println("+========================================+");
        System.out.printf("| %-38s |%n", "1. Submit Feedback");
        System.out.printf("| %-38s |%n", "2. View All Feedback");
        System.out.printf("| %-38s |%n", "3. Rating Report");
        System.out.printf("| %-38s |%n", "4. Search by Product");
        System.out.printf("| %-38s |%n", "5. Save to File");
        System.out.printf("| %-38s |%n", "6. Exit");
        System.out.println("+========================================+");
    }

    // Submit Feedback
    static void submitFeedback() {
        Feedback f = new Feedback();

        System.out.println("\n--- Submit Feedback ---");

        do {
            System.out.print("Customer name: ");
            f.name = scanner.nextLine().trim();

            if (f.name.isEmpty()) {
                System.out.println("Name cannot be empty.");
            }
        } while (f.name.isEmpty());

        do {
            System.out.print("Product: ");
            f.product = scanner.nextLine().trim();

            if (f.product.isEmpty()) {
                System.out.println("Product cannot be empty.");
            }
        } while (f.product.isEmpty());

        while (true) {
            System.out.print("Rating (1-5): ");

            try {
                f.rating = Integer.parseInt(scanner.nextLine().trim());

                if (f.rating >= 1 && f.rating <= 5) {
                    break;
                }

                System.out.println("Rating must be a number from 1 to 5.");

            } catch (NumberFormatException e) {
                System.out.println("Rating must be a number from 1 to 5.");
            }
        }

        do {
            System.out.print("Comment: ");
            f.comment = scanner.nextLine().trim();

            if (f.comment.isEmpty()) {
                System.out.println("Comment cannot be empty.");
            }
        } while (f.comment.isEmpty());

        feedbackList.add(f);

        System.out.println("Thank you, " + f.name + "! Your feedback has been recorded.");
    }

    // View All Feedback
    static void viewFeedback() {
        System.out.println("\n--- View All Feedback ---");

        if (feedbackList.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        System.out.printf("%-5s %-15s %-15s %-7s %s%n",
                "No.", "Customer", "Product", "Rating", "Comment");

        System.out.println("----- --------------- --------------- ------- ------------------------------");

        for (int i = 0; i < feedbackList.size(); i++) {
            Feedback f = feedbackList.get(i);

            System.out.printf("%-5d %-15s %-15s %-7d %s%n",
                    i + 1, f.name, f.product, f.rating, f.comment);
        }
    }

    // Rating Report
    static void ratingReport() {
        System.out.println("\n--- Rating Report ---");

        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
            return;
        }

        ArrayList<String> products = new ArrayList<>();

        for (Feedback f : feedbackList) {
            boolean found = false;

            for (String product : products) {
                if (product.equalsIgnoreCase(f.product)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                products.add(f.product);
            }
        }

        int[][] ratings = new int[products.size()][5];

        for (Feedback f : feedbackList) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).equalsIgnoreCase(f.product)) {
                    ratings[i][f.rating - 1]++;
                    break;
                }
            }
        }

        System.out.printf("%-15s %3s %3s %3s %3s %3s %6s %8s%n",
                "Product", "1*", "2*", "3*", "4*", "5*", "Total", "Average");

        System.out.println(
                "--------------- --- --- --- --- --- ------ --------");

        for (int i = 0; i < products.size(); i++) {
            int total = 0;
            int sum = 0;

            System.out.printf("%-15s", products.get(i));

            for (int j = 0; j < 5; j++) {
                int count = ratings[i][j];

                System.out.printf(" %3d", count);

                total += count;
                sum += count * (j + 1);
            }

            double average = (double) sum / total;

            System.out.printf(" %6d %8.2f%n", total, average);
        }

        System.out.println("\nRatings overview");

        for (int star = 5; star >= 1; star--) {
            int count = 0;

            for (int i = 0; i < products.size(); i++) {
                count += ratings[i][star - 1];
            }

            System.out.printf("%d star%s | ",
                    star, star == 1 ? " " : "s");

            for (int j = 0; j < count; j++) {
                System.out.print("*");
            }

            System.out.println(" (" + count + ")");
        }
    }

    // Search by Product
    static void searchProduct() {
        System.out.println("\n--- Search by Product ---");

        if (feedbackList.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        HashMap<String, ArrayList<Feedback>> map = new HashMap<>();

        // Group feedback by product
        for (Feedback f : feedbackList) {
            String key = f.product.toLowerCase(Locale.ROOT);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<Feedback>());
            }

            map.get(key).add(f);
        }

        String product;

        do {
            System.out.print("Product to search: ");
            product = scanner.nextLine().trim();

            if (product.isEmpty()) {
                System.out.println("Product name cannot be empty.");
            }
        } while (product.isEmpty());

        String key = product.toLowerCase(Locale.ROOT);

        if (!map.containsKey(key)) {
            System.out.println("No feedback found for \"" + product + "\".");
            return;
        }

        ArrayList<Feedback> matches = map.get(key);

        String displayName = matches.get(0).product;

        System.out.printf("Found %d entries for \"%s\":%n",
                matches.size(), displayName);

        System.out.printf("%-15s %-7s %s%n",
                "Customer", "Rating", "Comment");

        int sum = 0;

        for (Feedback f : matches) {
            System.out.printf("%-15s %-7d %s%n",
                    f.name, f.rating, f.comment);

            sum += f.rating;
        }

        double average = (double) sum / matches.size();

        System.out.printf("Average rating: %.2f%n", average);
    }

    // Save Feedback
    static boolean saveFeedback() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            for (Feedback f : feedbackList) {
                writer.write(f.name +" "+ f.product+" "+ f.rating+" "+ f.comment);
                writer.newLine();
            }

            System.out.printf("Saved %d feedback entries to %s%n",
                    feedbackList.size(), fileName);

            return true;

        } catch (IOException e) {
            System.out.println("Error saving feedback: " + e.getMessage());
            return false;
        }
    }

    //Load Saved Feedback
    static void loadFeedback() {
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("No saved feedback found. Starting fresh.");
            return;
        }

        int loaded = 0;
        int skipped = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String name;

            while ((name = reader.readLine()) != null) {
                String product = reader.readLine();
                String rating = reader.readLine();
                String comment = reader.readLine();

                if (product == null || rating == null || comment == null) {
                    skipped++;
                    break;
                }

                try {
                    int stars = Integer.parseInt(rating.trim());

                    if (name.trim().isEmpty() ||
                            product.trim().isEmpty() ||
                            comment.trim().isEmpty() ||
                            stars < 1 || stars > 5) {
                        skipped++;
                        continue;
                    }

                    Feedback f = new Feedback();

                    f.name = name;
                    f.product = product;
                    f.rating = stars;
                    f.comment = comment;

                    feedbackList.add(f);
                    loaded++;

                } catch (NumberFormatException e) {
                    skipped++;
                }
            }

            System.out.printf("Loaded %d feedback entries from %s%n",
                    loaded, fileName);

        } catch (IOException e) {
            System.out.println("Error loading feedback: " + e.getMessage());
            System.out.println("Continuing with any valid feedback loaded so far.");
        }

        if (skipped > 0) {
            System.out.println("Skipped " + skipped + " damaged feedback record(s).");
        }
    }
}
