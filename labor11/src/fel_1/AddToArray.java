package fel_1;

import java.util.Random;

import static fel_1.Main.arrayWritten;

public class AddToArray extends Thread {
    private final String[] array;

    public AddToArray(String[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int num = random.nextInt(26);
            char ch = (char) (num + 97); /** a = 97 */
            String str = "" + ch + ch + ch;
            synchronized (array) {
                array[minIndex()] = str;
            }
            arrayWritten--;
            if(arrayWritten < 1){;
                System.exit(0);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print();
        }
    }

    public int minIndex() {
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(array[min]) < 0) {
                min = i;
            }
        }
        return min;
    }

    public void print() {
        System.out.print(Thread.currentThread().getName() + ": ");
        for (String s : array) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
