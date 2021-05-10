package fel_3;

public class Student {
    private final int id;

    private String firstName;
    private String lastName;

    private double huLit;
    private double roLit;
    private double math;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
