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
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"));
        String line = reader.readLine();
        while (line != null) {
            count++;
            line = reader.readLine();
        }
        reader.close();

        if (count > 0) {
            System.out.println("Loaded " + count + " feedback entries from feedback.txt");
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

        //save in data collection
        HashMap<String, String> entry = new HashMap<>();
        entry.put("No", String.valueOf(feedbackList.size() + 1));
        entry.put("Customer", name);
        entry.put("Product", product);
        entry.put("Rating", String.valueOf(rating));
        entry.put("Comment", comment);
        feedbackList.add(entry);

        // store in feedback.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt", true))) {
            writer.write(entry.get("No") + "," +
                    entry.get("Customer") + "," +
                    entry.get("Product") + "," +
                    entry.get("Rating") + "," +
                    entry.get("Comment"));
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to feedback.txt");
        }

        System.out.println("Thank you, " + name + "! Your feedback has been recorded.");

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

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":
                    stop = true;
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");

            }

        } while (!stop);

    }
}
