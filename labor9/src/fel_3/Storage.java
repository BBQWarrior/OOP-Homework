package fel_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private ArrayList<Product> items = new ArrayList<>();

    private int binarySearchPlace(int id) {
        int start = 0, end = items.size();
        int mid = -1;
        while (start < end) {
            mid = (start + end) / 2;
            if (items.get(mid).getID() == id) {
                return mid;
            } else if (items.get(mid).getID() < id) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private Product binarySearch(int id) {
        int start = 0, end = items.size();
        while (start < end) {
            int mid = (start + end) / 2;
            if (items.get(mid).getID() == id) {
                return items.get(mid);
            } else if (items.get(mid).getID() < id) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return null;
    }

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
            items.add(binarySearchPlace(Integer.parseInt(fields[0])), new Product(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3])));
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
            Product temp = binarySearch(id);
            if (temp != null) {
                updatedItems++;
                temp.increaseAmount(newAmount);
            }
        }
        System.out.println("Updated " + updatedItems + " items");
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (Product item : items) {
            result.append(item.getID() + "\n");
        }
        return result.toString();
    }
}
