package fel_1;

import javax.sound.midi.Soundbank;

import static fel_1.Main.arrayWritten;

public class TakeSomeFromArray extends Thread {
    private final String[] array;
    private final String target;
    private final int times;

    public TakeSomeFromArray(String[] array, String target, int times) {
        this.array = array;
        this.target = target;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; ) {
            if (replaceTarget()) {
                System.out.println(Thread.currentThread().getName() + ": String \"" + target + "\" has been replaced with \" \"");
                i++;
                arrayWritten--;
                if(arrayWritten < 1){
                    System.out.println("Array has been modified " + arrayWritten + " times");
                    System.exit(0);
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + ": String \"" + target + "\" has been replaced " + times + " times, thread finished its work");
    }

    public boolean replaceTarget() {
        synchronized (array) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals(target)) {
                    array[i] = "";
                    return true;
                }
            }
        }
        return false;
    }
}
