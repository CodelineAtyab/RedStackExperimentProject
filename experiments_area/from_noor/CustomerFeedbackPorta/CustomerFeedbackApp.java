
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CustomerFeedbackApp {
//static BufferedReader inputt = new BufferedReader(new InputStreamReader(System.in));
 static Scanner input = new Scanner(System.in);
static final String FILE_NAME = "feedback.txt";
static ArrayList<String[]> feedback = new ArrayList<>();


public static void main(String[] args) {
printBanner();


loadFeedback();


int choice=0;
do{
Menu(); 

try {
    System.out.print("Enter your choice: ");
     choice = input.nextInt();
} catch (Exception e) {
    System.out.print("Invalid choice. Please enter a number from 1 to 6. " + e);
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
    saveFeedback(true); 
    break;

    case 6:
          saveFeedback(false);
          System.out.println("Goodbye!");
    break;  
    default:
         System.out.println("Invalid choice. Try again.");
        break;
}
}while(choice !=6);

   
}
/////////////////////////////////////////////////////////////////////////

//Logo Banner
static void printBanner() {
for(int i=1; i<=6; i++){ 

for (int k=1 ; k<=i; k++){   //Left triangle
    System.out.print("*");}


if (i == 4) {    //// Company name in the middle row
    System.out.print(" ACME SOLUTIONS ");
} else {
for (int j=1 ; j<=20-i ; j++){
     System.out.print(" ");
    }}

for (int m=1 ; m<=i; m++){   // Right triangle
    System.out.print("*");}

    System.out.println();
}
}

static void loadFeedback() {
    try {
        BufferedReader reader = new BufferedReader( new FileReader("feedback.txt") );

        String line;

        while ((line = reader.readLine()) != null) {
            String[] data = line.split("\\|");
            feedback.add(data);
        }

        reader.close();

    } catch (IOException e) {
        System.out.println("No saved feedback found. Starting fresh " + e.getMessage());
    }
}
//3 Main Menu
public static void Menu(){
 System.out.println("+=================================+");
 System.out.println("|    CUSTOMER FEEDBACK PORTAL     |");
 System.out.println("+=================================+");

 System.out.println("1. Submit Feedback");
 System.out.println("2. View All Feedback");
 System.out.println("3. Rating Report");
 System.out.println("4. Search by Product");
 System.out.println("5. Save to File");
 System.out.println("6.Exit");
 System.out.println("+=================================+");
}


//function 
//Submit Feedback
static void submitFeedback() {
System.out.println("--- Submit Feedback ---");
//name
System.out.println("Customer name:"); 
String name = input.nextLine();

 while (name.isEmpty()) {
        System.out.println("Name cannot be empty.");
        System.out.print("Customer name: ");
        name = input.nextLine();
    }

//Product
System.out.print("product ");
String Product= input.nextLine();
  while (Product.isEmpty()) {
 System.out.println("Product cannot be empty.product:");
 Product= input.nextLine();
  }

//rating 
int rating=0;
boolean valid =false;
while (!valid) {
   System.out.println("Rating (1-5) :");  
   try {
    rating = Integer.parseInt(input.nextLine());

    if (rating>=1 && rating <=5){
        valid=true;
    }else{
         System.out.println("rating must be a number from 1 to 5");  
    }
   } catch (NumberFormatException e) {
    System.out.println("rating must be a number from 1 to 5");
   }
}

//comment
 System.out.println("comment");
 String comment=input.nextLine();

 //save to array 
 feedback.add (new String[]{ name , Product , String.valueOf(rating) ,comment});
System.out.println("Thank you " + name + "your feedback has been recorded");

 }

//5 View All Feedback
static void viewAllFeedback() {
    if (feedback.size()==0){
         System.out.println(" no Feedback has been submitted yet");
    return ;
    }
   System.out.println("No.  Customer    Product  Rating  Comment");
   System.out.println("---   --------   ------   ------  --------");
    for(int i=0 ; i<feedback.size(); i++){
    String[] e = feedback.get(i);
    System.out.println( (i+1)+  e[0] +e[1]+e[2]+e[3]);
    }
}

//6 Rating Report
static void ratingReport() {
System.out.println("--- Rating Report ---");
        if (feedback.isEmpty()) {
            System.out.println("No feedback available for the report.");
            return;
        }


ArrayList<String> products = new ArrayList<>(); //Get unique products
for (int i=0 ; i<feedback.size(); i++){
   String Newproduct=feedback.get(i)[1];

   boolean ex= false;
   for(int j=0; j<products.size(); j++){
    if (products.get(j).equalsIgnoreCase(Newproduct)){
        ex=true;
    }
   }
   if(!ex){
    products.add(Newproduct);
   }
}

 int[][]count =new int[products.size()][5]; //Create 2D array

 for (int i=0 ; i<feedback.size(); i++){        // Count ratings
    String []e =feedback.get(i);
    int rating =Integer.parseInt(e[2]);

for(int p=0 ; p<products.size(); p++){
    if(products.get(p).equalsIgnoreCase(e[1])){
        count[p][rating-1]++;
    }
}
 }
// Print report
System.out.println("-----------------------------------------------");
System.out.println("| Product | 1* | 2* | 3* | 4* | 5* | Total | Average |");
System.out.println("-----------------------------------------------");
int[] starTotals = new int[5];

        for (int p = 0; p < products.size(); p++){
            int  total = 0;
            int sum =0;

            for (int s = 0; s < 5; s++) {
                total= total+count[p][s];
                sum=   sum+count[p][s]*(s+1);
                starTotals[s]= starTotals[s]+count[p][s];
            }
            double average=(double)sum/total;

            System.out.println("| " + products.get(p) +
        " | " + count[p][0] +
        " | " + count[p][1] +
        " | " + count[p][2] +
        " | " + count[p][3] +
        " | " + count[p][4] +
        " | " + total +
        " | " + average + " |");


        }
   // Ratings overview
System.out.println(" Ratings Overview");
for (int s = 0; s < 5; s++) {
    System.out.println((s + 1) + " Stars: " + starTotals[s]);
}


}


//7 Search by Product
static void searchByProduct() {
 System.out.println("--- Search by Product ---");

    System.out.print("Product to search: ");
    String search = input.nextLine().trim();
 
    HashMap<String, ArrayList<String[]>> productFeedback = new HashMap<>();//Dictionary
    // Group feedback by product
    for (int i = 0; i < feedback.size(); i++) {
        String[] e = feedback.get(i);
        String product = e[1].trim().toLowerCase();

        productFeedback.putIfAbsent(product, new ArrayList<>());
        productFeedback.get(product).add(e);
} 
// Search for product
    ArrayList<String[]> results = productFeedback.get(search.toLowerCase());

    if (results == null || results.isEmpty()) {
        System.out.println("No feedback found for \"" + search + "\".");
        return;
    }
}


//8 Save and Exit
static void saveFeedback(boolean quiet) {
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME) );

        for (int i = 0; i < feedback.size(); i++) {
            String[] e = feedback.get(i);

            writer.write(e[0] + "|" + e[1] + "|" + e[2] + "|" + e[3]);
            writer.newLine();
        }

        writer.close();

        if (!quiet) {
            System.out.println("Feedback saved successfully.");
        }

    } catch (IOException e) {
        System.out.println("Error: could not save feedback " + e.getMessage());
    }

}

}