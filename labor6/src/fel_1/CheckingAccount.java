package fel_1;

/** Folyoszamla */

public class CheckingAccount extends BankAccount{
    private double overdraftLimit; /**hitelkeret*/

    public CheckingAccount(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount){
        if (amount > balance + overdraftLimit) {
            return false;
        }
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", overdraftLimit=" + overdraftLimit +
                '}';
    }
}
