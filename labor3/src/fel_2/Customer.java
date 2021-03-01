package fel_2;

import fel_1.BankAccount;

public class Customer {
    public static final int MAX_ACCOUNTS = 10;

    private String firstName;
    private String lastName;
    private BankAccount[] accounts = new BankAccount[MAX_ACCOUNTS];
    private int numAccounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addAccount(BankAccount account) {
        if (account == null) {
            return;
        }
        if (numAccounts == MAX_ACCOUNTS) {
            return;
        }
        this.accounts[numAccounts] = account;
        numAccounts++;
    }

    public void closeAccount(String accountNumber) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                numAccounts--;
                accounts[i] = accounts[numAccounts];
                accounts[numAccounts] = null;
            }
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", account=" + accounts +
                '}';
    }
}
