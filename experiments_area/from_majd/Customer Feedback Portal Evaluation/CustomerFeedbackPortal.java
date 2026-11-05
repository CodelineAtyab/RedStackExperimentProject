import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CustomerFeedbackPortal {

    static Scanner scInput = new Scanner(System.in);
    static ArrayList<String> alName = new ArrayList<>();
    static ArrayList<Integer> alRating = new ArrayList<>();
    static ArrayList<String> alComment = new ArrayList<>();
    static ArrayList<String> alProduct = new ArrayList<>();
    static int counter = 0;
    static BufferedReader bwFileReader;
    static BufferedWriter bwFileWriter;

    static void printLogoBanner(String Text) {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i + 1; j++) {

                System.out.print(i+" ");

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

                        System.out.print(" "+j);
                    }

                }

            }

            System.out.println();

        }

    }

    static void loadSavedFeedback() {

        try {
            bwFileReader = new BufferedReader(new FileReader("feedbacks.txt"));
            String line;

            while ((line = bwFileReader.readLine()) != null) {
                String[] parts = line.split("\\|");

                alName.add(parts[0].trim());
                alProduct.add(parts[1].trim());
                alRating.add(Integer.parseInt(parts[2].trim()));
                alComment.add(parts[3].trim());
                counter++;
            }

            System.out.println("Loaded " + counter + " feedbacks from feedback.txt");

        } catch (IOException e) {
            System.out.println("No saved feedback found. Starting fresh.");
        }

    }

    static void submitFeedback() {

        String name;
        String comments;
        String product;
        int ratings;

        System.out.println("--- Submit Feedback ---");
        scInput.nextLine();
        while (true) {
            System.out.print("Customer name: ");
            name = scInput.nextLine();

            if (name.isEmpty())
                System.out.println("Name cannot be empty");
            else {
                alName.add(name);
                break;
            }
        }

        System.out.print("Product:");
        product = scInput.nextLine();
        alProduct.add(product);

        while (true) {

            try {
                System.out.print("Rating(1-5): ");
                ratings = scInput.nextInt();

                if (ratings < 1 || ratings > 5)
                    System.out.print("Rating must be a number from 1 to 5. Rating (1-5): ");

                else {
                    alRating.add(ratings);
                    break;
                }

            } catch (Exception e) {

                System.out.print("Rating must be a number from 1 to 5. Rating (1-5): ");

            }

        }

        scInput.nextLine();

        System.out.print("Comment:");
        comments = scInput.nextLine();

        alComment.add(comments);
        System.out.println("Thank you, " + name + "! Your feedback has been recorded. ");
        counter++;

    }

    static void ViewAllFeedback() {

        if (alName.isEmpty() && alProduct.isEmpty() && alRating.isEmpty() && alComment.isEmpty())
            System.out.println("No feedback has been submitted yet");
        else {

            System.out.println("No.      Customer      Product     Rating      Comment");
            System.out.println("---     ----------    -----------  -------   ----------------------- ");

            for (int i = 0; i < counter; i++) {
                System.out.println(
                        String.format("%2d %10s %20s %6d  %20s", (i + 1), alName.get(i), alProduct.get(i),
                                alRating.get(i), alComment.get(i)));
            }

        }

    }

    static void saveToFile() {

        try {
            bwFileWriter = new BufferedWriter(new FileWriter("feedbacks.txt"));

            for (int i = 0; i < counter; i++) {

                bwFileWriter.write(
                        alName.get(i) + "|" + alProduct.get(i) + "|" + alRating.get(i) + "|" + alComment.get(i) + "\n");

            }

            bwFileWriter.close();
            System.out.println("Saved " + counter + " feedback entries to feedback.exe");

        } catch (IOException e) {
            System.out.println("Error " + e);
        }

    }

    static void saveToFileAndExit() {

        try {
            bwFileWriter = new BufferedWriter(new FileWriter("feedbacks.txt"));

            for (int i = 0; i < counter; i++) {

                bwFileWriter.write(
                        alName.get(i) + "|" + alProduct.get(i) + "|" + alRating.get(i) + "|" + alComment.get(i) + "\n");

            }

            bwFileWriter.close();
            System.out.println("Saved feedback..... done");
            System.out.println("Thank you for using the Customer Feedback Portal. Goodbye!");

        } catch (IOException e) {
            System.out.println("Error " + e);
        }

        return;

    }

static void RatingReport() {

    ArrayList<String> alUniqueProducts = new ArrayList<>();

    // Store unique products in an arraylist once to avoid duplicates
    for (int i = 0; i < alProduct.size(); i++) {
        if (!alUniqueProducts.contains(alProduct.get(i))) {
            alUniqueProducts.add(alProduct.get(i));
        }
    }

    int Array2d[][] = new int[alUniqueProducts.size()][5];

    // Correctly check every single review in alProduct and match it to its product row
    for (int k = 0; k < alProduct.size(); k++) {
        String prod = alProduct.get(k);
        int rating = alRating.get(k);
        
        int rowIndex = alUniqueProducts.indexOf(prod);
        
        if (rating >= 1 && rating <= 5) {
            Array2d[rowIndex][rating - 1]++; // Increment the count for that star column
        }
    }

    System.out.printf("%-15s %4s %4s %4s %4s %4s %6s %8s", "Products", "1*", "2*", "3*", "4*", "5*","Total","Average\n");
    System.out.println(String.format("%-15s %4s %4s %4s %4s %4s %7s %8s", "---------------", "---", "---", "---", "---", "---","-------", "-------"));

    for (int i = 0; i < alUniqueProducts.size(); i++) {
        int totalRatesPerProduct = 0;
        float AverageRatePerProduct = 0;

        for (int j = 0; j < 5; j++) {
            totalRatesPerProduct += Array2d[i][j]; 
            AverageRatePerProduct += (Array2d[i][j] * (j + 1)); // multiply totalRatesPerProduct by star value, to determine how many times
            //that start value was chosen
            
        }

        if (totalRatesPerProduct > 0) {
            AverageRatePerProduct = AverageRatePerProduct / totalRatesPerProduct;
        }

        System.out.printf("%-15s %4d %4d %4d %4d %4d %6d %8.2f\n", 
            alUniqueProducts.get(i), 
            Array2d[i][0], Array2d[i][1], Array2d[i][2], Array2d[i][3], Array2d[i][4], 
            totalRatesPerProduct, AverageRatePerProduct);
    }

    System.out.println("\nRatings overview");

    for (int RatingCounter = 5; RatingCounter >= 1; RatingCounter--) {
        System.out.print(RatingCounter + " stars  | ");
        int starCount = 0;
        
        for (int i = 0; i < alUniqueProducts.size(); i++) {
            starCount += Array2d[i][RatingCounter - 1];
        }

        for (int s = 0; s < starCount; s++) {
            System.out.print("*");
        }
        System.out.println(" (" + starCount + ")");
    }
}
    static void searchByProduct() {

        scInput.nextLine();
        int productCounter = 0;
        String CounterNumberAsHashmapKey = "";
        System.out.println("--- Search by Product ---");
        String productName = "";
        float averageRating = 0;
        HashMap<String, String> hmProducts = new HashMap<>();
        HashMap<String, String> hmName = new HashMap<>();
        HashMap<String, String> hmRating = new HashMap<>();
        HashMap<String, String> hmComment = new HashMap<>();

        String mergeText;
        System.out.print("Product to search: ");
        productName = scInput.nextLine();
        System.out.println();

        //merge text ONLY if product name matches the searched product name. 
        for (int i = 0; i < alProduct.size(); i++) {

            if (alProduct.get(i).equals(productName)) {
                CounterNumberAsHashmapKey = String.valueOf(productCounter+1); //convert productCounter to string to use as hashmap key
                hmName.put("Name", alName.get(i));
                hmRating.put("Rating", String.valueOf(alRating.get(i)));
                hmComment.put("Comment", alComment.get(i));

                averageRating += alRating.get(i);
                
                mergeText = hmName.get("Name") + "    " + hmRating.get("Rating") + "    " + hmComment.get("Comment");
                hmProducts.put(CounterNumberAsHashmapKey, mergeText);

                productCounter++;

            } else
                continue;

        }

        if (productCounter == 0) {
            System.out.println("No feedback found for " + "\""+productName+"\"");
        } else {
            System.out.println("Found " + productCounter + " entries for " + "\""+productName+"\"");

            for (int i = 0; i < productCounter; i++) {
                System.out.println(hmProducts.get(String.valueOf(i+1)));
            }
                    System.out.println("Average rating: " + averageRating / productCounter);


        }

    }

    static void MainMenu() {

        int userChoice = 0;

        do{ 
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

        System.out.print("Enter your choice: ");

        try {
            userChoice = scInput.nextInt();

            switch (userChoice) {
                case 1:
                    submitFeedback();
                    break;

                case 2:
                    ViewAllFeedback();
                    break;

                case 3:
                    RatingReport();
                    break;

                case 4:
                    searchByProduct();
                    break;

                case 5:
                    saveToFile();
                    break;

                case 6:{
                    saveToFileAndExit();
                    return;
                }
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6");
            }
        } catch (Exception e) {
            System.out.println(" Invalid choice. Please enter a number from 1 to 6");

            scInput.nextLine();
        }
}while(true);
       
    }

    public static void main(String[] args) {

        printLogoBanner(" ACME SOLUTIONS");

        loadSavedFeedback();
            MainMenu();

      

    }

}