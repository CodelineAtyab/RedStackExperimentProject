import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class FeedbackPortal {

    static int counter = 0;
    
    //the menu doesnt show immeditly 
   static  String any;

    static ArrayList<HashMap<String, String>> allfeedbacks = new ArrayList<>();
    static  HashMap<String, String> feedback = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

    static void banner() {

        String Brand = "ACME SOLUTIONS ";
        for (int i=0; i<6;i++) {
            for (int j=0;j< i + 1;j++) {

                System.out.print("* ");
                if (j == i) {
                    if (i == 3) {
                        System.out.print("       ");
                        System.out.print(Brand);
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

    static void showMenu() {
        System.out.println();
        System.out.println("+=====================================+");
        System.out.println("|       CUSTOMER FEEDBACK PORTAL      |");
        System.out.println("+=====================================+");
        System.out.println("|     1. Submit Feedback              |");
        System.out.println("|     2. View All Feedback            |");
        System.out.println("|     3. Rating Report                |");
        System.out.println("|     4. Search by Product            |");
        System.out.println("|     5. Save to file                 |");
        System.out.println("|     6. Exit                         |");
        System.out.println("+=====================================+");

    }

    static void submitFeedback() {

        String name;
        String product;
        int rating = 0;
        String comment;

        if (counter >= 100) {
            System.out.println("The list is full. Delete some feedback first.");
            return;
        }

        while (true) {
            System.out.print("Customer name : ");
            try {
                name = sc.nextLine().trim();

                if (!name.isEmpty()) {
                    break;
                } else {
                    System.out.println("Name cannot be empty.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }

        while (true) {
            System.out.print("Product : ");
            try {
                product = sc.nextLine().trim();

                if (!product.isEmpty()) {
                    break;
                } else {
                    System.out.println("Name cannot be empty.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }

        while (true) {
            System.out.print("Rating (1-5) : ");
            try {
                rating = Integer.parseInt(sc.nextLine().trim());
                if (rating >= 1 && rating <= 5) {
                    break;
                } else {
                    System.out.println("Rating must be between 1 and 5.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid input.");

            }
        }

        System.out.print("What are your thoughts about it? : ");
        comment = sc.nextLine().trim();
        if (comment.isEmpty()) {
            System.out.println("Comment cannot be empty.");
            return;
        }

       // feedback hashmap is static 
        feedback.put("No", String.valueOf(allfeedbacks.size() + 1));
        feedback.put("Customer", name);
        feedback.put("Product", product);
        feedback.put("Rating", String.valueOf(rating));
        feedback.put("Comment", comment);

        allfeedbacks.add(feedback);
        counter++;

        System.out.println("Feedback added. Thank you, " + name + "");


        System.out.println("Press any key to continue... ");
        any = sc.nextLine();
    }

    static void viewAll() {
        if (allfeedbacks.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }
        System.out.printf("%-4s %-10s %-12s %-7s %s%n", "No.", "Customer", "Product", "Rating", "Comment");
        System.out.printf("%-4s %-10s %-12s %-7s %s%n", "---", "---------", "-----------", "------",
                "-----------------------");

        for (HashMap<String, String> feedback : allfeedbacks) {
            System.out.printf("%-4s %-10s %-12s %-7s %s%n",
                    feedback.get("No"),
                    feedback.get("Customer"),
                    feedback.get("Product"),
                    feedback.get("Rating"),
                    feedback.get("Comment"));
        }
        System.out.println("Press any key to continue... ");
        any = sc.nextLine();
    }

    static void ratingReport() {
        

        if (allfeedbacks.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }

        ArrayList<String> products = new ArrayList<>();
        for (HashMap<String, String> feedback : allfeedbacks) {
            String prod = feedback.get("Product").trim();
            if (!products.contains(prod)) {
                products.add(prod);
            }
        }

        int[][] ratingCounts = new int[products.size()][5];
        int[] starTotals = new int[5];

        for (HashMap<String, String> feedback : allfeedbacks) {
            String prod = feedback.get("Product").trim();
            int prodIndex = products.indexOf(prod);
            try {
                int rating = Integer.parseInt(feedback.get("Rating").trim());
                if (rating >= 1 && rating <= 5) {
                    ratingCounts[prodIndex][rating - 1]++;
                    starTotals[rating - 1]++;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.printf("%-12s %-4s %-4s %-4s %-4s %-4s %-7s %s%n", "Product", "1", "2", "3", "4", "5", "Total",
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
        System.out.println("Press any key to continue... ");
        any = sc.nextLine();
    }

    static void searchByProduct() {

        System.out.println("--- Search Product ---");
        System.out.print("Enter product name to search: ");
        String search = sc.nextLine().trim();
        int sum = 0;
        int count =0;

        try {
        for (HashMap<String , String> feedback : allfeedbacks) {
            String item = feedback.get("Product");
            
            if (item.contains(search)) {
                sum += Integer.parseInt(feedback.get("Rating").trim());
                count++;

                System.out.println(feedback.get("No") + " | " +
                feedback.get("Customer") + " | " +
                feedback.get("Product") + " | " +
                feedback.get("Rating") + " | " +
                feedback.get("Comment") + " | "
            );
            } 
        }
        if (count > 0) {
            System.out.printf("Average rating: %.2f%n", (double) sum / count);
        } else {
            System.out.println("No feedback fot this item yet ");
        }

    } catch (Exception e) {
            System.err.println("Something went wrong..");
        }

        System.out.println("Press any key to continue... ");
        any = sc.nextLine();
    }

    static void saveFeedback() {

        File file = new File("Info.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            for (HashMap<String, String> feedback : allfeedbacks) {
                writer.write(feedback.get("No") + "," +
                        feedback.get("Customer") + "," +
                        feedback.get("Product") + "," +
                        feedback.get("Rating") + "," +
                        feedback.get("Comment"));
                writer.newLine();
            }

            System.out.println("Saved " + allfeedbacks.size() + " feedback to " + file);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Press any key to continue... ");
        any = sc.nextLine();
    }

    static void loadFeedback() {
        File file = new File("Info.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {

                String[] parts = line.split(",", 5);
                if (parts.length == 5) {

                    HashMap<String, String> feedback = new HashMap<>();
                    feedback.put("No", parts[0]);
                    feedback.put("Customer", parts[1]);
                    feedback.put("Product", parts[2]);
                    feedback.put("Rating", parts[3]);
                    feedback.put("Comment", parts[4]);

                    allfeedbacks.add(feedback);

                }
                line = reader.readLine();
            }

            reader.close();

            if (allfeedbacks.size() == 0) {

                System.err.println("No saved feedback found.");

            } else {
                System.out.println("Loaded " + allfeedbacks.size() + " feedback entries from " + file);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        banner();
        loadFeedback();

        int number = -1;

        do {
            showMenu();
            System.out.print("Choose an option: ");

            try {
                number = Integer.parseInt(sc.nextLine());

                switch (number) {
                    case 1:
                        submitFeedback();
                        ;
                        break;
                    case 2:
                        viewAll();
                        break;
                    case 3:
                        ratingReport();
                        break;
                    case 4:
                        searchByProduct();
                        break;
                    case 5:
                        saveFeedback();
                        break;
                    case 6:
                        System.out.println("Thank you come again");
                        break;
                    default:
                        System.out.println("Invalid option. Choose from the menu.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 6.");
                number = -1;
            }

        } while (number != 6);
        sc.close();
    }
}
