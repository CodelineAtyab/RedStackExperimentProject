import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FeedbackProtal {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<HashMap<String, String>> feedbackList = new ArrayList<>();

    static void Logo() {
        String Text = "ACME SOLUTIONS ";
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i + 1; j++) {

                System.out.print("* ");

                if (j == i) {
                    if (i == 3) {
                        System.out.print("       ");
                        System.out.print(Text);
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
        feedbackList.clear();
        BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"));
        String line = reader.readLine();
        while (line != null) {
            String[] parts = line.split(",", 5);
            if (parts.length == 5) {
                HashMap<String, String> entry = new HashMap<>();
                entry.put("No", parts[0]);
                entry.put("Customer", parts[1]);
                entry.put("Product", parts[2]);
                entry.put("Rating", parts[3]);
                entry.put("Comment", parts[4]);
                feedbackList.add(entry);
            }
            line = reader.readLine();
        }
        reader.close();

        if (!feedbackList.isEmpty()) {
            System.out.println("Loaded " + feedbackList.size() + " feedback entries from feedback.txt");
        }
    }

    static void SubmitFeedback() {
        String name = "";
        String product = "";
        int rating = 0;
        String comment = "";

        System.out.println("--- Submit Feedback ---");

        System.out.print("Customer name: ");
        name = sc.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Customer name: ");
            name = sc.nextLine().trim();
        }

        System.out.print("Product: ");
        product = sc.nextLine().trim();

        System.out.print("Rating (1-5): ");
        while (true) {
            String input = sc.nextLine().trim();
            try {
                rating = Integer.parseInt(input);
                if (rating >= 1 && rating <= 5) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Rating must be a number from 1 to 5. Rating (1-5): ");
        }

        System.out.print("Comment: ");
        comment = sc.nextLine().trim();

        // save in data collection
        HashMap<String, String> entry = new HashMap<>();
        entry.put("No", String.valueOf(feedbackList.size() + 1));
        entry.put("Customer", name);
        entry.put("Product", product);
        entry.put("Rating", String.valueOf(rating));
        entry.put("Comment", comment);
        feedbackList.add(entry);
        System.out.println("Thank you, " + name + "! Your feedback has been recorded.");
    }

    static void ViewAllFeedback() {
        boolean hasData = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"))) {
            String line = reader.readLine();
            if (line != null) {
                hasData = true;
                // columns
                System.out.printf("%-5s %-10s %-12s %-8s %s%n", "No.", "Customer", "Product", "Rating", "Comment");
                System.out.printf("%-5s %-10s %-12s %-8s %s%n", "---", "--------", "-------", "------", "-------");

                // data from feedback.txt
                while (line != null) {
                    String[] parts = line.split(",", 5);
                    if (parts.length == 5) {
                        System.out.printf("%-5s %-10s %-12s %-8s %s%n",
                                parts[0], parts[1], parts[2], parts[3], parts[4]);
                    }
                    line = reader.readLine();
                }
            }
        } catch (IOException e) {
            System.out.println("No feedback has been submitted yet.");
        }

        if (!hasData) {
            System.out.println("No feedback has been submitted yet.");
        }
    }

    static void RatingReport() {
        ArrayList<String> products = new ArrayList<>();
        ArrayList<String[]> allEntries = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",", 5);
                if (parts.length == 5) {
                    allEntries.add(parts);
                    String prod = parts[2].trim();
                    if (!products.contains(prod)) {
                        products.add(prod);
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        if (allEntries.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        // 2D array (rows,cols)
        int[][] ratingCounts = new int[products.size()][5];
        int[] starTotals = new int[5];

        for (String[] entry : allEntries) {
            String prod = entry[2].trim();
            int prodIndex = products.indexOf(prod);
            try {
                int rating = Integer.parseInt(entry[3].trim());
                if (rating >= 1 && rating <= 5) {
                    ratingCounts[prodIndex][rating - 1]++;
                    starTotals[rating - 1]++;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        // columns
        System.out.printf("%-12s %-4s %-4s %-4s %-4s %-4s %-7s %s%n", "Product", "1*", "2*", "3*", "4*", "5*", "Total",
                "Average");
        System.out.printf("%-12s %-4s %-4s %-4s %-4s %-4s %-7s %s%n", "-------", "---", "---", "---", "---", "---",
                "-----", "-------");

        for (int i = 0; i < products.size(); i++) {
            String prod = products.get(i);
            int sumRatings = 0;
            int totalCount = 0;
            for (int r = 0; r < 5; r++) {
                int count = ratingCounts[i][r];
                sumRatings += count * (r + 1);
                totalCount += count;
            }
            double average = totalCount > 0 ? (double) sumRatings / totalCount : 0.0;

            System.out.printf("%-12s %-4d %-4d %-4d %-4d %-4d %-7d %.2f%n",
                    prod,
                    ratingCounts[i][0],
                    ratingCounts[i][1],
                    ratingCounts[i][2],
                    ratingCounts[i][3],
                    ratingCounts[i][4],
                    totalCount,
                    average);
        }

        System.out.println("\nRatings overview");
        for (int star = 5; star >= 1; star--) {
            int count = starTotals[star - 1];
            String starsBar = "";
            for (int b = 0; b < count; b++) {
                starsBar += "* ";
            }
            starsBar = starsBar.trim();

            String starLabel = (star == 1) ? "1 star " : star + " stars";
            System.out.printf("%-8s | %-5s (%d)%n", starLabel, starsBar, count);
        }
    }

    static void SearchByProduct() {
        System.out.println("--- Search by Product ---");
        System.out.print("Product to search: ");
        String searchInput = sc.nextLine().trim();

        // Key-value data structure to group feedback entries by product name[cite: 6]
        HashMap<String, ArrayList<String[]>> productMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",", 5);
                if (parts.length == 5) {
                    String product = parts[2].trim();
                    productMap.putIfAbsent(product.toLowerCase(), new ArrayList<>());
                    productMap.get(product.toLowerCase()).add(parts);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String searchKey = searchInput.toLowerCase();
        if (!productMap.containsKey(searchKey)) {
            System.out.println("No feedback found for \"" + searchInput + "\".");
            return;
        }

        ArrayList<String[]> entries = productMap.get(searchKey);
        String actualProduct = entries.get(0)[2].trim();

        System.out.println("Found " + entries.size() + " entries for \"" + actualProduct + "\":");

        int totalRating = 0;
        for (String[] entry : entries) {
            String customer = entry[1].trim();
            String rating = entry[3].trim();
            String comment = entry[4].trim();

            totalRating += Integer.parseInt(rating);
            System.out.printf("     %-8s %-4s %s%n", customer, rating, comment);
        }

        double average = (double) totalRating / entries.size();
        System.out.printf("Average rating: %.2f%n", average);
    }

    static void SaveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt"))) {
            for (HashMap<String, String> entry : feedbackList) {
                writer.write(entry.get("No") + "," +
                        entry.get("Customer") + "," +
                        entry.get("Product") + "," +
                        entry.get("Rating") + "," +
                        entry.get("Comment"));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to feedback.txt");
        }
    }

    public static void main(String[] args) {
        Logo();
        try {
            LoadFeedback();
        } catch (Exception e) {
            System.out.println("No saved feedback found. Starting fresh.");
        }

        boolean stop = false;
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
            String input = sc.nextLine();

            switch (input) {
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
                    break;
                case "6":
                    stop = true;
                    SaveToFile();
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");

            }

        } while (!stop);

    }
}
