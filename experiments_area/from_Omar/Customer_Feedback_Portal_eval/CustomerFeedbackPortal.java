import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.lang.Thread.State;

public class CustomerFeedbackPortal {
    public static Scanner sc = new Scanner(System.in);

    public static void Logo() {
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

    public static void StartupFeedbackLoad() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"));
        int feedbackCount = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            feedbackCount++;

            String[] parts = line.split("\\|");

            if (parts.length >= 4) {
                String name = parts[0].trim();
                String product = parts[1].trim();
                String rating = parts[2].trim();
                String feedback = parts[3].trim();

                System.out.println(
                        "Feedback " + feedbackCount + ": " + name + "|" + product + "|" + rating + "|" + feedback);
            } else {
                System.out.println("Feedback " + feedbackCount + ": " + line);
            }

            System.out.println("Loaded " + feedbackCount + " feedback entries from feedback.txt");

        }
        reader.close();
    }

    public static void menu() {
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

    public static void Submitfeedback(ArrayList<HashMap<String, String>> feedback) {
        System.out.println("--- Submit Feedback ---");
        String name = "";

        System.out.print("Customer name:");
        while (true) {
            name = sc.nextLine().trim();
            if (!name.isEmpty()) {
                break;
            }
            System.out.println("name cannot be empty. name: ");
        }

        System.out.print("product: ");
        String product = sc.nextLine().trim();

        System.out.print("Rating (1-5): ");
        int rating = 0;
        while (true) {
            String input = sc.nextLine().trim();
            try {
                rating = Integer.parseInt(input);
                if (rating >= 1 && rating <= 5) {
                    break;
                }
            } catch (NumberFormatException e) {
            }
            System.out.print("Rating must be a number from 1 to 5. Rating (1-5): ");
        }

        System.out.print("Comment: ");
        String comment = sc.nextLine().trim();

        HashMap<String, String> entry = new HashMap<>();
        entry.put("name", name);
        entry.put("product", product);
        entry.put("rating", String.valueOf(rating));
        entry.put("comment", comment);

        feedback.add(entry);

        System.out.println("Thank you, " + name + "! your feedback has recorded.");
    }

    public static void Viewallfeedback(ArrayList<HashMap<String, String>> feedback) {
        if (feedback.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
        } else {
            System.out.printf("%-4s  %-12s  %-12s  %-8s  %-30s%n", "No.", "Customer", "Product", "Rating", "Comment");
            System.out.println("----  ------------  ------------  --------  ------------------------------");

            int count = 1;
            for (HashMap<String, String> entry : feedback) {
                System.out.printf("%-4d  %-12s  %-12s  %-8s  %-30s%n", count, entry.get("name"), entry.get("product"),
                        entry.get("rating"), entry.get("comment"));
                count++;

            }
        }

    }

    public static void Ratingreport(ArrayList<HashMap<String, String>> feedback, int[][] rating_r) {
        if (feedback.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
        } else {
            for (int i = 0; i < rating_r.length; i++) {
                for (int j = 0; j < rating_r[i].length; j++) {
                    rating_r[i][j] = 0;
                }
            }

            ArrayList<String> products = new ArrayList<>();
            for (HashMap<String, String> entry : feedback) {
                String p = entry.get("product");
                if (!products.contains(p) && products.size() < rating_r.length) {
                    products.add(p);
                }
            }
            for (HashMap<String, String> entry : feedback) {
                int row = products.indexOf(entry.get("product"));
                if (row != -1 && row < rating_r.length) {
                    int r = Integer.parseInt(entry.get("rating"));
                    rating_r[row][r - 1]++;
                }
            }

            System.out.printf("%-12s  %3s  %3s  %3s  %3s  %3s  %6s  %8s%n", "Product", "1*", "2*", "3*", "4*", "5*",
                    "Total", "Average");
            System.out.println("----------  ----  ----  ----  ----  ----  ------  -------");

            int[] totstars = new int[5];
            for (int i = 0; i < products.size(); i++) {
                int total = 0;
                int sum = 0;
                for (int j = 0; j < 5; j++) {
                    total += rating_r[i][j];
                    sum += rating_r[i][j] *(j + 1);
                    totstars[j] += rating_r[i][j];
                }

                
                    double avg = 0.0;
                if (total > 0) {
                     avg = sum / total;
                }
                System.out.printf("%-12s  %3d  %3d  %3d  %3d  %3d  %6d  %8.2f%n", products.get(i), rating_r[i][0],
                        rating_r[i][1], rating_r[i][2], rating_r[i][3], rating_r[i][4], total, avg);
            }
            System.out.println("\nRatings overview");
            for (int i = 5; i >= 1; i--) {
                int count = totstars[i - 1];
                String peoplestars = "";
                for (int j = 0; j < count; j++) {
                    peoplestars += "* ";
                }
                peoplestars = peoplestars.trim();
                String label ="";
                if (i == 1) {
                     label = "1 star";
                } else {
                     label = i + "stars";
                }

                System.out.printf("%-8s | %-10s (%d)%n", label, peoplestars, count);
            }
        }
    }

    public static void Searchbyproduct(ArrayList<HashMap<String, String>> feedback){
        System.out.println("--- Search by Product ---");
        System.out.print("product to search: ");
        String searchP = sc.nextLine().trim();

        ArrayList<HashMap<String,String>> matches = new ArrayList<>();
        String matchedproductName= searchP;
        for(HashMap<String,String> entry : feedback){
            String prod = entry.get("product");
            if(prod.equalsIgnoreCase(searchP)){
                matches.add(entry);
                matchedproductName=prod;
            }
        }

        if(matches.isEmpty()){
            System.out.println("No feedback found for \""+searchP);

        }
        else{
            System.out.println("Found "+matches.size()+" entries for \""+matchedproductName);
            int totalRating=0;

            for(HashMap<String,String> entry:matches){
                int rating=Integer.parseInt(entry.get("rating"));
                totalRating+=rating;
                System.out.printf("%-10s %-3d %s%n",entry.get("name"),rating,entry.get("comment"));

            }
            double average=(double) totalRating / matches.size();
            System.out.printf("Average rating: %.2f%n",average);
        }
    }

    public static void Savetofile(ArrayList<HashMap<String, String>> feedback)throws IOException{
        BufferedWriter writer= new BufferedWriter(new FileWriter("feedback.txt"));
        for(HashMap<String,String> entry:feedback){
            writer.write(entry.get("name")+"|"+entry.get("product")+"|"+entry.get("rating")+"|"+entry.get("comment"));
            writer.newLine();
        }
        writer.close();
        System.out.println("Saved "+ feedback.size()+"feedback entries to feedback.txt");
    }

    public static void main(String[] args) {
        boolean exit = false;
        ArrayList<HashMap<String, String>> feedback = new ArrayList<>();
        int[][] rating_r=new int[3][5];
        try {
            Logo();
            StartupFeedbackLoad();

            while (!exit) {
                menu();
                System.out.print("Enter your choice:");
                int option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        Submitfeedback(feedback);
                        break;
                    case 2:
                        Viewallfeedback(feedback);
                        break;
                    case 3:
                        Ratingreport(feedback,rating_r);
                        break;
                    case 4:
                        Searchbyproduct(feedback);
                        break;
                    case 5:
                        Savetofile(feedback);
                        break;
                    case 6:
                        System.out.print("Saving feedback...");
                        Savetofile(feedback);
                        System.out.println(" done.");
                        System.out.println("Thank you for using the Customer Feedback Portal. Goodbye!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                        break;
                }

            }
        } catch (IOException e) {
            System.out.println("No saved feedback found. Starting fresh.");
        }

        sc.close();
    }
}
