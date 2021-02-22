package fel_1;

public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("OTP00001");
        System.out.println(account.toString());
        account.deposit(1000);
        System.out.println("Deposit 1000");
        System.out.println(account.toString());
        boolean result = account.withdraw(500);
        if(!result){
            System.out.println("You do not have sufficient funds forthis operation!");
        }
        System.out.println(account.toString());
        result = account.withdraw(1000);
        if(!result){
            System.out.println("You do not have sufficient funds for this operation!");
        }
        System.out.println(account.toString());

        BankAccount account2 = new BankAccount("OTP00002");
        System.out.println(account2.toString());
        account2.deposit(2000);
        System.out.println(account2.toString());
    }
}
