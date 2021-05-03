package fel_1;

public class Main {
    static int arrayWritten = 300;

    public static void main(String[] args) {
        String[] sa_array = new String[10];
        for (int i = 0; i < sa_array.length; i++) {
            sa_array[i] = " ";
        }

        Thread producer = new AddToArray(sa_array);
        Thread consumer = new TakeSomeFromArray(sa_array, "zzz", 10);
        producer.start();
        consumer.start();
    }
}
