package fel_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
        this.elements = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            this.elements[i] = arr.elements[i];
        }
    }

    public MyArray(double[] arr) {
        this.length = arr.length;
        this.elements = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            this.elements[i] = arr[i];
        }
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
        if (length == 0) {
            return Double.NaN;
        }
        double sum = 0;
        for (int i = 0; i < length; i++) {
            sum += elements[i];
        }
        return (double) sum / length;
    }

    public double stddev() {
        if (length == 0) {
            return Double.NaN;
        }
        double mean = this.mean();
        double sum = 0;
        for (int i = 0; i < length; i++) {
            sum += (elements[i] - mean) * (elements[i] - mean);
        }
        return Math.sqrt(sum / length);
    }

    public void sort() {
        Arrays.sort(elements);
    }

    public void print(String arrName) {
        System.out.print(arrName + ":");
        for (double num : elements) {
            System.out.printf("%7.2f", num);
        }
        System.out.print("\n");
    }
}
