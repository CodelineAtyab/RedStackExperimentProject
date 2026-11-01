import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
                if (choice > 6 || choice <1){
                    System.out.println("Please enter a number from 1 to 6 ");
                }

                switch (choice){
                    case 1: SubmitFeedback();break;
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
                System.out.println("Loaded "+count+" feedback entries from feedback.txt");
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
            String products=input.nextLine();
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
            String comment =input.nextLine();
            input.nextLine();

            System.out.println("Thank you, "+name+"! Your feedback has been recorded.");
        }

    }



}

