import java.util.Scanner;

public class ATMProject {

    static Scanner scanner = new Scanner(System.in);
    static double balance = 1000.00;
    static int pin = 1234;

    static double depositAmount =0.0;
    static int counterDeposit =0;
    static double totalDeposit =0.0;

    static double withdrawalAmount=0.0;
    static int counterWithdrawal=0;
    static double totalWithdrawal =0.0;



    public static void main(String[] args) {

        int attempts = 3;

        // Check PIN
        while (attempts > 0) {
            System.out.println("Enter PIN:");
            int enterPin = scanner.nextInt();

            if (enterPin == pin) {
                System.out.println("Welcome!");
                break;
            } else {
                attempts--;
                System.out.println("Wrong PIN. Attempts left: " + attempts);
            }
        }

        // Lock card after 3 incorrect attempts
        if (attempts == 0) {
            System.out.println("Card locked");
            scanner.close();
            return;
        }

        // Declare num 
        int num;

        do {
            menu();

            System.out.println("Please enter a number between 1 and 7:");
            num = scanner.nextInt();

            switch (num) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    accountTier();
                    break;

                case 5:
                    savingsProjection();
                    break;

                case 6:
                    receiptSummary();
                    break;

                case 7:
                    changePin();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }

        } while (num != 0);

        scanner.close();

    } // close main

    // Display menu
    static void menu() {
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Account tier");
        System.out.println("5. Savings projection");
        System.out.println("6. Receipt summary");
        System.out.println("7. Change PIN");
        System.out.println("0. Exit");
    }
    //Case 1
    static void checkBalance(){
        System.out.println("Your current balance is: " + balance);
    }
    //Case 2
    static void deposit(){
        System.out.printf("Enter deposit amount: ");
        depositAmount = scanner.nextDouble();
        
        if((depositAmount >0) && (depositAmount <= 5000)){
            counterDeposit ++;
            totalDeposit = totalDeposit + depositAmount;
            balance = balance + depositAmount;
            System.out.println("Deposit successful. Balance: " + balance);
        }else{
            System.out.println("error");
        }
        //System.out.println("Deposit Counter: "+counterDeposit + "  Total Deposit: "+ totalDeposit);
    }
    //Case 3
    static void withdraw(){
        System.out.printf("Enter withdrawal amount: ");
        double withdrawalAmount = scanner.nextDouble();

        double fee;
        //check if positive and multiple of 10
        if (withdrawalAmount > 0 && withdrawalAmount % 10 == 0) {

            //can't withdrawn in one session more that 1000
            if (totalWithdrawal + withdrawalAmount > 1000) {
                System.out.println("Session withdrawal limit exceeded (1000).");
                return;
            }
            //fee based on withdrawal Amount
            if (withdrawalAmount <= 500) {
                fee = 2.00;
            } else {
                fee = 5.00;
            }
            //can't withdrawal if balance less
            if (balance < withdrawalAmount + fee) {
                System.out.println("Insufficient balance");
                return;
            }

            // update the counter and balance
            counterWithdrawal++;
            totalWithdrawal = totalWithdrawal + withdrawalAmount;
            balance = balance - (withdrawalAmount + fee);
            // %.2f%n floting and n--> new line
            System.out.printf("Fee: %.2f%n", fee);
            System.out.printf("Withdrawal successful. Balance: %.2f%n", balance);
            System.out.println("Withdrawal Counter: " + counterWithdrawal + "  Total Withdrawal: " + String.format("%.2f", totalWithdrawal));

        } else {
            System.out.println("Amount must be positive and a multiple of 10.");
        }
    }

    //Case 4
    static void accountTier(){
        double rate;
        String tier;
        if (balance < 1000) {
            tier = "Bronze"; 
            rate = 0.01;
        } else if (balance < 5000) {
            tier = "Silver"; 
            rate = 0.02;
        } else if (balance < 20000) {
            tier = "Gold"; 
            rate = 0.03;
        } else {
            tier = "Platinum"; 
            rate = 0.04;
        }
        System.out.println("Tier: " + tier + ", interest rate: " + (rate * 100) + "%");
        }
    //Case 5
    static void savingsProjection(){
        System.out.println("Enter number of years:");
        int years = scanner.nextInt();

        if (years < 1 || years > 10) {
            System.out.println("Invalid number of years. Please enter between 1 and 10.");
            return;
        }

        // Determine interest rate based on tier
        double rate;
        if (balance < 1000) {
            rate = 0.01; // Bronze
        } else if (balance < 5000) {
            rate = 0.02; // Silver
        } else if (balance < 20000) {
            rate = 0.03; // Gold
        } else {
            rate = 0.04; // Platinum
        }

        double futureBalance = balance;

        // For loop to project year by year
        for (int i = 1; i <= years; i++) {
            futureBalance += futureBalance * rate;
            System.out.printf("Year %d: %.2f%n", i, futureBalance);
        }
        }
    //Case 6
    static void receiptSummary(){
        System.out.printf("Deposits: %d, total: %.2f%n", counterDeposit, totalDeposit);
        System.out.printf("Withdrawals: %d, total: %.2f%n", counterWithdrawal, totalWithdrawal);
        System.out.printf("Balance: %.2f%n", balance);
    }
    //Case 7
    static void changePin(){
        System.out.print("Enter old PIN: ");
        int oldPin = scanner.nextInt();

        // Rule 1: Old PIN must match
        if (oldPin != pin) {
            System.out.println("Incorrect old PIN.");
            return;
        }

        System.out.print("Enter new PIN (4 digits): ");
        int newPin = scanner.nextInt();

        // Rule 2: New PIN must be exactly 4 digits (1000–9999)
        if (newPin < 1000 || newPin > 9999) {
            System.out.println("Invalid PIN. Must be a 4-digit number (1000–9999).");
            return;
        }

        System.out.print("Confirm new PIN: ");
        int confirmPin = scanner.nextInt();

        // Rule 3: Confirmation must match
        if (newPin != confirmPin) {
            System.out.println("PIN entries do not match.");
            return;
        }

        // Success if match
        pin = newPin;
        System.out.println("PIN successfully changed.");
        }
}
