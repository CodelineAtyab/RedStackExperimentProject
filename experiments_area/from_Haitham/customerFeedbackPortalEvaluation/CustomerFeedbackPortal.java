import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CustomerFeedbackPortal {
    static  Scanner sc = new Scanner(System.in);
    static String[] names = new String[100];
    static String[] products = new String[100];
    static int[] ratings = new int[100];
    static String[] comments = new String[100];
    static int count = 0;

    public static int numinput(){
        int num = 999;
        try{num = sc.nextInt();sc.nextLine();}
        catch(Exception e) {System.out.println("Invalid input. Please enter a number."); sc.next();}
        return num;
    }
    
    public static double doubleNumInput(){
        double num = 0;
        try{num = sc.nextDouble();sc.nextLine();}
        catch(Exception e) {System.out.println("Invalid input. Please enter a number."); sc.next();}
        return num;
    }

    
    public static void startUp(){
        int num =6;

        for(int i = 0 ; i <num ; i++)
        {
            for (int j = 0 ; j <= i ; j++)
            {
                    System.out.print("*");                
            } 
            
            if (i == 3) {
                System.out.print("    ACME SOLUTIONS    ");}
            else {
                int spaces = (num - i) * 2 + 16;
                for (int j = 0; j < spaces; j++) {
                    System.out.print(" ");
                    }
                }
                
            for (int j = 0 ; j <= i ; j++)
            {
                System.out.print("*");                
            }
            
            System.out.println();
        }
        loadFeedback();
        menu();
    }

        public static void loadFeedback(){
        String file = "C:\\Users\\Tanka\\Documents\\Opal\\RedStackExperimentProject\\experiments_area\\from_Haitham\\customerFeedbackPortalEvaluation\\feedback.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            names[count] = parts[0];
            products[count] = parts[1];
            ratings[count] = Integer.parseInt(parts[2]);
            comments[count] = parts[3];
            count++;
        }
        System.out.println("Loaded " + count + " feedback entries from feedback.txt");
        }catch (IOException e) {
        System.out.println("No saved feedback found. Starting fresh.");
        }
    }

        public static void submitFeedback(){
            System.out.println("--- Submit Feedback ---");
        
            String name ;
            while (true)
                {
                System.out.print("Customer name: ");
                name = sc.nextLine();
                if (!name.isEmpty()) {
                    
                    break;
                }
                System.out.print("Name cannot be empty. ");
                }


            String product ;
            while (true) 
                {
                System.out.print("Product name: ");
                product = sc.nextLine();
                if (!product.isEmpty()) {
                    
                    break;
                }
                System.out.print("Product cannot be empty. ");
                }
            
            int rating = 0;
            while (true)
                {
                System.out.print("Enter your rating (1-5): ");
                rating = numinput();
                if (rating >= 1 && rating <= 5) {
                    break; 
                }
                
                System.out.print("Rating must be a number from 1 to 5. ");
                }

                String comment ;
            while (true)
                {
                System.out.print("Enter your comment: ");
                comment = sc.nextLine();
                if (!comment.isEmpty()) {
                    
                    break;
                }
                System.out.print("Comment cannot be empty. ");
                }

            names[count] = name;
            ratings[count] = rating;
            comments[count] = comment;
            products[count] = product;
            count++;
            System.out.println("Thank you, " + name + "! Your feedback has been recorded.");
        }

        public static void viewAllFeedback(){
        if (count == 0) {
            System.out.println("No feedback has been submitted yet.");
            return;
        }
        System.out.println("No.   Customer    Product    Rating    Comment");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < count; i++) {
            System.out.println(i + ". "+  names[i] + "   " + products[i]+  "    " + ratings[i]+ "    " + comments[i]);
            
        }
    
        }

        public static void ratingReport(){
            if (count == 0) {
            System.out.println("No feedback available.");
            return;
            }

            String[] uniqueProducts = Arrays.stream(products).limit(count) .distinct().toArray(String[]::new);

            int uniqueCount = uniqueProducts.length;
            int[][] grid = new int[uniqueCount][5];
            int[] starCounts = new int[5];
            for (int i = 0 ; i < count ; i++)
            {
                String currentProduct = products[i];
                int rating = ratings[i];

                int index = Arrays.asList(uniqueProducts).indexOf(currentProduct);


                if (index != -1) {
                    grid[index][rating - 1]++;
                    starCounts[rating - 1]++;
                }
            }

            System.out.println("Product      1*   2*   3*   4*   5*   Total   Average");
            System.out.println("-------     ---  ---  ---  ---  ---  -------  -------");
            for (int i = 0 ; i<uniqueCount; i++)
            {
                int sum = 0;
                int totalRatings = 0;
                System.out.print(uniqueProducts[i] + "   ");
                for (int j = 0 ; j<5 ; j++)
                {
                    sum += grid[i][j] * (j + 1);
                    totalRatings += grid[i][j];
                    System.out.print("    "+grid[i][j]);    
                }
                System.out.print("    "+totalRatings);
                double average = (totalRatings > 0) ? (double) sum / totalRatings : 0;
                System.out.printf("    %.2f", average);
                System.out.println();
            }
            System.out.println("Ratings overview");
            for (int i = 5 ; i > 0 ; i--){
                int count = starCounts[i-1];
                String star = "";
                for(int j = 0 ; j < count; j++){
                    star +="*";
                }
                if(i == 1){ System.out.println(i+" star   |"+star+"  ("+count+")");}
                else{ System.out.println(i+" stars  |"+star+"  ("+count+")");}
                
            }
        }
        
        public static void searchByProduct() {
            System.out.println("--- Search by Product ---");
            System.out.print("Product to search: ");
            String productt = sc.nextLine().trim();
            HashMap<String, HashMap<String, String>> productDetails = new HashMap<>();
            HashMap<String, String> details = new HashMap<>();

            for (int i = 0; i < count; i++) {
                if(products[i].equals(productt) ){
                    details.put(names[i], ratings[i] + "   " + comments[i] );
                    productDetails.put(products[i],details);
                    }
                }
                int numberOfFeedback = details.size();
                if(details.isEmpty())
                {
                    System.out.println("No feedback found for \"" + productt + "\".");
                }
                else
                {
                    System.out.println("Found "+numberOfFeedback+" entries for " + productt);
                    for (String key : details.keySet()) {
                            System.out.println(key + "   " +details.get(key));
                    }
                    
                }
        }

        public static void saveFeedback(){
        String file = "C:\\Users\\Tanka\\Documents\\Opal\\RedStackExperimentProject\\experiments_area\\from_Haitham\\customerFeedbackPortalEvaluation\\feedback.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < count; i++) {
                writer.write(names[i] + "|" + products[i] + "|" + ratings[i] + "|" + comments[i]);
                writer.newLine();
            }
            System.out.println("Feedback Saved");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void menu(){  
        boolean isRunning = true;
        Map<String, Runnable> menuMap = new LinkedHashMap<>();
        menuMap.put("Submit Feedback", () -> submitFeedback());
        menuMap.put("View All Feedback", () -> viewAllFeedback());
        menuMap.put("Rating Report", () -> ratingReport());
        menuMap.put("Search by Product", () -> searchByProduct());
        menuMap.put("Save to File", () -> saveFeedback());
        while (isRunning) {
            System.out.println("+====================================+");
            System.out.println("|      CUSTOMER FEEDBACK PORTAL      |");
            System.out.println("+====================================+");
            int index = 1;
            for (String string : menuMap.keySet()) {
                int length = 27-string.length();
                System.out.printf("|      "+index +". "+string + "%-"+ length +"s"+"|\n", " ");
                index++;
            }
            System.out.println("|      "+index +". Exit                       |");
            System.out.println("+====================================+");
            System.out.print("Enter your choice: ");
            int choice = numinput();
            
            List<Runnable> run = new ArrayList<>(menuMap.values());
            if (choice > 0 && choice <= run.size()){
                run.get(choice-1).run();
            }else if (choice == index) {
                saveFeedback();
                isRunning = false;
            }
            else{
                System.out.println("Invalid choice. Please Try again.");
            }
        } 
    }

    public static void main(String[] args) {
        startUp();
    }
}
