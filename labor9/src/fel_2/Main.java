package fel_2;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Company test = new Company("Comp");
        test.hireAll("lab9_2_input.csv");
        test.printAll();
        test.sortByComparator(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getFirstName().equals(o2.getFirstName())) {
                    return o1.getLastName().compareTo(o2.getLastName());
                }
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
        System.out.println("\nSorted:");
        test.printAll();
    }
}
