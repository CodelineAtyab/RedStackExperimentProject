import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        try{num = sc.nextInt();}
        catch(Exception e) {System.out.println("Invalid input. Please enter a number."); sc.next();}
        return num;
    }
    
    public static double doubleNumInput(){
        double num = 0;
        try{num = sc.nextDouble();}
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
            ratings[count] = Integer.parseInt(parts[1]);
            comments[count] = parts[2];
            products[count] = parts[3];
            count++;
        }
        System.out.println("Loaded " + count + " feedback entries from feedback.txt");
        }catch (IOException e) {
        System.out.println("No saved feedback found. Starting fresh.");
        }
    }




    public static void menu(){  
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("+====================================+");
            System.out.println("|      CUSTOMER FEEDBACK PORTAL      |");
            System.out.println("+====================================+");
            System.out.println("|      1. Submit Feedback            |");
            System.out.println("|      2. View All Feedback          |");
            System.out.println("|      3. Rating Report              |");
            System.out.println("|      4. Search by Product          |");
            System.out.println("|      5. Save to File               |");
            System.out.println("|      6. Exit                       |");
            System.out.println("+====================================+");
            System.out.print("Enter your choice: ");
            int choice = numinput();
            switch (choice) {
                case 1:
                    submitFeedback();
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                    break;
            }
        } 
    }

    public static void main(String[] args) {
        startUp();
    }
}
