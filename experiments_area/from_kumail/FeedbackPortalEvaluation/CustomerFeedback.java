import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CustomerFeedback {

    static Scanner inp = new Scanner(System.in);
    static ArrayList<HashMap<String, String>> feedbackList = new ArrayList<>();

    public static void main(String[] args) {
        printBanner();
        try {
            LoadFeedback();
        } catch (Exception e) {
            System.out.println("No saved feedback found. Starting fresh.");
        }

        boolean shouldExit = false;
        do {
            System.out.println("\n+=========================================+");
            System.out.println("|         CUSTOMER FEEDBACK PORTAL        |");
            System.out.println("+=========================================+");
            System.out.println("| 1. Submit Feedback                      |");
            System.out.println("| 2. View All Feedback                    |");
            System.out.println("| 3. Rating Report                        |");
            System.out.println("| 4. Search by Product                    |");
            System.out.println("| 5. Save to File                         |");
            System.out.println("| 6. Exit                                 |");
            System.out.println("+=========================================+");
            System.out.print("Enter your choice: ");
            String menuChoice = inp.nextLine();

            switch (menuChoice) {
                case "1":
                    SubmitFeedback();
                    break;
                case "2":
                    ViewAllFeedback();
                    break;
                case "3":
                    RatingReport();
                    break;
                case "4":
                    SearchByProduct();
                    break;
                case "5":
                    SaveToFile();
                    System.out.println("Saved " + feedbackList.size() + " feedback entries to feedback.txt");
                    break;
                case "6":
                    shouldExit = true;
                    System.out.print("Saving feedback... ");
                    SaveToFile();
                    System.out.println("done.");
                    System.out.println("Thank you for using the Customer Feedback Portal. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }

        } while (!shouldExit);
    }

    static void printBanner() {
        String companyTitle = "ACME SOLUTIONS ";
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < row + 1; col++) {

                System.out.print("* ");

                if (col == row) {
                    if (row == 3) {
                        System.out.print("       ");
                        System.out.print(companyTitle);
                        System.out.print("      ");
                    } else
                        for (int padCount = 10; padCount > row; padCount--) {
                            System.out.print("    ");
                        }

                    for (int starIndex = 0; starIndex < col + 1; starIndex++) {

                        System.out.print(" *");
                    }
                }
            }
            System.out.println();
        }
    }

    static void LoadFeedback() throws IOException {
        feedbackList.clear();
        BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"));
        String currentLine = reader.readLine();
        while (currentLine != null) {
            String[] parts = currentLine.split(",", 5);
            if (parts.length == 5) {
                HashMap<String, String> entry = new HashMap<>();
                entry.put("No", parts[0]);
                entry.put("Customer", parts[1]);
                entry.put("Product", parts[2]);
                entry.put("Rating", parts[3]);
                entry.put("Comment", parts[4]);
                feedbackList.add(entry);
            }
            currentLine = reader.readLine();
        }
        reader.close();

        if (!feedbackList.isEmpty()) {
            System.out.println("Loaded " + feedbackList.size() + " feedback entries from feedback.txt");
        }
    }

    static void SubmitFeedback() {
        String customerName = "";
        String productName = "";
        int ratingValue = 0;
        String commentText = "";

        System.out.println("--- Submit Feedback ---");

        System.out.print("Customer name: ");
        customerName = inp.nextLine().trim();
        while (customerName.isEmpty()) {
            System.out.print("Name cannot be empty. Customer name: ");
            customerName = inp.nextLine().trim();
        }

        System.out.print("Product: ");
        productName = inp.nextLine().trim();
        while (productName.isEmpty()) {
            System.out.print("Product cannot be empty. Product: ");
            productName = inp.nextLine().trim();
        }

        System.out.print("Rating (1-5): ");
        while (true) {
            String ratingInput = inp.nextLine().trim();
            try {
                ratingValue = Integer.parseInt(ratingInput);
                if (ratingValue >= 1 && ratingValue <= 5) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Rating must be a number from 1 to 5. Rating (1-5): ");
        }

        System.out.print("Comment: ");
        commentText = inp.nextLine().trim();


        HashMap<String, String> newEntry = new HashMap<>();
        newEntry.put("No", String.valueOf(feedbackList.size() + 1));
        newEntry.put("Customer", customerName);
        newEntry.put("Product", productName);
        newEntry.put("Rating", String.valueOf(ratingValue));
        newEntry.put("Comment", commentText);
        feedbackList.add(newEntry);
        System.out.println("Thank you, " + customerName + "! Your feedback has been recorded.");
    }

    static void ViewAllFeedback() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        System.out.printf("%-5s %-10s %-12s %-8s %s%n", "No.", "Customer", "Product", "Rating", "Comment");
        System.out.printf("%-5s %-10s %-12s %-8s %s%n", "---", "--------", "-------", "------", "-------");

        for (int idx = 0; idx < feedbackList.size(); idx++) {
            HashMap<String, String> entry = feedbackList.get(idx);
            System.out.printf("%-5s %-10s %-12s %-8s %s%n",
                    entry.get("No"),
                    entry.get("Customer"),
                    entry.get("Product"),
                    entry.get("Rating"),
                    entry.get("Comment"));
        }
    }

    static void RatingReport() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        ArrayList<String> uniqueProducts = new ArrayList<>();
        for (int i = 0; i < feedbackList.size(); i++) {
            HashMap<String, String> entry = feedbackList.get(i);
            String currentProduct = entry.get("Product").trim();
            if (!uniqueProducts.contains(currentProduct)) {
                uniqueProducts.add(currentProduct);
            }
        }


        int[][] productRatingCounts = new int[uniqueProducts.size()][5];
        int[] overallStarCounts = new int[5];

        for (int i = 0; i < feedbackList.size(); i++) {
            HashMap<String, String> entry = feedbackList.get(i);
            String currentProduct = entry.get("Product").trim();
            int productPos = uniqueProducts.indexOf(currentProduct);
            try {
                int parsedRating = Integer.parseInt(entry.get("Rating").trim());
                if (parsedRating >= 1 && parsedRating <= 5) {
                    productRatingCounts[productPos][parsedRating - 1]++;
                    overallStarCounts[parsedRating - 1]++;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }


        System.out.printf("%-12s %-4s %-4s %-4s %-4s %-4s %-7s %s%n", "Product", "1*", "2*", "3*", "4*", "5*", "Total", "Average");
        System.out.printf("%-12s %-4s %-4s %-4s %-4s %-4s %-7s %s%n", "-------", "---", "---", "---", "---", "---", "-----", "-------");

        for (int p = 0; p < uniqueProducts.size(); p++) {
            String currentProduct = uniqueProducts.get(p);
            int weightedSum = 0;
            int totalRatings = 0;
            for (int s = 0; s < 5; s++) {
                int starTotal = productRatingCounts[p][s];
                weightedSum += starTotal * (s + 1);
                totalRatings += starTotal;
            }
            double avgRating = totalRatings > 0 ? (double) weightedSum / totalRatings : 0.0;

            System.out.printf("%-12s %-4d %-4d %-4d %-4d %-4d %-7d %.2f%n", currentProduct, productRatingCounts[p][0], productRatingCounts[p][1], productRatingCounts[p][2], productRatingCounts[p][3], productRatingCounts[p][4], totalRatings, avgRating);
        }

        System.out.println("\nRatings overview");
        for (int starLevel = 5; starLevel >= 1; starLevel--) {
            int starTotal = overallStarCounts[starLevel - 1];
            String starBar = "";
            for (int k = 0; k < starTotal; k++) {
                starBar += "* ";
            }
            starBar = starBar.trim();

            String starLabel = (starLevel == 1) ? "1 star " : starLevel + " stars";
            System.out.printf("%-8s | %-5s (%d)%n", starLabel, starBar, starTotal);
        }
    }

    static void SearchByProduct() {
        System.out.println("--- Search by Product ---");
        System.out.print("Product to search: ");
        String searchTerm = inp.nextLine().trim();
        String searchKey = searchTerm.toLowerCase();

        ArrayList<HashMap<String, String>> matches = new ArrayList<>();
        for (int idx = 0; idx < feedbackList.size(); idx++) {
            HashMap<String, String> entry = feedbackList.get(idx);
            if (entry.get("Product").trim().toLowerCase().equals(searchKey)) {
                matches.add(entry);
            }
        }

        if (matches.isEmpty()) {
            System.out.println("No feedback found for \"" + searchTerm + "\".");
            return;
        }

        String productLabel = matches.get(0).get("Product").trim();
        System.out.println("Found " + matches.size() + " entries for \"" + productLabel + "\":");

        int sumOfRatings = 0;
        for (int idx = 0; idx < matches.size(); idx++) {
            HashMap<String, String> entry = matches.get(idx);
            String customerName = entry.get("Customer").trim();
            String ratingText = entry.get("Rating").trim();
            String commentText = entry.get("Comment").trim();

            sumOfRatings += Integer.parseInt(ratingText);
            System.out.printf("     %-8s %-4s %s%n", customerName, ratingText, commentText);
        }

        double avgRating = (double) sumOfRatings / matches.size();
        System.out.printf("Average rating: %.2f%n", avgRating);
    }

    static void SaveToFile() {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("feedback.txt"))) {
            for (int idx = 0; idx < feedbackList.size(); idx++) {
                HashMap<String, String> entry = feedbackList.get(idx);
                fileWriter.write(entry.get("No") + "," + entry.get("Customer") + "," + entry.get("Product") + "," + entry.get("Rating") + "," + entry.get("Comment"));
                fileWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to feedback.txt");
        }
    }
}