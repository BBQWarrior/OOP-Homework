package fel_1;

public class BankAccount {
    protected double balance = 0;
    protected final String accountNumber;
    private static final String PREFIX = "OTP";
    public static final int ACCOUNT_NUMBER_LENGTH = 10;

    private static int numAccounts = 0;

    private static String generateAccountNumber() {
        numAccounts++;
        return String.format(PREFIX + "%0" + (ACCOUNT_NUMBER_LENGTH - PREFIX.length()) + "d", numAccounts);
    }

    protected BankAccount() {
        accountNumber = generateAccountNumber();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
