package fel_1;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer getCustomer(int id) {
        for (Customer customer : customers) {
            if (id == customer.getId()) {
                return customer;
            }
        }
        return null;
    }

    public int numCustomers() {
        return customers.size();
    }

    private void printCustomers(PrintStream out) {
        out.println("ID, Firstname, Last name, Number of bank accounts");
        for (Customer customer : customers) {
            out.println(customer.getId() + ", " + customer.getFirstName() + ", " + customer.getLastName() + ", " + customer.getNumAccounts());
        }
    }

    public void printCustomersToFile(String filename) {
        try {
            printCustomers(new PrintStream(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printCustomersToStdout() {
        printCustomers(System.out);
    }
}
