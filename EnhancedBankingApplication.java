import java.util.ArrayList;
import java.util.Scanner;

public class EnhancedBankingApplication {
    private static double balance = 0.0;
    private static final ArrayList<String> transactionHistory = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Enhanced Banking Application!");

        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    showTransactionHistory();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for using the Enhanced Banking Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. View Transaction History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number between 1 and 5.");
            scanner.next(); // Clear the invalid input
            printMenu();
        }
        return scanner.nextInt();
    }

    private static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double depositAmount = getPositiveInput();
        balance += depositAmount;
        String transaction = "Deposited: $" + depositAmount;
        transactionHistory.add(transaction);
        System.out.println(transaction);
    }

    private static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = getPositiveInput();

        if (withdrawAmount <= balance) {
            balance -= withdrawAmount;
            String transaction = "Withdrew: $" + withdrawAmount;
            transactionHistory.add(transaction);
            System.out.println(transaction);
        } else {
            System.out.println("Insufficient balance! You only have $" + balance);
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    private static void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    private static double getPositiveInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a valid amount.");
            scanner.next(); // Clear the invalid input
        }
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero. Try again.");
            return getPositiveInput();
        }
        return amount;
    }
}
