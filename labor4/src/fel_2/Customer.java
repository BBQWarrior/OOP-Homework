package fel_2;

import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Customer(String firstName, String lastName){
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
        for(BankAccount account : accounts){
            if(account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

    public int getNumAccounts(){
        return accounts.size();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void closeAccount(String accountNumber){
        for(int i=0;i< accounts.size();i++){
            if(accounts.get(i).getAccountNumber().equals(accountNumber)){
                accounts.remove(i);
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(firstName+' ' +lastName + " accounts:\n");
        for(BankAccount account : accounts){
            result.append("\t" + account + "\n");
        }
        return result.toString();
    }
}
