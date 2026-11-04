import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class CustomerFeedbackPortal {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> feedbackList = new ArrayList<>();
    static String cutomerNames[] =new String[100];
    static String products[] =new String[100];
    static int ratings[] =new int[100];
    static String comments[] =new String[100];
    static int count=0;

    
    
    public static void main(String[] args) {
        ShowLogoBanner();
        LoadFeedback();

        boolean running = true;
        while (running) {
            ShowMenu();
            try {
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                case 1:
                    SubmitFeedback();
                    break;
                case 2:
                    ViewAllFeedback();
                    break;
                case 3:
                     RatingReport();
                    break;
                case 4:
                    SearchByProduct();
                    break;
                case 5:
                    SaveToFile ();
                    break;
                case 6:
                    SaveToFile ();
                    System.out.println("Saving feedback... done.");
                    System.out.println("Thank you for using the Customer Feedback Portal. Goodbye!");
                    running =false;
                    break;
                
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6");
                    break;
            }
            } catch (Exception e) {
                System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
            
        }scanner.close();
  
        
        
    }//close main
    
    //1  Logo Banner
    public static void ShowLogoBanner(){
        
        for(int i=1; i<=6; i++){
            //Left sstars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            //Middle, company name
            if(i==4){
                System.out.print("         ACME SOLUTIONS         ");
            }else{
               for(int j=1; j<=40 -(2*i); j++){
                System.out.print(" ");
               }
            }
            //Right tars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            } 
            System.out.println();
        }
    }
    //2 Load Feedback
    static void LoadFeedback(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                cutomerNames[count] = parts[0];
                products[count] =parts[1];
                ratings[count]=Integer.parseInt(parts[2]);
                comments[count]=parts[3];
                count++;

            }System.out.println("Loaded "+ count + " feedback entries from feedback.txt");
        } catch (Exception e) {
            System.out.println("No saved feedback found. Starting fresh.");
        } 
    }

    
    //3 ShowMenu
    static void ShowMenu(){

        // System.out.println("+====================================+");
        // System.out.println("|      CUSTOMER FEEDBACK PORTAL      |");
        // System.out.println("+====================================+");
        // System.out.println("|   1. Submit Feedback               |");
        // System.out.println("|   2. View All Feedback             |");
        // System.out.println("|   3. Rating Report                 |");
        // System.out.println("|   4. Search by Product             |");
        // System.out.println("|   5. Save to File                  |");
        // System.out.println("|   6. Exit                          |");
        // System.out.println("+====================================+");

        String[] menu = {
            "1. Submit Feedback",
            "2. View All Feedback",
            "3. Rating Report",
            "4. Search by Product",
            "5. Save to File",
            "6. Exit"
        };
        printBorder();
        System.out.println("|      CUSTOMER FEEDBACK PORTAL      |");
        printBorder();
        for(int i=0; i<menu.length;i++){
            System.out.printf("| %-34s |%n", menu[i]);
        }
        printBorder();
    }

    static void printBorder() {
        System.out.print("+");
        // 36 -> how many =
        for (int i = 1; i <= 36; i++) {
            System.out.print("=");
        }
        System.out.println("+");
    }

    
    //4 Submit Feedback
    static void SubmitFeedback(){

        if (count == cutomerNames.length) {
            System.out.println("Feedback list is Full");
            return;
        }
        //Customer name
        String cName;
        while (true) {
            try {
                System.out.print("Customer name:");
                cName =scanner.nextLine().trim();

                if (cName.isEmpty()) {
                    System.out.println("Name can't be empty.");
                }else if (cName.matches("[0-9]+")) { //any digit from 0 to 9
                    System.out.println("Name cannot be numbers.");
                } else{
                    cutomerNames[count]=cName;
                    break;
                }
        
            }catch (Exception e) {
                System.out.println("Invalid Input"+e);
            }   
        }  

        // product
        while (true) {
            try {
                System.out.print("Product:");
                String product =scanner.nextLine().trim();

                if (product.isEmpty()) {
                    System.out.println("Product can't be empty.");
                }else if (product.matches("[0-9]+")) { //any digit from 0 to 9
                    System.out.println("Product name cannot be only numbers.");
                } else{
                    products[count]=product;
                    break;
                }
        
            }catch (Exception e) {
                System.out.println("Invalid Input"+e);
            }   
        } 
        // Rating (1 to 5) 
        while (true) {
            try {
                System.out.print("Rating (1-5):");
                int rating = scanner.nextInt();
                scanner.nextLine();

                if ( rating <1 || rating > 5) { //any digit from 0 to 9
                    System.out.println("Rating must be a number from 1 to 5.");
                } else{
                    ratings[count]=rating;
                    break;
                }
        
            }catch (Exception e) {
                System.out.println("Invalid Input! Please enter numbers(0 to 5) only.");
                scanner.nextLine();
            }   
        } 
        // Comment
        while (true) {
            System.out.print("Comment: ");
            String comment = scanner.nextLine().trim();

            if (comment.isEmpty()) {
                System.out.println("Comment can't be empty.");
            }else if (comment.matches("[0-9]+")) { //any digit from 0 to 9
                System.out.println("comment cannot be only numbers.");
            } else {
                comments[count] = comment;
                break;
            }
        }

        count++;

        System.out.println("Thank you, "+cName +"! Your feedback has been recorded.");

    }
    
    //5 ViewAllFeedback
    
    static void ViewAllFeedback() {

        if (count == 0) { //empty
            System.out.println("No feedback has been submitted yet.");
            return;
        }
        System.out.println("No.  Customer   Product      Rating  Comment");

        System.out.println("---  ---------  ----------  -------  -----------------------");

        for (int i = 0; i < count; i++) {
            System.out.printf("%-3d  %-9s  %-11s  %-6d  %s%n",
                (i + 1),
                cutomerNames[i],
                products[i],
                ratings[i],
                comments[i]);
            }
    }

    
    //6 Rating Report
    static void RatingReport(){

        //creat array list
        ArrayList<String> newPraducts = new ArrayList<>();
       
        //compare if new array list contains product from array products
        for(int i=0; i<count; i++){
            //if contain skip the iteration
            if(newPraducts.contains(products[i])){
                continue;
            }else{
                //if not contain add the product to new product array list
                newPraducts.add(products[i]);
            }
        }

        //creat 2D array [row][col]
        int[][] productStar = new int[newPraducts.size()][5];

        //counts how many customers gave each product each rating
        for(int i=0; i<count; i++){
            int row = newPraducts.indexOf(products[i]); //which product?
            int col = ratings[i]-1; //which rating?

            productStar[row][col]++;
        }

        // Print rating report
        System.out.printf("%-15s %3s %3s %3s %3s %3s %7s %9s%n",
                "Product", "1*", "2*", "3*", "4*", "5*", "Total", "Average");

        double numCustomerRating; //total number of customers who rated the product
        double sumStarValue; //sum of all star values given to the product
        double average;

        for(int i=0; i<newPraducts.size(); i++){

            numCustomerRating = 0.0;  
            sumStarValue = 0.0;  
            average = 0.0; 
            //Print the product name
            System.out.printf("%-15s", newPraducts.get(i));

            //Loop through the five ratings
            for(int j=0; j<5; j++){

                //add the number of customers who gave each rating
                numCustomerRating = numCustomerRating + productStar[i][j];
                //calculates the total score
                sumStarValue = sumStarValue + productStar[i][j]*(j+1);
                //Print the number of ratings
                System.out.printf("%4d", productStar[i][j]);
            }

            average = sumStarValue / numCustomerRating;
            System.out.printf("%8.0f %9.2f%n", numCustomerRating, average);
        }

        //Ratings overview
        System.out.println("\nRatings overview");
            //start from column 4 (5 stars)
        for(int col=4; col>=0; col--){
            int starRatingCount = 0;
            for(int row=0; row<productStar.length; row++){
                starRatingCount += productStar[row][col];
            }
            if(col == 0){
                System.out.print("1 star  | ");
            }else{
                System.out.print((col+1) + " stars | ");
            }
            for(int star=0; star<starRatingCount; star++){
                System.out.print("*");
            }
            System.out.println(" (" + starRatingCount + ")");
        }
    }


    //7 SearchByProduct
    static void SearchByProduct(){
        System.out.println("--- Search by Product ---");
        System.out.print("Product to search: ");
        String searchProduct = scanner.nextLine().trim();

        HashMap<String, Integer> customerInfo = new HashMap<>();

        for (int i = 0; i < count; i++) {
            String product = products[i].toLowerCase();
            if (customerInfo.containsKey(product)) {
                customerInfo.put(product, customerInfo.get(product) + 1);
            } else {
                customerInfo.put(product, 1);
            }
        }

        String key = searchProduct.toLowerCase();
        if (!customerInfo.containsKey(key)) {
            System.out.println("No feedback found for \"" + searchProduct + "\".");
            return;
        }

        int searchCount = customerInfo.get(key);
        int sumRating = 0;

        System.out.println("Found " + searchCount + " entries for \""+ searchProduct + "\":");
        for (int i = 0; i < count; i++) {
            if (key.equals(products[i].toLowerCase())) {
                System.out.print("\t"+cutomerNames[i]+ "\t");
                System.out.print(ratings[i]+ "\t");
                System.out.println(comments[i]);
                sumRating += ratings[i];
            }
        }
        double avgRating = (double) sumRating / searchCount;
        System.out.println("Average rating: " + String.format("%.2f", avgRating));
    }



    //8 SaveToFile
    static void SaveToFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt"))) {
            for (int i = 0; i < count; i++) {
                writer.write(cutomerNames[i] + "|" + products[i]+"|"+ ratings[i] + "|" + comments[i]);
                writer.newLine();
                
            }System.out.println("Saved "+ count +" feedback entries to feedback.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



    
}