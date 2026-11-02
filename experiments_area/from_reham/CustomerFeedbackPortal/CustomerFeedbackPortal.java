import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerFeedbackPortal {

    static Scanner input =new Scanner(System.in);
    //  Create arrays
    static String[] names =new String [100];
    static String[] products =new String [100];
    static int[] ratings = new int[100];
    static String[] comments = new String[100];
    static int count =0;
    public static void main(String[] args) {
        boolean system = true;
        logo();
        loadfeedback();
        
        while (system == true){
        menu();

            int choice = 0;
            try{
                System.out.print("Enter your choice: ");
                choice = input.nextInt();
                
                switch (choice){
                    case 1: SubmitFeedback();break;
                    case 2: ViewAllFeedback();break;
                    case 3: RatingReport();break;
                    case 4: SearchByProduct();break;
                    case 5: SaveAndExit(); system =false; break;
                    case 6: system=false; System.out.println("Goodbye!");break;
                    default:System.out.println("Please Enter a number from 1 to 6");
                }

            }catch(InputMismatchException exception){
                System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                input.nextLine();
            }

        }
    }

    public static void logo(){
        int rn=6;
        for (int r=0; r<rn ;r++){

            for(int sl=0 ; sl<=r ;sl++){
            System.out.print("*");
            }
            for(int sp=0 ;sp<2*(rn-r)+14;sp++){
                if(r==3){
                System.out.print("   ACME SOLUTIONS   ");
                break;
                }
                System.out.print(" ");

            }
            for(int sr=0 ; sr<=r ;sr++){
            System.out.print("*");
            }
            System.out.println();
        }

    }

    //Load feedback:
    public static void loadfeedback(){
        String feedbackfile="C:\\Opal-RedStack\\RedStackExperimentProject\\experiments_area\\from_reham\\CustomerFeedbackPortal\\Cust_Feedback.txt";
        
        try(BufferedReader read =new BufferedReader(new FileReader(feedbackfile))){
            String Line;
            while((Line=read.readLine())!=null){
                String name = Line;
                String product =read.readLine();
                String rating = read.readLine();
                String comment = read.readLine();
                names[count] = name;
                products[count]= product;
                ratings[count] = Integer.parseInt(rating);
                comments[count] = comment;
                count ++;
            }
            if (count>0){
                System.out.println("Loaded "+count+" feedback entries from Cust_feedback.txt");
            }
            else{
                System.out.println("No saved feedback found. Starting fresh.");
            }

        }catch(IOException exception){
            System.out.print("Error loading feedback!");
        }
    }

    //Menu
    public static void menu(){

        String Title =" CUSTOMER FEEDBACK PORTAL ";
        System.out.print("+");
        for (int i=0 ; i<=Title.length();i++){
            System.out.print("=");
        }
        System.out.println("+");
        for(int i=1;i<=1;i++){
            System.out.println("|"+Title+" |");
        }
         System.out.print("+");
        for (int i=0 ; i<=Title.length();i++){
            System.out.print("=");
        }
        System.out.println("+");

        String[] menu= {
            "Submit Feedback",
            "View All Feedback",
            "Rating Report",
            "Search by product",
            "Save to File",
            "Exit",
        };

        for (int i=0; i<menu.length;i++){
            System.out.print("| ");
            System.out.print((i+1)+". "+menu[i]);
            for (int j = 0; j <(Title.length()-menu[i].length())-4; j++) {
                System.out.print(" ");
            }
            System.out.println(" |");
        }
         System.out.print("+");
        for (int i=0 ; i<=Title.length();i++){
            System.out.print("=");
        }
        System.out.println("+");
    }

    //Submit FeedBack
    public static void SubmitFeedback(){
        System.out.println("--- Submit Feedback ---");
        if(count<100){
            //Name
            System.out.print("Customer name: ");
            input.nextLine();
            String name = input.nextLine();
            while(name.isBlank()){
                System.out.println("Name can not be empty");
                System.out.print("Customer name: ");

                name=input.nextLine();

            }
            //Product
            System.out.print("Product: ");
            String product=input.nextLine();
            //rating
            int rating=0;
            while(true){
                try{
                System.out.print("Rating (1-5): ");
                rating = input.nextInt();

                if(rating >5 || rating <1 ){
                    System.out.println("Please Enter a valid Number ");
                }
                else{
                    break;
                }
                }catch(InputMismatchException exception){
                System.out.println("Enter A Number!");
                input.nextLine();
                }
            }

            System.out.print("Comment: ");
            input.nextLine();
            String comment =input.nextLine();

            //Store them to the arrays 
            names[count] = name;
            products[count]= product;
            ratings[count] = rating;
            comments[count] = comment;
            count ++;

            System.out.println("Thank you, "+name+"! Your feedback has been recorded.");
        }else{
            System.out.println("Storage is full (100 entries).");
        }

    }

    //View All Feedback 
    public static void ViewAllFeedback(){
        System.out.println("No.   Customer         Product         Rating    Comment           ");
        System.out.println("-".repeat(3)+"   "+"-".repeat(10)+"       "+"-".repeat(12)+"    "+"-".repeat(6)+"    "+"-".repeat(15));

        for(int i =0; i<count; i++){
            System.out.print(" "+i+"     ");
            System.out.print(names[i]);
            for (int j=0; j<=15-names[i].length();j++){
                System.out.print(" ");
            }
            System.out.print(products[i]);
            for (int j=0; j<=15-products[i].length();j++){
                System.out.print(" ");
            }
            System.out.print(ratings[i]);
            String numtext= String.valueOf(ratings);
            for (int j=0; j<=2*(15-numtext.length());j++){
                System.out.print(" ");
            }
            System.out.println(comments[i]);
        }
    }

    //View Rating Report
    public static void RatingReport(){

        //create an empty list 
        ArrayList<String> ProductName =new ArrayList<>(); //<- we want to collect the Product names here <<not repeted>>

        //Check if the product exist; do nothing  / else add it to the array list 
        for(int i=0; i<count ;i++){
            
                    /* contains(): Checks if an item exists in a list
                      /> Searches the array list and compares the item you give it with each item in the list*/

            if(ProductName.contains(products[i])){ // <= Chwcks if it exists
                //Do nothing << it exists>>
            }else{
                ProductName.add(products[i]); // Add it to the ArrayList
            }
        }
        //Create A 2D Array 
        int [][] ratingCounts =new int [ProductName.size()][5]; //<= We use .size to know how many items are imside it 

        //Count the ratings 
        for (int i=0 ;i<count;i++){
            int Row =ProductName.indexOf(products[i]);
            int column = ratings[i]-1;
            ratingCounts[Row][column]++;
        }
        //Print the result 
        for(int i=0 ; i<ProductName.size(); i++){
            //Geting the products names out of the array list 
                System.out.print(ProductName.get(i)+" :");  
                double totalRatings=0.0;
                double totalScore=0.0;
                double avg=0.0;
                for (int j=0 ; j<5 ; j++){
                    totalRatings+=ratingCounts[i][j];
                    totalScore+=ratingCounts[i][j]*(j+1);
                    System.out.print(ratingCounts[i][j]+" ");
                }
                avg = totalScore / totalRatings;        
                System.out.print(" "+totalRatings+" "+avg);

                System.out.println();
        }
            
        for (int column =4; column >=0; column--){
            
            int total =0; // to count the total stars

            // sum each row 
            for (int row =0 ; row<ratingCounts.length ;row++){
                total=total+ratingCounts[row][column];
            }

            System.out.print((column+1)+" Stars "+"   | ");
            for (int star = 0; star < total; star++) {
            System.out.print("*");
            }
            System.out.println();
        }
    }

    //Search by Product
    public static void SearchByProduct(){
        HashMap<String,ArrayList<String>> feedback =new HashMap<>();
        System.out.print("Product to search: ");
        input.nextLine();
        String Search =input.nextLine().toLowerCase();
        for (int i=0 ; i<count;i++){

            String CurrentProduct = products[i].toLowerCase();

            if(!feedback.containsKey(CurrentProduct)){
                feedback.put(CurrentProduct,new ArrayList<>());                
            }

            feedback.get(CurrentProduct).add(names[i] + ", " + ratings[i] + ", " + comments[i]); 
            
        }
        if (feedback.containsKey(Search)) {

            ArrayList<String> result = feedback.get(Search);

            System.out.println("Found " + result.size() + " entries for " + Search);

            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }

        } else {
            System.out.println("No feedback found for " + Search);
        }
    }

    //Save and Exit
    public static void SaveAndExit(){
        String feedbackfiles ="C:\\Opal-RedStack\\RedStackExperimentProject\\experiments_area\\from_reham\\CustomerFeedbackPortal\\Cust_Feedback.txt";
        try(BufferedWriter write =new BufferedWriter(new FileWriter(feedbackfiles))){
            for (int i=0 ; i < count ; i ++){
                write.write(names[i]);
                write.newLine();
                write.write(products[i]);
                write.newLine();
                //String.valueOf => used to convert the value to string because buffers epexts Strings not numbers
                write.write(String.valueOf(ratings[i]));
                write.newLine();
                write.write(comments[i]);
                write.newLine(); 
            }
                System.out.println("Saved Succsesfully");   

        }catch(IOException exception){
            System.out.println("Error Saveing feedback");
            }
}}
