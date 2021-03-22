package fel_1;

import java.util.ArrayList;

public class Customer {
    private final int id;
    private static int numCustomers = 0;
    private String firstName;
    private String lastName;
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Customer(String firstName, String lastName) {
        numCustomers++;
        this.id = numCustomers;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
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

    public int getNumAccounts() {
        return accounts.size();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public String[] getAccountNumbers(){
        String[] res = new String[getNumAccounts()];
        for(int i=0;i<getNumAccounts();i++){
            res[i] = accounts.get(i).getAccountNumber();
        }
        return res;
    }

    public void closeAccount(String accountNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                accounts.remove(i);
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(id + ": " + firstName + ' ' + lastName + " accounts:\n");
        for (BankAccount account : accounts) {
            result.append("\t" + account + "\n");
        }
        return result.toString();
    }
}
