package fel_3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int invalid = 0;
        for (int i = 0; i < 1000; i++) {
            MyDate temp = new MyDate(2100 - rand.nextInt(2500), rand.nextInt(20), rand.nextInt(50));
            if (temp.getDay() == 0) {
                invalid++;
            } else {
                System.out.println(temp.toString());
            }
        }
        System.out.println("Nr. of invalid dates: " + invalid);
    }
}
