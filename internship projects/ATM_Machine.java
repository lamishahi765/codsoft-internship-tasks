import java.util.Scanner;

class BankAccount {
    private double balance = 0;

    public BankAccount(double initialBalance) {

        this.balance = initialBalance;

    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposite of INR :" + amount + "Successful.current balance :INR" + balance);

        } else {
            System.out.println("Invalid Amount!");
        }
    }

    public void Withdrawl(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawl of INR :" + amount + "Successful.current balance :INR" + balance);

        } else {
            System.out.println("INSUFFICIENT BALANCE !");

        }
    }

}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void DisplayMenu() {
        System.out.println("ATM Menu :");
        System.out.println("1.Check Balance ");
        System.out.println("2.Deposit");
        System.out.println("3.Withdraw");
        System.out.println("4.Exit");
    }

    public void performTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("Current balance : INR" + bankAccount.getBalance());
                break;
            case 2:
                System.out.print(" Enter deposit amount: INR");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter Withdrawl amount : INR");
                double WithdrawlAmount = scanner.nextDouble();
                bankAccount.Withdrawl(WithdrawlAmount);
                break;
            case 4:
                System.out.println(" Exiting ATM.THANK YOU");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice ! please select  a  valid option");
        }
    }
}

public class ATM_Machine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance : INR");
        double initialBalance = sc.nextDouble();
        BankAccount bankAccount = new BankAccount(initialBalance);

        ATM atm = new ATM(bankAccount);

        while (true) {
            atm.DisplayMenu();
            System.out.print("Select a option :");
            int choice = sc.nextInt();

            atm.performTransaction(choice, sc);
        }
    }
}