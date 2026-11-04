import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Feedback {
    static Scanner sc = new Scanner(System.in);

    // use arraylist outside method because we need use this arraylist in more than 1 method
    // use it on showFeedback and submitFeedback
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> products = new ArrayList<>();
    static ArrayList<Integer> ratings = new ArrayList<>();
    static ArrayList<String> comments = new ArrayList<>();


    public static void main(String[] args) {


        String CompanyName = "ACME SOLUTIONS";

        // this for loop for number of row and start with one and finish at 6
        for (int i = 1; i <= 6; i++) {
            // print the *
            //  j <= i>>> print a number of stars equal to the current row numbe
            for (int j = 1; j <= i; j++) {

                System.out.print("*");
            }

            // the space between tow logo stars

            // the number of row to print the name company is 4 on line 4
            if (i == 4) {
                // here print 7 space before the name of company ...if use less or mor than 7 it not print like we wont
                for (int j = 1; j <= 7; j++) {
                    System.out.print(" ");
                }

                System.out.print(CompanyName);

                //  // here print 7 space after the name of company if use less or mor than 7 it not print like we wont
                for (int j = 1; j <= 8; j++) {
                    System.out.print(" ");
                }
            } else {

                // else if not in row 4 print the space not the name company
                // j <= 37 - (2 * i): It is a way to calculate the number of spaces so that the stars on the right stay in the correct position.
                for (int j = 1; j <= 37 - (2 * i); j++) {
                    System.out.print(" ");
                }
            }

            // print the logo in the right place same in the left
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }


            System.out.println();
        }


        // it must write this here in main to show the menu under the banner and  to switch the loadFeedback to read the file
        loadFeedback();
        showMenu();

    }


    public static void loadFeedback() {

        // BufferedReader>>> read line by line
        // FileReader open the file that want to read  (feedback.txt)

        try (BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"))) {
            // create a variable to store the line
            String line;

            // calc the number of rating
            int count = 0;

            // reader.readline(): read one line from the file
            //  != null there is no line to read  so while complete read if there have a line to read
            while ((line = reader.readLine()) != null) {

                count++;
                // add the value of count in the text
            }
            System.out.println("Loaded " + count + " feedback entries from feedback.txt");

            // error handling
        } catch (IOException e) {
            System.out.println("No saved feedback found. Starting fresh.");

        }

    }

    public static void showMenu() {


        int choice = 0;
        while (choice != 6) {

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

            //read what user enter and save in choice
            choice = sc.nextInt();
            //reads the remaining Enter key after nextInt() so the next input can be entered correctly.
            sc.nextLine();


            if (choice == 1) {
                submitFeedback();

            } else if (choice == 2) {

                viewAllFeedback();

            } else if (choice == 3) {

                 ratingReport();

            } else if (choice == 4) {

                  searchByProduct();

            } else if (choice == 5) {

                    saveFeedback();
                System.out.println("Saved " + names.size() + " feedback entries to feedback.txt");
            } else if (choice == 6) {

                System.out.println("Saving feedback... done");
                saveFeedback();
                System.out.println(" Thank you for using the Customer Feedback Portal. Goodbye!");
            } else {
                System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        }
    }


    public static void submitFeedback() {

        int rating = 0;

        String name = "";


        while (name.isEmpty()) {

            System.out.print("Enter Customer name: ");

            name = sc.nextLine();

            if (name.isEmpty()) {

                System.out.println("Name cannot be empty.");
            }
        }


        System.out.print("Enter Product name: ");
        // read the name entered by user
        //and because the product name may contain spaces
        String product = sc.nextLine();


        while (rating < 1 || rating > 5) {
            System.out.print("Enter rating (1-5): ");

            if (sc.hasNextInt()) {

                // checks if the user is input is a valid integer before reading it with nextInt() nat abc
                rating = sc.nextInt();

                if (rating < 1 || rating > 5) {
                    System.out.println("Invalid rating. Please enter a number between 1 and 5.");
                }


            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }

        sc.nextLine();

        System.out.print("Enter your comment: ");
        String comment = sc.nextLine();

      // use add() to store feedback customer in array list
        // need to add more than one information
        names.add(name);
        products.add(product);
        ratings.add(rating);
        comments.add(comment);

        System.out.println("Thank you, " + name + "! Your feedback has been recorded.");


    }




    public static void viewAllFeedback() {

        if (names.isEmpty()) {
            System.out.println("No feedback has been submitted yet.");
        } else {

            //	Prints formatted output
            System.out.print ("No\t");
            System.out.print("Customer\t");
            System.out.print("Product\t\t\t\t\t");
            System.out.print("Rating\t\t\t");
            System.out.println("Comment");

            System.out.println("--------------------------------------------------------------------------");

            //names.size()...returns the number of names
            for (int i = 0; i < names.size(); i++) {


                // 4 \t>>>> 11 litters

                System.out.print((i + 1)+"\t");
                System.out.print (names.get(i)+"\t\t");
                System.out.print (products.get(i)+"\t\t\t\t");
                System.out.print (ratings.get(i)+"\t\t\t");
                System.out.println (comments.get(i));


            }}}




    public static void ratingReport() {

        if (products.isEmpty()) {

            System.out.println("No feedback available.");

        } else {

            ArrayList<String> productNames = new ArrayList<>();

            // Store different product names
            for (int i = 0; i < products.size(); i++) {


                // contains is to checks if an item exists
                // ! >> not >>> so if the name of the products unavailable in productNames it must be add
                // and if found Router is add i  not add aging
                if (!productNames.contains(products.get(i))) {

                    productNames.add(products.get(i));
                }
            }

            // Create a 2D array
            // we need only 5 rating column
            int[][] ratingsTable = new int[productNames.size()][5];

            // Count ratings for each product
            // products.size>>>	number of products
            // this for loop go  to all feedback enters
            for (int i = 0; i < products.size(); i++) {

                // and this for all product name
                for (int j = 0; j < productNames.size(); j++) {


                    // equals >> to compares two text values if it is equal or not
                    if (products.get(i).equals(productNames.get(j))) {
                        int rating = ratings.get(i);

                        //converts rating to array index use this [rating - 1] because it starts from 0 index
                        ratingsTable[j][rating - 1]++;
                    }
                }
            }

            // Print rating report

            System.out.print("Product\t\t\t");
            System.out.print("1*\t");
            System.out.print("2*\t");
            System.out.print("3*\t");
            System.out.print("4*\t");
            System.out.print("5*\t");
            System.out.print("Total\t\t");
            System.out.println("      Average");

            System.out.println("---------------------------------------------------------------------------------");




            for (int i = 0; i < productNames.size(); i++) {

                // calc the sum and average for each product
                // starts total and sum from 0
                int total = 0;
                int sum = 0;
                double average = 0;// because have decimal number


                for (int j = 0; j < 5; j++) {


                    // adding rate count
                    //gets the actual star rating>>>. j+1
                    //calc how many user are rating
                    total = total + ratingsTable[i][j];

                    //calc all the stares that user are rating
                    sum = sum + (ratingsTable[i][j] * (j + 1));
                }

                // use double converts the value to decimal and average to store ave rate
                if (total > 0) {
                    average = (double) sum / total;
                }


                // print all information of product
                System.out.print(productNames.get(i) + "\t\t");
                System.out.print(ratingsTable[i][0] + "\t");
                System.out.print( ratingsTable[i][1] + "\t");
                System.out.print(ratingsTable[i][2] + "\t");
                System.out.print( ratingsTable[i][3] + "\t");
                System.out.print(ratingsTable[i][4] + "\t");
                System.out.print( total + "\t\t");
                System.out.println("     " + average);

            }


            // Print ratings overview
            System.out.println("Ratings overview");


            //Start from 5 and star-- because we need to start from 5 to 1 ( decrease )
            for (int star = 5; star >= 1; star--) {

                int count = 0;



                //here to calc how many user rate  for each star>>> for example how many user evaluate 2 star , 5 star .....
                // and it calc what inside star variable
                for (int i = 0; i < productNames .size(); i++) {

                   // index start with 0 to calc
                    //for [i] >> row
                    // for [star - 1] >>>> column (number of star)>> use it because index start from 0 and rate start from 1`

                    count = count + ratingsTable[i][star - 1];
                }

                //if star equal to one print 1 star  | and start from one from down

                if (star == 1) {

                    System.out.print("1 star  | ");

                } else {
                  //
                    System.out.print(star + " stars | ");
                }

                //print the stars depends on the count
                //use j because we need print * only
                for (int j = 0; j < count; j++) {
                    System.out.print("*");
                }

                //print the rating in () and end of the line
                System.out.println("             (" + count + ")");
            }
        }
    }

    public static void searchByProduct() {

        HashMap<String, ArrayList<Integer>> productFeedback = new HashMap<>();


        //go to all product in the list
        for (int i = 0; i < products.size(); i++) {

            // products.get(i) mean get the name of product that is in index
            //convert the all litter to lower case >>> toLowerCase()>>>>> PHONE to phone
            String product = products.get(i).toLowerCase();



            // this if loop to check if the product already exists in the HashMap.
            // containsKey(product) check if product in the hashmap (here if not the product in hashmap)

            if (!productFeedback.containsKey(product)) {

                // put >>> method adds a new key and value.
                productFeedback.put(product, new ArrayList<Integer>());
            }

            //this to add the location the product
            productFeedback.get(product).add(i);
        }

        System.out.println(" --- Search by Product ---");

        System.out.print("product to search: ");

        // sc.nextLine()>> that for receive what the user write

        String search = sc.nextLine().toLowerCase();

        // to check if the product in hashmap list  write contains key to check if the user enter product are in the hashmap
        if (productFeedback.containsKey(search)) {


            //productFeedback.get(search)>>>> get  the product  value from the HashMap.
            //ArrayList<Integer> >>> indexes stores the product  index numbers.
            ArrayList<Integer> indexes = productFeedback.get(search);

            int total = 0;

            // calc indexes.size() the element inside the index
            //indexes.get(0)>>> get the first number in the index
            //products.get(indexes.get(0) >>> use the number we found to access to the name of product from the product list
            System.out.println("Found " + indexes.size() + " entries for  " + products.get(indexes.get(0)) + " :");


            //visit all sits that in index
            for (int i = 0; i < indexes.size(); i++) {

                //select the sits from inside index and store in index variable
                int index = indexes.get(i);



                //use the index to access to user information>>> the index start from 0
                System.out.println(names.get(index) + "  " + ratings.get(index) + "  " + comments.get(index));


                total = total + ratings.get(index);

            }
            double average = (double) total / indexes.size();

            System.out.printf("Average rating: %.2f%n", average);

        } else {
            System.out.println("No feedback found for " + search + " ");


        }

    }

    public static void saveFeedback() {

        try {

            // use to write from  the feedback.txt
            // FileWriter open the file to write
            //BufferedWriter >> use to write information in feedback text

            BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt"));

            for (int i = 0; i < names.size(); i++) {

                writer.write(names.get(i) + "|" + products.get(i) + "|"  + ratings.get(i) + "|" + comments.get(i));

                // mean go to the  next line
                writer.newLine();
            }

            // close the file
            writer.close();


            // ues it uf have any error when use the file
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }



    }

