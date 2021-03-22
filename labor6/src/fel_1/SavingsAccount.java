package fel_1;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(double interestRate) {
        /** BankAccount called automatically */
        this.interestRate = interestRate;
    }

    public void addInterest() {
        this.balance *= (1 + interestRate);
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", interestRate=" + interestRate +
                '}';
    }
}
