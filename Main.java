import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter bank name: ");
        String bankName = scanner.nextLine();
        Bank bankSystem = new Bank(bankName);

        while (true) {
            System.out.println("Welcome to " + bankSystem.getBankName() + "!");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Print Transactions");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter owner name: ");
                String ownerName = scanner.next();
                System.out.print("Is it a credit account? (true/false): ");
                boolean isCreditAccount = scanner.nextBoolean();
                if (isCreditAccount) {
                    System.out.print("Enter credit limit: ");
                    double creditLimit = scanner.nextDouble();
                    System.out.print("Enter interest rate: ");
                    double interestRate = scanner.nextDouble();
                    bankSystem.createAccount(ownerName, isCreditAccount, creditLimit, interestRate);
                } else {
                    bankSystem.createAccount(ownerName, false, 0, 0);
                }
            } else if (choice == 2) {
                System.out.print("Enter account number: ");
                int accountNumber = scanner.nextInt();
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                bankSystem.deposit(accountNumber, amount);
            } else if (choice == 3) {
                System.out.print("Enter account number: ");
                int accountNumber = scanner.nextInt();
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                bankSystem.withdraw(accountNumber, amount);
            } else if (choice == 4) {
                System.out.print("Enter from account number: ");
                int fromAccountNumber = scanner.nextInt();
                System.out.print("Enter to account number: ");
                int toAccountNumber = scanner.nextInt();
                System.out.print("Enter amount to transfer: ");
                double amount = scanner.nextDouble();
                bankSystem.transfer(fromAccountNumber, toAccountNumber, amount);
            } else if (choice == 5) {
                System.out.print("Enter account number: ");
                int accountNumber = scanner.nextInt();
                bankSystem.printBalance(accountNumber);
            } else if (choice == 6) {
                System.out.print("Enter account number: ");
                int accountNumber = scanner.nextInt();
                bankSystem.printTransactions(accountNumber);
            } else if (choice == 7) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
