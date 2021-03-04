package fel_2;

import fel_1.BankAccount;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Customer first = new Customer("Fi", "Rst");
        Customer second = new Customer("Seco", "Nd");

        first.addAccount(new BankAccount("B001"));
        first.addAccount(new BankAccount("B002"));
        first.addAccount(new BankAccount("B003"));
        first.addAccount(new BankAccount("B004"));
        first.addAccount(new BankAccount("B005"));

        second.addAccount(new BankAccount("B101"));
        second.addAccount(new BankAccount("B102"));
        second.addAccount(new BankAccount("B103"));
        second.addAccount(new BankAccount("B104"));
        second.addAccount(new BankAccount("B105"));
        second.addAccount(new BankAccount("B106"));
        second.addAccount(new BankAccount("B107"));
        second.addAccount(new BankAccount("B108"));
        second.addAccount(new BankAccount("B109"));

        System.out.println(first);
        System.out.println(second);

        Random rand = new Random();

        for (int i = 1; i <= first.getNumAccounts(); i++) {
            first.getAccount("B00" + i).deposit(rand.nextInt(2000));
        }

        for (int i = 1; i <= second.getNumAccounts(); i++) {
            second.getAccount("B10" + i).deposit(rand.nextInt(2000));
        }

        first.closeAccount("B001");
        second.closeAccount("B109");

        System.out.println(first);
        System.out.println(second);
    }
}
