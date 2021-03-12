package fel_3;

import org.ietf.jgss.GSSContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class MyArray {
    int length;
    double[] elements;

    public MyArray(int len) {
        this.length = len;
        this.elements = new double[len];
    }

    public MyArray(MyArray arr) {
        this.length = arr.length;
        this.elements = arr.elements;
    }

    public MyArray(double[] arr) {
        this.length = arr.length;
        this.elements = arr;
    }

    public MyArray(String fileName) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = scanner.nextLine();
        this.length = Integer.parseInt(line);
        this.elements = new double[this.length];
        line = scanner.nextLine();
        String[] items = line.split(" ");
        for (int i = 0; i < this.length; i++) {
            this.elements[i] = Integer.parseInt(items[i]);
        }
    }

    public void fillRandom(int a, int b) {
        if (a > b) {
            return;
        }
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            elements[i] = random.nextInt(b - a) + a;
        }
    }

    public double mean() {
        double sum = 0;
        for (int i = 0; i < length; i++) {
            sum += elements[i];
        }
        return (double) sum / length;
    }

    public double stddev() {
        double mean = this.mean();
        double sum = 0;
        for (int i = 0; i < length; i++) {
            sum += (elements[i] - mean) * (elements[i] - mean);
        }
        return Math.sqrt(sum / length);
    }

    public void sort() {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (elements[i] > elements[j]) {
                    double aux = elements[j];
                    elements[j] = elements[i];
                    elements[i] = aux;
                }
            }
        }
    }

    public void print(String arrName) {
        System.out.print(arrName + ":");
        for (double num : elements) {
            System.out.printf("%7.2f", num);
        }
        System.out.print("\n");
    }
}
