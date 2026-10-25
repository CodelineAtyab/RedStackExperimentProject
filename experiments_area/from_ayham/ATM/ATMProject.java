package ATM;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ATMProject {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static double balance = 1000.00;
    private static int pin = 1234;
    private static int depositCount;
    private static int withdrawalCount;
    private static double depositTotal;
    private static double withdrawalTotal;

    private static String readLine(String prompt) {
        System.out.print(prompt);
        if (!SCANNER.hasNextLine()) {
            throw new NoSuchElementException("No more input.");
        }
        return SCANNER.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            String input = readLine(prompt);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            String input = readLine(prompt);
            try {
                double value = Double.parseDouble(input);
                if (Double.isFinite(value)) {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount.");
            }
        }
    }

    private static boolean login() {
        for (int attemptsLeft = 3; attemptsLeft > 0; attemptsLeft--) {
            int enteredPin = readInt("Enter PIN: ");
            if (enteredPin == pin) {
                System.out.println("Welcome!");
                return true;
            }

            if (attemptsLeft > 1) {
                System.out.println("Wrong PIN. Attempts left: " + (attemptsLeft - 1));
            } else {
                System.out.println("Card locked.");
            }
        }
        return false;
    }

    private static void menu() {
        System.out.println();
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Account tier");
        System.out.println("5. Savings projection");
        System.out.println("6. Receipt summary");
        System.out.println("7. Change PIN");
        System.out.println("0. Exit");
    }

    private static void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    private static void deposit() {
        double amount = readDouble("Enter deposit amount: ");
        if (amount <= 0 || amount > 5000) {
            System.out.println("Deposit must be greater than $0.00 and no more than $5,000.00.");
            return;
        }

        balance += amount;
        depositCount++;
        depositTotal += amount;
        System.out.printf("Deposit successful. Balance: %.2f%n", balance);
    }

    private static void withdraw() {
        double amount = readDouble("Enter withdrawal amount: ");
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than $0.00.");
            return;
        }
        if (amount % 10 != 0) {
            System.out.println("Withdrawal amount must be a multiple of $10.");
            return;
        }
        if (withdrawalTotal + amount > 1000) {
            System.out.println("Total withdrawals in one session cannot exceed $1,000.00.");
            return;
        }

        double fee = amount <= 500 ? 2.00 : 5.00;
        if (balance < amount + fee) {
            System.out.println("Insufficient balance to cover the withdrawal and fee.");
            return;
        }

        balance -= amount + fee;
        withdrawalCount++;
        withdrawalTotal += amount;
        System.out.printf("Fee: %.2f%n", fee);
        System.out.printf("Withdrawal successful. Balance: %.2f%n", balance);
    }

    private static int interestRateForBalance() {
        if (balance < 1000) {
            return 1;
        } else if (balance < 5000) {
            return 2;
        } else if (balance < 20000) {
            return 3;
        }
        return 4;
    }

    private static void accountTier() {
        int interestRate = interestRateForBalance();
        String tier;
        if (balance < 1000) {
            tier = "Bronze";
        } else if (balance < 5000) {
            tier = "Silver";
        } else if (balance < 20000) {
            tier = "Gold";
        } else {
            tier = "Platinum";
        }
        System.out.printf("Tier: %s, interest rate: %d%%%n", tier, interestRate);
    }

    private static void savingsProjection() {
        int years;
        do {
            years = readInt("Enter number of years (1-10): ");
            if (years < 1 || years > 10) {
                System.out.println("Please enter a number of years from 1 to 10.");
            }
        } while (years < 1 || years > 10);

        double projectedBalance = balance;
        double yearlyRate = interestRateForBalance() / 100.0;
        for (int year = 1; year <= years; year++) {
            projectedBalance *= 1 + yearlyRate;
            System.out.printf("Year %d: %.2f%n", year, projectedBalance);
        }
    }

    private static void receiptSummary() {
        System.out.printf("Deposits: %d, total: %.2f%n", depositCount, depositTotal);
        System.out.printf("Withdrawals: %d, total: %.2f%n", withdrawalCount, withdrawalTotal);
        System.out.printf("Balance: %.2f%n", balance);
    }

    private static void changePin() {
        int oldPin = readInt("Enter old PIN: ");
        if (oldPin != pin) {
            System.out.println("Incorrect old PIN. PIN was not changed.");
            return;
        }

        int newPin = readInt("Enter new 4-digit PIN: ");
        if (newPin < 1000 || newPin > 9999) {
            System.out.println("New PIN must be a 4-digit number.");
            return;
        }

        int confirmation = readInt("Confirm new PIN: ");
        if (newPin != confirmation) {
            System.out.println("PIN entries do not match. PIN was not changed.");
            return;
        }

        pin = newPin;
        System.out.println("PIN changed successfully.");
    }

    private static void runMenu() {
        int choice;
        do {
            menu();
            choice = readInt("Choose an option: ");
            switch (choice) {
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
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        try {
            if (login()) {
                runMenu();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Input ended. Exiting.");
        }
    }
}
