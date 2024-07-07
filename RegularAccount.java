import java.sql.Time;
import java.util.ArrayList;

public class RegularAccount extends BankAccount {
    protected ArrayList<Transaction> transactions;
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction(new Time(System.currentTimeMillis()), "D", amount));
            System.out.println("Deposited " + amount + " successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction(new Time(System.currentTimeMillis()), "W", amount));
            System.out.println("Withdrew " + amount + " successfully.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
    public void transfer(double amount, RegularAccount toAccount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            transactions.add(new Transaction(new Time(System.currentTimeMillis()), "T", amount));
            System.out.println("Transferred " + amount + " to account number " + toAccount.getAccountNumber() + " successfully.");
        } else {
            System.out.println("Invalid transfer amount or insufficient balance.");
        }
    }
    public void printTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
	public RegularAccount(String ownerName) {
		super(ownerName);
		this.transactions = new ArrayList<Transaction>();
	}
	
}
