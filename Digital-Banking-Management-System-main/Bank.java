package BankApplication;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Bank  {
	public static Scanner scanner = new Scanner(System.in);
	public static Map<String, BankAccount> accounts = new HashMap<>();
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to Eppudra Bank....");
            System.out.println("1.Create Account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Check Balance");
            System.out.println("5.Transfer");
            System.out.println("6.Transaction History");
            System.out.println("7.Delete Account");
            System.out.println("8.Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    transfer();
                    break;
                case 6:
                    showTransactionHistory();
                    break;
                case 7:
                    deleteAccount();
                    break;
                case 8:
                	running = false;
                    System.out.println("Thank you for using the Bank.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account number: ");
        String number = scanner.nextLine();
        accounts.put(number, new BankAccount(name, number));
        System.out.println("Account created successfully.");
        System.out.println("Thank You For Choosing Us..");
    }
    public static void deposit() {
        System.out.print("Enter account number: ");
        String number = scanner.nextLine();
        BankAccount account = accounts.get(number);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }
    public static void withdraw() {
        System.out.print("Enter account number: ");
        String number = scanner.nextLine();
        BankAccount account = accounts.get(number);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }
    public static void checkBalance() {
        System.out.print("Enter account number: ");
        String number = scanner.nextLine();
        BankAccount account = accounts.get(number);
        if (account != null) {
            account.displayBalance();
        } else {
            System.out.println("Account not found.");
        }
    }
    public static void transfer() {
        System.out.print("Enter source account number: ");
        String sourceNumber = scanner.nextLine();
        BankAccount sourceAccount = accounts.get(sourceNumber);
        if (sourceAccount == null) {
            System.out.println("Source account not found.");
            return;
        }
        System.out.print("Enter destination account number: ");
        String destinationNumber = scanner.nextLine();
        BankAccount destinationAccount = accounts.get(destinationNumber);
        if (destinationAccount == null) {
            System.out.println("Destination account not found.");
            return;
        }
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        if (sourceAccount.transfer(destinationAccount, amount)) {
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed. Check balances and try again.");
        }
    }
    public static void showTransactionHistory() {
        System.out.print("Enter account number: ");
        String number = scanner.nextLine();
        BankAccount account = accounts.get(number);
        if (account != null) {
            account.printTransactionHistory();
        } else {
            System.out.println("Account not found.");
        }
    }
    public static void deleteAccount() {
        System.out.print("Enter account number: ");
        String number = scanner.nextLine();
        if (accounts.containsKey(number)) {
            accounts.remove(number);
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }
}