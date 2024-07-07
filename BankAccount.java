// דניאל בן עמי ת.ז 313577140

public abstract class BankAccount {
    private static int nextAccountNumber = 1000;
    
    protected int accountNumber;
    protected String ownerName;
    protected double balance;
    
	public int getAccountNumber() {
		return accountNumber;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setAccountNumber() {
		this.accountNumber = nextAccountNumber++;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public BankAccount(String ownerName) {
		setAccountNumber();
		this.ownerName = ownerName;
		this.balance = 0;
	}
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}
	@Override
	public boolean equals(Object obj) {
		return obj instanceof BankAccount && ((BankAccount)obj).accountNumber == this.accountNumber;
	}
    
}
