package fel_1;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger arrayWritten = new AtomicInteger(300);

    public static void main(String[] args) {
        String[] sa_array = new String[10];
        for (int i = 0; i < sa_array.length; i++) {
            sa_array[i] = " ";
        }

        Thread producer_1 = new AddToArray(sa_array);
        Thread producer_2 = new AddToArray(sa_array);
        Thread producer_3 = new AddToArray(sa_array);
        Thread producer_4 = new AddToArray(sa_array);
        Thread consumer_1 = new TakeSomeFromArray(sa_array, "zzz", 10);
        Thread consumer_2 = new TakeSomeFromArray(sa_array, "zzz", 10);
        Thread consumer_3 = new TakeSomeFromArray(sa_array, "zzz", 10);
        producer_1.start();
        producer_2.start();
        producer_3.start();
        producer_4.start();
        consumer_1.start();
        consumer_2.start();
        consumer_3.start();
    }
}
