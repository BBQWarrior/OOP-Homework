package fel_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Storage {
    private HashMap<Integer, Product> products = new HashMap<>();

    public Storage(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] items = scanner.nextLine().split(" ");
                int id = Integer.parseInt(items[0].trim());
                String name = items[1].trim();
                int amount = Integer.parseInt(items[2].trim());
                int value = Integer.parseInt(items[3].trim());
                products.put(id, new Product(id, name, amount, value));
            }
            System.out.println("Size: " + products.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void update(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int counter = 0;
            while (scanner.hasNextLine()) {
                String[] items = scanner.nextLine().split(" ");
                int id = Integer.parseInt(items[0].trim());
                int amount = Integer.parseInt(items[1].trim());
                Product temp = products.get(id);
                if (temp != null) {
                    temp.increaseAmount(amount);
                    counter++;
                }
            }
            System.out.println("Updates: " + counter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
