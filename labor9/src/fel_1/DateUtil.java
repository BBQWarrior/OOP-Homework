package fel_1;

public class DateUtil {
    public static boolean leapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year <= 0) {
            return false;
        }
        if (month <= 0 || month > 12) {
            return false;
        }
        if (day < 1) {
            return false;
        }
        //February
        if (month == 2) {
            if (day > 29) {
                return false;
            }
            if (day == 29) {
                return leapYear(year);
            }
            return true;
        }
        int[] longMonths = {1, 3, 5, 7, 8, 10, 12};
        for (int tempMonth : longMonths) {
            if (month == tempMonth) {
                if (day > 31) {
                    return false;
                }
                return true;
            }
        }
        if (day > 30) {
            return false;
        }
        return true;
    }
}
