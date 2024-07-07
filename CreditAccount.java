import java.sql.Time;

public class CreditAccount extends RegularAccount {
    private double creditLimit;
    private double interestRate;

    public double getCreditLimit() {
		return creditLimit;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public CreditAccount(String ownerName, double creditLimit, double interestRate) {
        super(ownerName);
        setCreditLimit(creditLimit);
        setInterestRate(interestRate);
    }
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance + creditLimit) {
            balance -= amount;
            transactions.add(new Transaction(new Time(System.currentTimeMillis()), "W", amount));
            System.out.println("Withdrew " + amount + " successfully.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
    @Override
    public void transfer(double amount, RegularAccount toAccount) {
        if (amount > 0 && amount <= balance + creditLimit) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            transactions.add(new Transaction(new Time(System.currentTimeMillis()), "T", amount));
            System.out.println("Transferred " + amount + " to account number " + toAccount.getAccountNumber() + " successfully.");
        } else {
            System.out.println("Invalid transfer amount or insufficient balance.");
        }
    }
    @Override
    public double getBalance() {
		return creditLimit + balance;
    }
    
}

