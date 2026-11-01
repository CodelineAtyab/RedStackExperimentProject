import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class CustomerFeedback {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<HashMap<String, String>> feedbackEntries = new ArrayList<>();

    static Map<String, Runnable> MENU = new LinkedHashMap<>();
    static boolean exit = false;

    static {
        MENU.put("Submit Feedback", () -> SubmitFeedback());
        MENU.put("View All Feedback", () -> ViewAllFeedback());
        MENU.put("Rating Report", () -> RatingReport());
        MENU.put("Search by Product", () -> SearchByProduct());
        MENU.put("Save to File", () -> SaveToFile());
        MENU.put("Exit", () -> {
            SaveToFile();
            System.out.println("Thank you!");
            exit = true;
        });
    }

    static void printMenu() {
        String line = "+" + "=".repeat(41) + "+";
        System.out.println("\n" + line);
        System.out.println("|         CUSTOMER FEEDBACK PORTAL        |");
        System.out.println(line);

        List<String> labels = new ArrayList<>(MENU.keySet());
        for (int i = 0; i < labels.size(); i++) {
            System.out.printf("| %-39s |%n", (i + 1) + ". " + labels.get(i));
        }

        System.out.println(line);
    }

    public static void main(String[] args) {
        printBanner();
        try {
            LoadFeedback();
        } catch (Exception e) {
            System.out.println("No saved feedback found. Starting fresh.");
        }

        List<Runnable> actions = new ArrayList<>(MENU.values());

        do {
            printMenu();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= actions.size()) {
                    actions.get(choice - 1).run();
                } else {
                    System.out.println("Invalid choice. Please enter a number from 1 to " + actions.size() + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number from 1 to " + actions.size() + ".");
            }
        } while (!exit);
    }


    static void printBanner() {
        String bannerText = "ACME SOLUTIONS ";
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i + 1; j++) {

                System.out.print("* ");

                if (j == i) {
                    if (i == 3) {
                        System.out.print("       ");
                        System.out.print(bannerText);
                        System.out.print("      ");
                    } else
                        for (int spaces = 10; spaces > i; spaces--) {
                            System.out.print("    ");
                        }

                    for (int l = 0; l < j + 1; l++) {

                        System.out.print(" *");
                    }
                }
            }
            System.out.println();
        }
    }

    static void LoadFeedback() throws IOException {
        feedbackEntries.clear();
        BufferedReader fileReader = new BufferedReader(new FileReader("feedback.txt"));
        String cLine = fileReader.readLine();
        while (cLine != null) {
            String[] fields = cLine.split(",", 5);
            if (fields.length == 5) {
                HashMap<String, String> record = new HashMap<>();
                record.put("No", fields[0]);
                record.put("Customer", fields[1]);
                record.put("Product", fields[2]);
                record.put("Rating", fields[3]);
                record.put("Comment", fields[4]);
                feedbackEntries.add(record);
            }
            cLine = fileReader.readLine();
        }
        fileReader.close();

        if (!feedbackEntries.isEmpty()) {
            System.out.println("Loaded " + feedbackEntries.size() + " feedback entries from feedback.txt");
        }
    }

    static void SubmitFeedback() {
        String name = "";
        String product = "";
        int rating = 0;
        String comment = "";

        System.out.println("--- Submit Feedback ---");

        System.out.print("Customer name: ");
        name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Customer name: ");
            name = scanner.nextLine().trim();
        }

        System.out.print("Product: ");
        product = scanner.nextLine().trim();

        System.out.print("Rating (1-5): ");
        while (true) {
            String userInput = scanner.nextLine().trim();
            try {
                rating = Integer.parseInt(userInput);
                if (rating >= 1 && rating <= 5) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Rating must be a number from 1 to 5. Rating (1-5): ");
        }

        System.out.print("Comment: ");
        comment = scanner.nextLine().trim();


        HashMap<String, String> rec = new HashMap<>();
        rec.put("No", String.valueOf(feedbackEntries.size() + 1));
        rec.put("Customer", name);
        rec.put("Product", product);
        rec.put("Rating", String.valueOf(rating));
        rec.put("Comment", comment);
        feedbackEntries.add(rec);
        System.out.println("Thank you, " + name + "! Your feedback has been recorded.");
    }

    static void ViewAllFeedback() {
        if (feedbackEntries.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        System.out.printf("%-5s %-10s %-12s %-8s %s%n", "No.", "Customer", "Product", "Rating", "Comment");
        System.out.printf("%-5s %-10s %-12s %-8s %s%n", "---", "--------", "-------", "------", "-------");

        for (int i = 0; i < feedbackEntries.size(); i++) {
            HashMap<String, String> rec = feedbackEntries.get(i);
            System.out.printf("%-5s %-10s %-12s %-8s %s%n",
                    rec.get("No"),
                    rec.get("Customer"),
                    rec.get("Product"),
                    rec.get("Rating"),
                    rec.get("Comment"));
        }
    }

    static void RatingReport() {
        if (feedbackEntries.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        ArrayList<String> productNames = new ArrayList<>();
        for (HashMap<String, String> record : feedbackEntries) {
            String productName = record.get("Product").trim();
            if (!productNames.contains(productName)) {
                productNames.add(productName);
            }
        }


        int[][] countsPerProduct = new int[productNames.size()][5];
        int[] starCounts = new int[5];

        for (HashMap<String, String> record : feedbackEntries) {
            String productName = record.get("Product").trim();
            int productIndex = productNames.indexOf(productName);
            try {
                int rating = Integer.parseInt(record.get("Rating").trim());
                if (rating >= 1 && rating <= 5) {
                    countsPerProduct[productIndex][rating - 1]++;
                    starCounts[rating - 1]++;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }


        System.out.printf("%-12s %-4s %-4s %-4s %-4s %-4s %-7s %s%n", "Product", "1*", "2*", "3*", "4*", "5*", "Total", "Average");
        System.out.printf("%-12s %-4s %-4s %-4s %-4s %-4s %-7s %s%n", "-------", "---", "---", "---", "---", "---", "-----", "-------");

        for (int i = 0; i < productNames.size(); i++) {
            String productName = productNames.get(i);
            int ratingSum = 0;
            int ratingCount = 0;
            for (int r = 0; r < 5; r++) {
                int count = countsPerProduct[i][r];
                ratingSum += count * (r + 1);
                ratingCount += count;
            }
            double averageRating = ratingCount > 0 ? (double) ratingSum / ratingCount : 0.0;

            System.out.printf("%-12s %-4d %-4d %-4d %-4d %-4d %-7d %.2f%n", productName, countsPerProduct[i][0], countsPerProduct[i][1], countsPerProduct[i][2], countsPerProduct[i][3], countsPerProduct[i][4], ratingCount, averageRating);
        }

        System.out.println("\nRatings overview");
        for (int star = 5; star >= 1; star--) {
            int count = starCounts[star - 1];
            String stars = "";
            for (int b = 0; b < count; b++) {
                stars += "* ";
            }
            stars = stars.trim();

            String label = (star == 1) ? "1 star " : star + " stars";
            System.out.printf("%-8s | %-5s (%d)%n", label, stars, count);
        }
    }

    static void SearchByProduct() {
        System.out.println("--- Search by Product ---");
        System.out.print("Product to search: ");
        String typProd = scanner.nextLine().trim();
        String lowerKey = typProd.toLowerCase();

        ArrayList<HashMap<String, String>> match = new ArrayList<>();
        for (int i = 0; i < feedbackEntries.size(); i++) {
            HashMap<String, String> rec = feedbackEntries.get(i);
            if (rec.get("Product").trim().toLowerCase().equals(lowerKey)) {
                match.add(rec);
            }
        }

        if (match.isEmpty()) {
            System.out.println("No feedback found for \"" + typProd + "\".");
            return;
        }

        String displayName = match.get(0).get("Product").trim();
        System.out.println("Found " + match.size() + " entries for \"" + displayName + "\":");

        int ratingTotal = 0;
        for (int i = 0; i < match.size(); i++) {
            HashMap<String, String> record = match.get(i);
            String customer = record.get("Customer").trim();
            String rating = record.get("Rating").trim();
            String comment = record.get("Comment").trim();

            ratingTotal += Integer.parseInt(rating);
            System.out.printf("     %-8s %-4s %s%n", customer, rating, comment);
        }

        double averageRating = (double) ratingTotal / match.size();
        System.out.printf("Average rating: %.2f%n", averageRating);
    }

    static void SaveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt"))) {
            for (int i = 0; i < feedbackEntries.size(); i++) {
                HashMap<String, String> record = feedbackEntries.get(i);
                writer.write(record.get("No") + "," + record.get("Customer") + "," + record.get("Product") + "," + record.get("Rating") + "," + record.get("Comment"));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to feedback.txt");
        }
    }
}
