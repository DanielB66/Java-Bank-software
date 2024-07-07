import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<RegularAccount> accounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        accounts = new ArrayList<RegularAccount>();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void createAccount(String ownerName, boolean isCreditAccount, double creditLimit, double interestRate) {
    	RegularAccount account;
        if (isCreditAccount) {
            account = new CreditAccount(ownerName, creditLimit, interestRate);
        } else {
            account = new RegularAccount(ownerName);
        }
        accounts.add(account);
        System.out.println("Account created successfully. Account number: " + account.getAccountNumber());
    }

    public void deposit(int accountNumber, double amount) {
    	RegularAccount account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
    	RegularAccount account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
    	RegularAccount fromAccount = findAccount(fromAccountNumber);
    	RegularAccount toAccount = findAccount(toAccountNumber);
        if (fromAccount != null && toAccount != null) {
            fromAccount.transfer(amount, toAccount);
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    public void printBalance(int accountNumber) {
    	RegularAccount account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Account balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void printTransactions(int accountNumber) {
    	RegularAccount account = findAccount(accountNumber);
        if (account != null) {
            account.printTransactions();
        } else {
            System.out.println("Account not found.");
        }
    }

    private RegularAccount findAccount(int accountNumber) {
        for (RegularAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}
