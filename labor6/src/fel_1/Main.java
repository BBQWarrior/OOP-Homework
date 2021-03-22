package fel_1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Bank otp = new Bank("OTP");
        otp.addCustomer(new Customer("Hank", "Green"));
        otp.addCustomer(new Customer("John", "Green"));
        otp.getCustomer(1).addAccount(new CheckingAccount(500));
        otp.getCustomer(1).addAccount(new SavingsAccount(0.1));
        otp.getCustomer(2).addAccount(new CheckingAccount(700));
        otp.getCustomer(2).addAccount(new SavingsAccount(0.1));

        Random rand = new Random();
        for (int i = 0; i < otp.numCustomers(); ++i) {
            String[] accountNumbers = otp.getCustomer(i).getAccountNumbers();
            for (String accountNumber : accountNumbers) {
                otp.getCustomer(i).getAccount(accountNumber).deposit(rand.nextInt(1000));
            }
        }

        otp.printCustomersToStdout();
    }
}
