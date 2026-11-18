import java.io.*;
import java.util.*;

public class CustomerFeedbackPortalEvaluation {
    static Scanner scanner = new Scanner(System.in);
    // Stores each feedback entry as one String
    static ArrayList<String> feedbackEntries = new ArrayList<>();

    public static void printLogoBanner() {
        int rows = 6;
        int middleRow = rows / 2;
        String companyName = "ACME SOLUTIONS";
        int fixedGap = companyName.length() + 2; 

        for (int row = 1; row <= rows; row++) {
            // Left triangle
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            
            // Print the company name on the middle row
            if (row == middleRow) {
                System.out.print("    " + companyName + "    " );
            } else {
                // Fixed space 
                for (int space = 0; space < fixedGap; space++) {
                    System.out.print(" ");
                }
                // Changing space 
                for (int space = 1; space <= 2*(rows - row); space++) {
                    System.out.print(" ");
                }
            }

            // Mirrored right triangle
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void loadSavedFeedback() {
        int count = 0;
        // Open the file and close it automatically when finished
        try (BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"))) {
            String line;
            // Read each saved entry and add it to the list
            while ((line = reader.readLine()) != null) {
                feedbackEntries.add(line);
                count++;
            }

            System.out.println("Loaded " + count + " feedback entries from feedback.txt");

        } catch (IOException e) {
            System.out.println("No saved feedback found. Starting fresh");
        }
    }

    public static void showMenu() {
        System.out.println("+====================================+");
        System.out.println("|      CUSTOMER FEEDBACK PORTAL      |");
        System.out.println("+====================================+");
        System.out.println("| 1. Submit Feedback                 |");
        System.out.println("| 2. View All Feedback               |");
        System.out.println("| 3. Rating Report                   |");
        System.out.println("| 4. Search by Product               |");
        System.out.println("| 5. Save to File                    |");
        System.out.println("| 6. Exit                            |");
        System.out.println("+====================================+");
    }

    public static void submitFeedback() {
        System.out.println("--- Submit Feedback ---");

        String name;
        while (true) {
            System.out.print("Customer name: ");
            name = scanner.nextLine();

            if (!name.isEmpty()) {
                break;
            }

            System.out.println("Name cannot be empty.");
        }

        System.out.print("Product: ");
        String product = scanner.nextLine();

        int rating = 0;
        while (rating < 1 || rating > 5) {
            System.out.print("Rating (1-5): ");
            String answer = scanner.nextLine();

            try {
                rating = Integer.parseInt(answer);
            } catch (NumberFormatException e) {
                rating = 0;
            }

            if (rating < 1 || rating > 5) {
                System.out.println("Rating must be a number from 1 to 5.");
            }
        }

        System.out.print("Comment: ");
        String comment = scanner.nextLine();

        feedbackEntries.add(name + "|" + product + "|" + rating + "|" + comment);
        System.out.println("Thank you, " + name + "! Your feedback has been recorded.");
    }

    public static void viewAllFeedback() {
        if (feedbackEntries.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }
        // % starts formatting; - left-aligns; 4 is the column width; s prints text; n starts a new line.
        System.out.printf("%-4s %-10s %-12s %-6s %s%n", "No.", "Customer", "Product", "Rating", "Comment");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < feedbackEntries.size(); i++) {
            String[] parts = feedbackEntries.get(i).split("\\|");
            System.out.printf("%-4d %-10s %-12s %-6s %s%n", i + 1, parts[0], parts[1], parts[2], parts[3]);
        }
    }

    public static void showRatingReport() {

        // Create the product list - holds each product name once even with multiple feedbacks
        ArrayList<String> products = new ArrayList<>();

        // Going through every saved feedback entry
        for (int i = 0; i < feedbackEntries.size(); i++) {
            // Split and print each saved feedback entry
            String[] parts = feedbackEntries.get(i).split("\\|");
            String product = parts[1];

            if (!products.contains(product)) {
                products.add(product);
            }
        }

        // 2D Array Rows are products; the 5 columns are ratings 1 to 5
        int[][] counts = new int[products.size()][5];

        // Read every feedback entry and count its rating in the table.
        for (int i = 0; i < feedbackEntries.size(); i++) {
            // Split this entry into customer, product, rating, and comment.
            String[] parts = feedbackEntries.get(i).split("\\|");

            // Find the row for this product in the products list.
            int productRow = products.indexOf(parts[1]);

            // Convert the rating text to a integer, then to a column index:
            int ratingColumn = Integer.parseInt(parts[2]) - 1;

            // Add one to this product's count for this specific star rating.
            counts[productRow][ratingColumn]++;
        }

        // Print the report headings in fixed-width columns.
        System.out.printf("%-12s %3s %3s %3s %3s %3s %5s %7s%n", "Product", "1*", "2*", "3*", "4*", "5*", "Total", "Average");

        // Print one row of counts and results for each product.
        for (int row = 0; row < products.size(); row++) {
            int total = 0;      // Number of feedback entries for this product
            int ratingSum = 0;  // Sum of their star values

            // Add the five rating counts
            for (int column = 0; column < 5; column++) {
                total += counts[row][column];

                // Column 0 represents 1 star, column 1 represents 2 stars and so on.
                ratingSum += counts[row][column] * (column + 1);
            }

            // Divide the star-value sum by the number of ratings.
            double average = (double) ratingSum / total;

            // %.2f prints the average with two decimal places; %n starts a new line.
            System.out.printf("%-12s %3d %3d %3d %3d %3d %5d %7.2f%n", products.get(row), counts[row][0], counts[row][1], counts[row][2], counts[row][3], counts[row][4], total, average);
        }

        // Print a summary of all ratings, from 5 stars down to 1 star
        System.out.println("Ratings overview");

        for (int star = 5; star >= 1; star--) {
            int total = 0;

            // Add this star rating's count from every product row
            for (int row = 0; row < products.size(); row++) {
                total += counts[row][star - 1]; // star - 1 converts the rating number to its array column index.
            }

            // Print the rating label
            System.out.printf(star + " stars | ");

            // Print one * for every rating of this star value
            for (int i = 0; i < total; i++) {
                System.out.print("*");
            }

            // Print the number of ratings
            System.out.println(" (" + total + ")");
        }
    }

    public static void searchByProduct() {

        // Goal is to Map each lowercase product name to its feedback entries
        HashMap<String, ArrayList<String[]>> products = new HashMap<>();

        // Group the feedback entries by product
        for (String feedbackLine : feedbackEntries) {
            // Splits that string at each | and stores the pieces in parts array
            String[] parts = feedbackLine.split("\\|");

            String key = parts[1].toLowerCase();

            // Create a new list the first time this product appears
            if (!products.containsKey(key)) {
                // Checks whether the map has this product. If not, adds the product as a key with a new empty list as its value.
                products.put(key, new ArrayList<>());
            }
            //Add this feedback to the product’s list
            products.get(key).add(parts);
        }

        System.out.println("--- Search by Product ---");
        System.out.print("Product to search: ");
        String search = scanner.nextLine().toLowerCase();

        // Looks up the list for the searched product. matchingFeedback refers to that product’s feedback list; it doesn’t create a new list (it give the list a name for printing entries)
        ArrayList<String[]> matchingFeedback = products.get(search);

        if (matchingFeedback == null) {
            System.out.println("No feedback found for " + search + ".");
            return;
        }

        int totalRating = 0;
        System.out.println("Found " + matchingFeedback.size() + " entries for " +  search + ":");

        // Print matching entries and add their ratings
        for (String[] parts : matchingFeedback) {
            System.out.println(parts[0] + " " + parts[2] + " " + parts[3]);
            totalRating += Integer.parseInt(parts[2]);
        }

        double average = (double) totalRating / matchingFeedback.size();
        System.out.printf("Average rating: %.2f%n", average);
    }

    public static void saveFeedback(boolean showCount) {
        // Open the file for writing; this replaces its old contents and close it automatically afterward
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt"))) {

             // Write each feedback entry on its own line
            for (String feedback : feedbackEntries) {
                writer.write(feedback);
                writer.newLine();
            }

            if (showCount) {
                System.out.println("Saved " + feedbackEntries.size() + " feedback entries to feedback.txt");
            }
        } catch (IOException e) {
            System.out.println("Error saving feedback: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        printLogoBanner();
        loadSavedFeedback();

        int choice = 0;

        do {
            showMenu();

            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            try {
                choice = Integer.parseInt(input);

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
                        saveFeedback(true);
                        break;
                    case 6:
                        System.out.println("Saving feedback... done ");
                        saveFeedback(false);
                        System.out.println("Thank you for using the Customer Feedback Portal. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                }
            } catch (NumberFormatException e) {
                choice = 0;
                System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }

        } while (choice != 6);
        scanner.close();        
    }
    
}
