package fel_3;

public class Student implements Comparable<Student> {
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

    public int getId() {
        return id;
    }

    public void setHuLit(double huLit) {
        this.huLit = huLit;
    }

    public void setRoLit(double roLit) {
        this.roLit = roLit;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getAverage() {
        return (math + roLit + huLit) / 3;
    }

    public boolean passed() {
        return getAverage() >= 6 && math >= 5 && roLit >= 5 && huLit >= 5;
    }

    @Override
    public int compareTo(Student other) {
        if (this.lastName.equals(other.lastName)) {
            return this.firstName.compareTo(other.firstName);
        }
        return this.lastName.compareTo(other.lastName);
    }

    @Override
    public String toString() {
        return id + " - " + firstName + " " + lastName +
                "\n\t Average: " + String.format("%5.2f", getAverage()) +
                "\n\t Math: " + String.format("%5.2f", math) +
                "\n\t Ro Lit: " + String.format("%5.2f", roLit) +
                "\n\t Hu Lit: " + String.format("%5.2f", huLit);
    }
}
