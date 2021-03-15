package fel_1;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("OTP");
        bank.addCustomer(new Customer("Hank", "Green"));
        bank.addCustomer(new Customer("John", "Green"));
        bank.getCustomer(1).addAccount(new BankAccount());
        bank.getCustomer(1).addAccount(new BankAccount());
        bank.getCustomer(2).addAccount(new BankAccount());
        bank.getCustomer(2).addAccount(new BankAccount());
        System.out.println(bank.getCustomer(1));
        bank.getCustomer(1).getAccount("OTP0000001").deposit(1000);
        bank.getCustomer(1).getAccount("OTP0000002").deposit(500);
        bank.getCustomer(2).getAccount("OTP0000003").deposit(1200);
        bank.getCustomer(2).getAccount("OTP0000004").deposit(100);
        System.out.println(bank.getCustomer(2));
        bank.printCustomersToFile("bank_customers.csv");
    }
}
