import java.io.*;
import java.util.Scanner;

public class FeedbackProtal {

    static Scanner sc = new Scanner(System.in);
    static void Logo() {
        String Text = "ACME SOLUTIONS ";
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i + 1; j++) {

                System.out.print("* ");

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

                        System.out.print(" *");
                    }
                }
            }
            System.out.println();
        }
    }

    static void LoadFeedback() throws IOException {
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"));
        String line = reader.readLine();
        while (line != null) {
            count++;
            line = reader.readLine();
        }
        reader.close();

        if (count > 0) {
            System.out.println("Loaded " + count + " feedback entries from feedback.txt");
        }
    }

    public static void main(String[] args) {
        try {
            Logo();
            LoadFeedback();
        } catch (Exception e) {
            System.out.println("No saved feedback found. Starting fresh.");
        }

        boolean stop = false;
        do {
            System.out.println("\n+=========================================+");
            System.out.println("|         CUSTOMER FEEDBACK PORTAL        |");
            System.out.println("+=========================================+");
            System.out.println("| 1. Submit Feedback                      |");
            System.out.println("| 2. View All Feedback                    |");
            System.out.println("| 3. Rating Report                        |");
            System.out.println("| 4. Search by Product                    |");
            System.out.println("| 5. Save to File                         |");
            System.out.println("| 6. Exit                                 |");
            System.out.println("+=========================================+");
            System.out.print("Enter your choice: ");
            String input = sc.nextLine();

            switch (input) {
                case "1":
                    
                    break;
                case "2":
                    
                    break;
                case "3":
                    
                    break;
                case "4":

                    break;
                case "5":
                    
                    break;
                case "6":
                    stop = true;
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                    
            }

        } while (!stop);

    }
}
