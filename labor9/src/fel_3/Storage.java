package fel_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private ArrayList<Product> items = new ArrayList<>();

    public Storage(String path) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        while (scanner.hasNextLine()) {
            String[] fields = scanner.nextLine().split(" ");
            items.add(new Product(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3])));
        }
    }

    public void update(String path) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        int updatedItems = 0;
        while (scanner.hasNextLine()) {
            String[] fields = scanner.nextLine().split(" ");
            int id = Integer.parseInt(fields[0]);
            int newAmount = Integer.parseInt(fields[1]);

            for (Product product : items) {
                if (product.getID() == id) {
                    updatedItems++;
                    product.increaseAmount(newAmount);
                    break;
                }
            }
        }
        System.out.println("Updated " + updatedItems + " items");
    }
}
