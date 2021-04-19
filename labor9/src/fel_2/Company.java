package fel_2;

import fel_1.MyDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Company {
    private String name;
    private ArrayList<Employee> employees;

    public Company(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(String path) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        while (scanner.hasNextLine()) {
            String[] items = scanner.nextLine().split(",");
            for (int i = 0; i < items.length; i++) {
                items[i] = items[i].trim();
            }
            if (items.length == 7) {
                /** Manager */
                employees.add(
                        new Manager(items[0],
                                items[1],
                                Integer.parseInt(items[2]),
                                new MyDate(Integer.parseInt(items[3]), Integer.parseInt(items[4]), Integer.parseInt(items[5])),
                                items[6]
                        ));
            } else {
                /** Employee */
                employees.add(
                        new Employee(items[0],
                                items[1],
                                Integer.parseInt(items[2]),
                                new MyDate(Integer.parseInt(items[3]), Integer.parseInt(items[4]), Integer.parseInt(items[5]))
                        ));
            }

        }
    }

    public void printAll() {
        printAll(System.out);
    }

    public void printAll(PrintStream out) {
        out.println(this.name);
        for (Employee employee : employees) {
            out.println(employee);
        }
    }

    public void sortByComparator(Comparator<Employee> comparator) {
        employees.sort(comparator);
    }
}
