package fel_2;

import fel_3.MyDate;

public class Student {
    private final String neptunId;
    private final String firstName;
    private final String lastName;

    private int credits;
    private MyDate birthday;

    public Student(String neptunId, String firstName, String lastName, int credits, int year, int month, int day) {
        this.neptunId = neptunId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credits = credits;
        this.birthday = new MyDate(year, month, day);
    }
}
