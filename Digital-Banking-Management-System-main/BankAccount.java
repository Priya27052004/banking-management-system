package BankApplication;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;
    public List<String> transactionHistory = new ArrayList<>();
    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        recordTransaction("Account created with initial balance 0.0");
    }
    //deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance =balance+amount;
            recordTransaction("Deposited: " + amount);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    //withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recordTransaction("Withdrew: " + amount);
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance");
        }
    }
    //display balance
    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
    //transfer money to another account
    public boolean transfer(BankAccount destinationAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            destinationAccount.balance += amount;
            recordTransaction("Transferred: " + amount + " to account " + destinationAccount.accountNumber);
            destinationAccount.recordTransaction("Received: " + amount + " from account " + this.accountNumber);
            return true;
        }
        return false;
    }
    //record transactions
    public void recordTransaction(String transaction) {
        transactionHistory.add(transaction);
    }
    //print transaction history
    public void printTransactionHistory() {
        System.out.println("Transaction History for Account Number: " + accountNumber);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}