package fel_2;

import fel_3.DateUtil;

import javax.swing.plaf.IconUIResource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrintStream out = null;
        try {
            out = new PrintStream("lab10_warnings.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Can't create file");
            e.printStackTrace();
        }
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("lab10_students.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String[] items = scanner.nextLine().split(",");
            if (items.length < 7) {
                out.println("Incomplete line");
                continue;
            }
            String neptunId = items[0].trim();
            String firstName = items[1].trim();
            String lastName = items[2].trim();
            int credits = -1, year = -1, month = -1, day = -1;
            try {
                credits = Integer.parseInt(items[3].trim());
            } catch (NumberFormatException e) {
                out.println("Number format exception: " + items[3].trim());
                continue;
            }
            try {
                year = Integer.parseInt(items[4].trim());
            } catch (NumberFormatException e) {
                out.println("Number format exception: " + items[4].trim());
                continue;
            }
            try {
                month = Integer.parseInt(items[5].trim());
            } catch (NumberFormatException e) {
                out.println("Number format exception: " + items[5].trim());
                continue;
            }
            try {
                day = Integer.parseInt(items[6].trim());
            } catch (NumberFormatException e) {
                out.println("Number format exception: " + items[6].trim());
                continue;
            }
            if (!DateUtil.isValidDate(year, month, day)) {
                out.println("Invalid date: " + year + " " + month + " " + day);
                continue;
            }
            if (credits < 30) {
                out.println(credits);
                continue;
            }
        }
        scanner.close();
        out.close();
    }
}
