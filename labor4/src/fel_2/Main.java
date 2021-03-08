package fel_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        customers = readFile("lab4_2_input.txt");
        for(Customer customer : customers){
            System.out.println(customer);
        }
    }

    public static ArrayList<Customer> readFile(String fileName) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Customer> customers = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] items = line.split(",");
            String type = items[0].trim();
            if (type.equals("Customer")) {
                customers.add(new Customer(items[1].trim(), items[2].trim()));
            } else if (type.equals("Account")) {
                String accountNumber = items[1].trim();
                customers.get(customers.size() - 1).addAccount(new BankAccount(accountNumber));
                customers.get(customers.size() - 1).getAccount(accountNumber).deposit(Double.parseDouble(items[2].trim()));
            }
        }
        return customers;
    }
}
