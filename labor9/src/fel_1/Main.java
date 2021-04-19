package fel_1;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<MyDate> array = new ArrayList<>();
        Random rand = new Random();
        while (array.size() < 10) {
            int day = rand.nextInt(31);
            int month = rand.nextInt(13);
            if (DateUtil.isValidDate(2021, month, day)) {
                array.add(new MyDate(2021, month, day));
            }
        }
        for (MyDate date : array) {
            System.out.println(date);
        }
        array.sort(MyDate::compareTo);
        System.out.println("Sorted");
        for (MyDate date : array) {
            System.out.println(date);
        }
    }
}
