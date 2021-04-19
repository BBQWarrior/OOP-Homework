package fel_1;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        if (!DateUtil.isValidDate(year, month, day)) {
            return;
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return year + " - " + month + " - " + day;
    }

    @Override
    public int compareTo(MyDate other) {
        if (other.year < this.year) {
            return 1;
        }
        if (other.year > this.year) {
            return -1;
        }
        if (other.month < this.month) {
            return 1;
        }
        if (other.month > this.month) {
            return -1;
        }
        if (other.day < this.day) {
            return 1;
        }
        if (other.day > this.day) {
            return -1;
        }
        return 0;
    }
}
