package fel_1;

public class Main {
    public static void main(String[] args){
        Customer c1 = new Customer("John", "Black");
        System.out.println(c1);
        c1.setAccount(new BankAccount("OTP00001"));
        System.out.println(c1);
        c1.getAccount().deposit(1000);
        System.out.println(c1);
        Customer c2 = new Customer("Mary", "White");
        c2.setAccount(new BankAccount(("OTP00002")));
        System.out.println(c2);
        c2.getAccount().deposit(1000);
        System.out.println(c2);
        c2.getAccount().withdraw(500);
        System.out.println(c2);
        c2.closeAccount();
        System.out.println(c2);
        c2.setAccount(c1.getAccount());
        System.out.println(c2);
    }
}
