import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CustomerFeedbackPortal {

    // Store feedback using ArrayLists
    static ArrayList<String> names = new ArrayList<String>();
    static ArrayList<String> products = new ArrayList<String>();
    static ArrayList<Integer> ratings = new ArrayList<Integer>();
    static ArrayList<String> comments = new ArrayList<String>();

    static Scanner userInput = new Scanner(System.in);

    // Main method
    public static void main(String[] args) {

        printLogo();
        loadFeedback();
        while (true) {
                    showMenu();
                    int choice = readChoice();
                    switch (choice) {
                        case 1:
                            addFeedback();
                            break;

                        case 2:
                            showAll();
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
                            
                            System.out.print("Saving feedback... done.");
                                saveFeedback();
                               
                            System.out.println("Thank you for using the Customer Feedback Portal. Goodbye!");
                            userInput.close();
                            return; 
                        default:
                            System.out.println("Invalid choice please try again");
            }
        }
    }

    // Display the logo using nested loops
    static void printLogo() {
        String comp = "ACME SOLUTIONS";
        for (int i = 1; i <= 6; i++) {//6-->rows
            // Left stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Spaces
            if (i == 4) {
                System.out.print("    " + comp + "    ");
            } else {
                for (int j = 1; j <= 2 * (6 - i) + 18; j++) {//calculate the remaining space 
                    System.out.print(" ");
                }
            }
            // Right stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    // Display the menu
    static void showMenu() {
        String border = "+====================================+";
        System.out.println(border);
        System.out.println("|      CUSTOMER FEEDBACK PORTAL      |");
        System.out.println(border);
        System.out.println("|   1. Submit Feedback               |");
        System.out.println("|   2. View All Feedback             |");
        System.out.println("|   3. Rating Report                 |");
        System.out.println("|   4. Search by Product             |");
        System.out.println("|   5. Save to File                  |");
        System.out.println("|   6. Exit                          |");
        System.out.println(border);
    }



    // Read and validate the menu choice
    static int readChoice() {
        while (true) {
            System.out.print("Enter your choice: ");
            try {
                int choice = Integer.parseInt(userInput.nextLine().trim());///
                if (choice >= 1 && choice <= 6) {
                    return choice;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Invalid choice. Please enter a number from 1 to 6.");
        }
    }


    // Add new feedback
    static void addFeedback() {
        System.out.println("--- Submit Feedback ---");
        //name
        System.out.print("Customer name: ");
        String name = userInput.nextLine();
        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Customer name: ");
            name = userInput.nextLine();
        }
        //Product
        System.out.print("Product: ");
        String product = userInput.nextLine();
        while (product.trim().isEmpty()) {
            System.out.print("Product cannot be empty. Product: ");
            product = userInput.nextLine();
        }
        // Rating
        int rating = 0;
        while (rating < 1 || rating > 5) {
            System.out.print("Rating 1-5: ");
            try {
                rating = Integer.parseInt(userInput.nextLine());
                if (rating < 1 || rating > 5) {
                    System.out.println("Rating must be a number from 1 to 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println( "Rating must be a number from 1 to 5.");
                rating = 0;
            }
        }
        //Comment
        System.out.print("Comment: ");
        String comment = userInput.nextLine();

        while (comment.trim().isEmpty()) {//trim() -->remove extra spacing from the beginning and end of the string 
            System.out.print("Comment cannot be empty. Comment: ");
            comment = userInput.nextLine();
        }

        // Store the feedback in arrayList 
        names.add(name);
        products.add(product);
        ratings.add(rating);
        comments.add(comment);
        System.out.println("Thank you, " + name + "! Your feedback has been recorded.");
    }




    // Display all feedback
    static void showAll() {
        if (names.isEmpty()) {//check if the feedback is empty 
            System.out.println("No feedback has been submitted yet.");
            return;
        }
        System.out.println("No." + "    " + "Customer" + "    " + "Product" + "    " + "Rating" + "    " + "Comment");
        System.out.println("---  ---------  -----------  ------  ---------");
        for (int i = 0; i < names.size(); i++) {//i-->index num
            System.out.println(
                (i + 1) + "      "//feedback -->index+1 -->(0+1 = 1) 
                //get  from the  arrayList
                + names.get(i) + "      "
                + products.get(i) + "      "   
                + ratings.get(i) + "      "
                + comments.get(i));
        }
    }


// Display the rating report using a 2D array      
static void ratingReport() {
    if (products.isEmpty()) {//check if the arraylist empty 
        System.out.println("No feedback has been submitted yet.");
        return;
    }
    // all prodect name with no repeting 
    ArrayList<String> productListName = new ArrayList<String>();
    for (int i = 0; i < products.size(); i++) {//start from 0 index prodect
        //check weather the prodect exist
        boolean found = false;
        for (int j = 0; j < productListName.size(); j++) {
            if (products.get(i).equals(productListName.get(j))) {
                found = true;
                break;
            }
        }
        if (!found) {
            productListName.add(products.get(i));
        }
    }
    // Create a 2D array to count ratings
    int[][] countRate = new int[productListName.size()][5];
    // Count the ratings for each product
    for (int i = 0; i < products.size(); i++) {
        for (int j = 0; j < productListName.size(); j++) {
            if (products.get(i).equals(productListName.get(j))) {
                int star = ratings.get(i);
                countRate[j][star - 1]++;
                break;
            }
        }
    }
    // Display the rating report
    System.out.println("Rating Report");
    System.out.println("Product" + "   " + "1*"+ "   "  +"2*"+ "   "  + "3*"+ "   "  +"4*"+ "   "  +"5*"+ "   " +"Total"+ "   " +"Average");
    int[] StarsNum = new int[5];//fixed array of 5 
    for (int i = 0; i < productListName.size(); i++) {
        int total = 0;//count all the stars(rate) the prodect get
        int totalRating = 0; 
        System.out.print(productListName.get(i) );
        for (int j = 0; j < 5; j++) {
            System.out.print(countRate[i][j] );
            total = total + countRate[i][j];
            totalRating = totalRating + (countRate[i][j] * (j + 1));
            StarsNum[j] = StarsNum[j] + countRate[i][j];
        }
        double avg = (double) totalRating / total;
        System.out.println(total + "      " + avg);
    }
    // Display rating overview
    System.out.println("Ratings Overview");
    for (int i = 4; i >= 0; i--) {
        System.out.print((i + 1) + " stars | ");
        for (int j = 0; j < StarsNum[i]; j++) {
            System.out.print("*");
        }
        System.out.println(" (" + StarsNum[i] + ")");
    }
}




// Search feedback by product using HashMap
static void searchByProduct() {
    if (products.isEmpty()) {
        System.out.println("No feedback has been submitted yet.");
        return;
    }
    System.out.println("--- Search by Product ---");
    System.out.print("Product to search: ");
    String searchPro = userInput.nextLine().trim();
    if (searchPro.isEmpty()) {
        System.out.println("Product name cannot be empty.");
        return;
    }
    // Group feedback by product
    HashMap<String, ArrayList<Integer>> productRate = new HashMap<>();
    for (int i = 0; i < products.size(); i++) {
        String product = products.get(i).toLowerCase();
        try {
            productRate.get(product).add(i);
        } catch (NullPointerException e) {
            productRate.put(product, new ArrayList<Integer>());
            productRate.get(product).add(i);
        }
    }
    // Search for the product
    String searchKey = searchPro.toLowerCase();
    try {
        ArrayList<Integer> indx = productRate.get(searchKey);
        int totalRating = 0;
        System.out.println("Found " + indx.size() + " entries for " + searchPro );
        for (int i = 0; i < indx.size(); i++) {
            int index = indx.get(i);
            System.out.println(names.get(index) + "   "+ ratings.get(index) + "   "+ comments.get(index));
            totalRating = totalRating + ratings.get(index);
        }
        double average = (double) totalRating / indx.size();
        System.out.println("Average rating: " + average);
    } catch (NullPointerException e) {

        System.out.println("No feedback found for " + searchPro );
    }
}




   
    // Save feedback to the file
    static void saveFeedback() {

        try (BufferedWriter writing = new BufferedWriter(new FileWriter("feedbackData.txt"))) {//we use BufferedWriter and FileWriter -->to write into the file
            for (int i = 0; i < names.size(); i++) {//loop through the feedback list names.size() -->get the size of the arrayList
                writing.write(names.get(i) + "|" + products.get(i) + "|"  + ratings.get(i) + "|" + comments.get(i));writing.newLine();//write the feedback to the file in the format: name|product|rating|comment
            }
            System.out.println("Feedback saved successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

   
// Load feedback from the file
static void loadFeedback() {
    String fileName = "feedbackData.txt";
    int loaded = 0;
    try (BufferedReader reading = new BufferedReader(new FileReader(fileName))) {//we use BufferedReader and FileReader -->to read from the file
        String line;//read the file line by line
        while ((line = reading.readLine()) != null) {//null -->end of file 
            String[] parts = line.split("\\|", 4);//split the line into parts using | as the delimiter
            if (parts.length == 4) {//check if the line has 4 parts (name, product, rating, comment)
                try {
                    int rating = Integer.parseInt(parts[2]);
                    if (rating >= 1 && rating <= 5//check if the rating is between 1 and 5
                            && !parts[0].trim().isEmpty()
                            && !parts[1].trim().isEmpty()
                            && !parts[3].trim().isEmpty()) {

                        names.add(parts[0]);
                        products.add(parts[1]);
                        ratings.add(rating);
                        comments.add(parts[3]);
                        loaded++;//increment the loaded counter
                    } 

                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid feedback record.");//if the rating is not a number, skip the record
                }

            } 
        }
        System.out.println("Loaded " + loaded + " feedback entries from " + fileName);
    } catch (IOException e) {//
        System.out.println("No saved feedback found. Starting fresh.");
    }
}}

