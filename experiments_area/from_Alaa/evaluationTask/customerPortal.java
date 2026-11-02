import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class customerPortal {
    static Scanner sc = new Scanner(System.in); // creating static scanner object to read user input
    //ArratLists to store the feedback data
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Integer> ratings = new ArrayList<>(); 
    static ArrayList<String> comments = new ArrayList<>(); 
    static ArrayList<String> products = new ArrayList<>();

    public static void menu(){
        int choice = 0;
        boolean exit = false; // flag to control the menu loop
        boolean validInput = true; // flag to check if the input is valid
        while (exit == false) {
            System.out.println("+====================================+");
            System.out.println("|       CUSTOMER FEEDBACK PORTAL     |");
            System.out.println("+====================================+");
            System.out.println("|       1. Submit Feedback           |");
            System.out.println("|       2. View All Feedback         |");
            System.out.println("|       3. Rating Report             |");
            System.out.println("|       4. Search by Product         |");
            System.out.println("|       5. Save to File              |");
            System.out.println("|       6. Exit                      |");
            System.out.println("+====================================+");
            try{
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                validInput = true; // set the flag to true to indicate valid input
                sc.nextLine(); // Consume the newline character left by nextInt()
            } catch(Exception e ) { //error handling when trying to read an integer from the user input
                System.out.println("Invalid input. Please enter an integer between 1 and 6.");
                validInput = false; // set the flag to false to indicate invalid input
                sc.nextLine(); // clear the buffer
            }
            if (!validInput) {
                continue; // Skip the rest of the loop and start over
            }
            switch (choice) {
                    case 1:
                        submitFeedback();
                        break;
                    case 2:
                        viewAllFeedback();
                        break;
                    case 3:
                        ratingReport();
                        break;
                    case 4:
                        searchByProduct();
                        break;
                    case 5:
                        saveToFile();   
                         break;
                    case 6:
                        exit = true;
                        System.out.println("Thank you for using the Customer Feedback Portal. Goodbye!");
                        break;   
                    default: // Handle invalid input, when non of the cases match the user input
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                        break;
                }
        }
    }

    public static void submitFeedback() {
        String name;
        int rating ;
        String comment;
        String product;

        while (true) { // Loop until a valid name is entered
            System.out.println("Enter your name: ");
                name = sc.nextLine();
                if (name.trim().isEmpty() || !name.matches("^[a-zA-Z ]+$")  ) { // A name containing only spaces is considered empty, and the regex checks for alphabetic characters only.
                    System.out.println("Name cannot be empty and it must contain only alphabetic characters. Please try again.");
                } 
                else {
                    break; // The name is valid, so leave the loop
                }
        }

        while (true ) {
            System.out.println("Enter the product name: ");
            product = sc.nextLine();
            if (product.trim().isEmpty()) {
                System.out.println("Product name cannot be empty. Please try again.");
            } else {
                break; // The product name is valid, so leave the loop
            }
        }
        
        while (true) {
            System.out.println("Enter your rating (1-5): ");
            try {
                rating = sc.nextInt();
                sc.nextLine(); // Consume the newline character left by nextInt()
                if (rating >= 1 && rating <= 5) { // Check that the rating is between 1 and 5
                    break; // The rating is valid
                } else {
                    System.out.println("Rating must be between 1 and 5. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a whole number from 1 to 5.");
                sc.nextLine(); // Consume the invalid input
            }
        }

        while (true) {
            System.out.println("Enter your comment: ");
            comment = sc.nextLine();
            if (comment.trim().isEmpty()) { // A comment containing only spaces is also considered empty.
                System.out.println("Comment cannot be empty. Please try again.");
            } else {
                break; // The comment is valid
            }
        }

        names.add(name);
        ratings.add(rating);
        comments.add(comment);
        products.add(product);

        System.out.println("Thank you " + name + "  Your feedback has been recorded.");

    }

    public static void viewAllFeedback() {
        System.out.println("----View All Feedback----");
        System.out.println("Note: Feedback is displayed in the order it was received.");
        String formatPattern = "%-4s %-12s %-13s %-8s %s%n"; /* - means left-justified, the number is the width of the column, 
                                                             and %n is a platform-independent newline character. 
                                                            And s indicates that theres no fixed width for the last column, 
                                                            allowing it to expand as needed.*/
        System.out.printf(formatPattern, "No.", "Customer", "Product", "Rating", "Comment");
        System.out.printf( formatPattern, "---", "--------", "-------", "------", "-------");
        for (int i = 0; i < names.size(); i++) { // taking the size of the names array list to loop through all the feedbacks
            System.out.printf( formatPattern, i + 1, names.get(i),  products.get(i), ratings.get(i),  comments.get(i));
        }
        System.out.println("End of feedback list.");
    }

    public static void ratingReport() {
        // in order to create a 2D array, we need to create a list of lists

        //first create an array list to save all unique product names
        ArrayList<String> uniqueProducts = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i).toLowerCase().trim(); // convert the product name to lowercase for case-insensitive comparison and trim any leading or trailing whitespace
            if (!uniqueProducts.contains(product)) {
                uniqueProducts.add(product); // add once when the product is not already in the uniqueProducts list
            }
        }

        //second count the ratings for each product and store them in a 2D array
        int[][] ratingCounts = new int[uniqueProducts.size()][5]; // 5 columns

        // loop through the products and ratings to count the ratings for each product
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i).toLowerCase().trim(); // get the product name at index i and convert to lowercase and trim
            int rating = ratings.get(i); // get the rating at index i
            int productIndex = uniqueProducts.indexOf(product); // get the index of the product in the uniqueProducts list
            if (productIndex != -1) { // check if the product is found in the uniqueProducts list
                ratingCounts[productIndex][rating - 1]++; // increment the count for the corresponding rating (rating - 1 because array index starts at 0)
            }
        }  

        String formatPattern = "%-12s %3s %3s %3s %3s %3s %6s %8s%n"; //specify the width of each column to ensure proper alignment of the output
        System.out.printf(formatPattern, "Product", "1", "2", "3", "4", "5", "Total", "Average");
        System.out.printf(formatPattern, "-------", "---", "---", "---", "---", "---", "-----", "-------");

        for (int i = 0; i < uniqueProducts.size(); i++) { // loop through the unique products to display the rating counts, total, and average for each product
            String product = uniqueProducts.get(i); // get the product name at index i
            int total = 0;
            double average = 0.0;
            for (int j = 0; j < 5; j++) { // loop through the ratings (1 to 5) to calculate the total and average for each product
                total += ratingCounts[i][j]; //add the count of each rating to the total
                if (total > 0) {
                average = (double) total / 5.0; //5.0 is the number of rating categories (1 to 5). This gives the average rating for the product.
                // int--> double conversion is done to ensure that the division results in a double value.
                }
            }
            System.out.printf(formatPattern, product,  ratingCounts[i][0], ratingCounts[i][1], ratingCounts[i][2], ratingCounts[i][3], ratingCounts[i][4], total, String.format("%.2f", average));
        }

        // diplaying the rating with stars depending on count of ratings each product has
            System.out.println("Rating Overview");
            int count = 0; // to count the number of stars for each rating
            for (int i = 4; i >= 0; i--) {
                System.out.print((i + 1) + " star|    ");
                count = 0; // reset the count for each rating
                for (int j = 0; j < uniqueProducts.size(); j++) { // loop through the unique products to display the stars for each rating
                    count += ratingCounts[j][i]; // add the count of the current rating for each product
                }
                for (int k = 0; k < count; k++) { // loop through the count to print stars
                    System.out.print("*"); // Print only to print next to each other without a new line
                }
                System.out.println("      (" + count + ")"); // move to the next line after printing all products for the current rating
            }
    }

    public static void searchByProduct() {
        //first declare a hashmap (key is the product name, value is an array of indexes of that product)
        HashMap<String, ArrayList<Integer>> productIndexMap = new HashMap<>();
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i).toLowerCase().trim(); // convert the product name to lowercase for case-insensitive search
            if (!productIndexMap.containsKey(product)) { //check if the product is already in the map, if not, create a new entry with an empty ArrayList
                productIndexMap.put(product, new ArrayList<>());
            }
            productIndexMap.get(product).add(i);  //get(product) returns the ArrayList of indexes for that product, and we add the current index i to that list
        }

        int count = 0; // to count the number of feedbacks for the searched product
        double averageRating = 0.0; // to calculate the average rating for the searched product
        System.out.println("Enter the product name to search for feedback: ");
        String searchProduct = sc.nextLine().toLowerCase().trim();
        
        searchProduct = searchProduct.toLowerCase().trim(); // convert the search product name to lowercase for case-insensitive search
        if (productIndexMap.containsKey(searchProduct)) { // check if the product is in the map 
            //first get list of indexes for the searched product
            // then loop through the indexes to display the feedback for that product
            ArrayList<Integer> indexes = productIndexMap.get(searchProduct);
            System.out.println("Found " + indexes.size() + " feedback(s) for product: " + searchProduct );

            for (int index : indexes) { //loop through the list of indexes for the searched product and display the feedback for each index
                System.out.println("Customer: " + names.get(index) + ", Rating: " + ratings.get(index) + ", Comment: " + comments.get(index));
                count++; // increment the count for each feedback found
                averageRating += ratings.get(index); // add the rating to the total for calculating average
            }

            averageRating /= indexes.size() ; // calculate the average rating by dividing the total rating by the count of feedbacks
            
           
            System.out.println("Total feedback for " + searchProduct + ": " + count);
            System.out.println("Average rating for " + searchProduct + ": " + averageRating);
            
        }
        else {
            System.out.println("No feedback found for product: " + searchProduct);
        }
    }
        
    public static void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt"));
            for (int i = 0; i < products.size(); i++) {
                writer.write(names.get(i) + "|" + products.get(i) + "|" + ratings.get(i) + "|" + comments.get(i));
                writer.newLine(); // Move to the next line for the next feedback
            }
            writer.close();
            System.out.println("Feedback saved to file successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving feedback to file.");
        }
    }

    public static void loadFromFile() {
    try {
        BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (parts.length == 4) {
                names.add(parts[0]);
                products.add(parts[1]);
                ratings.add(Integer.parseInt(parts[2]));
                comments.add(parts[3]);
            }
        }
        reader.close();
        System.out.println("Feedback loaded from file successfully!");
    } catch (IOException e) {
        System.out.println("Error loading file: " + e.getMessage());
    }
}
    public static void main(String[] args) {
        int rowNumber = 6 ;
        String companyName = "RedStack";
        for (int i = 0; i <= rowNumber; i++) {
            for (int j = 0; j <= i; j++) {
                    System.out.print("* "); 
            }
            System.out.println(); 
        }

        
        loadFromFile();
        menu(); // calling the menu method to display the menu
    }
}