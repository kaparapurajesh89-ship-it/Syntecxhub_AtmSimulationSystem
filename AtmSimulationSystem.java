import java.util.Scanner;

class Account {

    private double balance;
    private int pin;

    Account(double balance, int pin) {
        this.balance = balance;
        this.pin = pin;
    }

    // Check PIN
    boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    // Check Balance
    double getBalance() {
        return balance;
    }

    // Deposit Money
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposit Successful!");
    }

    // Withdraw Money
    void withdraw(double amount) {

        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Please collect your cash.");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}

class ATM {

    private UserAccount account;
    private Scanner sc;

        ATM(UserAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

       void start() {

        System.out.println("====== ATM SIMULATION SYSTEM ======");

        System.out.print("Enter 4-digit PIN: ");
     int enteredPin = sc.nextInt();

        if (account.verifyPin(enteredPin)) {

            System.out.println("Login Successful!");

            int choice;

            do {

                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("Current Balance: Rs." + account.getBalance());
                        break;

                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;

                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;

                    case 4:
                        System.out.println("Thank You for using ATM!");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } while (choice != 4);

        } else {

            System.out.println("Incorrect PIN!");
        }
    }
}

public class AtmSimulationSystem {

    public static void main(String[] args) {
        UserAccount user = new UserAccount(10000, 1234);

          ATM atm = new ATM(user);

         atm.start();
    }
}