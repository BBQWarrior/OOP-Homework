
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) {
//	    System.out.println("Dave");
//        String Name = "Dave";
//        for(int i=0;i<Name.length();i++){
//            System.out.println(Name.charAt(i));
//        }
//        String m = "D" + "D";
//        System.out.println(m);

//  3 fel

//        String w = "almafa";
//        for(int i=0;i<w.length();i++){
//            for(int j=0;j<=i;j++){
//                System.out.print(w.charAt(j));
//            }
//            System.out.println();
//        }

// 4 fel

//        String sentence = "Process finished with exit code 0";
//        String[] words = sentence.split(" ");
//        String res = "";
//        for(String word : words){
//            res += word.charAt(0);
//        }
//        System.out.println(res);

//  II. 1 fel

//        double[] array = {1, 5, 6, 3, 4, 8, 1, 55, 5};
//        System.out.printf("MAX: %.2f", maxElement(array));

//  2 fel

//        int num = 13;
//        for (int i = 31; i >= 0; i--) {
//            System.out.print(getBit(num, i));
//        }

// 3 fel

//        System.out.print(countBits(13));

// 4 fel

//        double[] arr = {1, 2, 5, 3, 4, 9};
//        System.out.printf("Atlag: %.2f", mean(arr));

//  5 fel

//        double[] arr = {1, 2, 5, 3, 4, 9};
//        System.out.printf("Szoras: %.2f", stddev(arr));

//  6 fel

        double[] array = {1, 5, 6, 3, 4, 8, 1, 55, 5};
        double[] res = max2(array);
        System.out.printf("Max 1: %5.2f\n", res[0]);
        System.out.printf("Max 2: %5.2f\n", res[1]);
    }

    public static double maxElement(double[] array) {
        double max = Double.NEGATIVE_INFINITY;
        for (double number : array) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static int getBit(int number, int order) {
        if (order > 31 || order < 0) {
            return -1;
        }
        return (number >> order) & 1;
    }

    public static int countBits(int number) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (number >> i) & 1;
        }
        return res;
    }

    public static double mean(double[] array) {
        if (array == null || array.length == 0) {
            return Double.NaN;
        }
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        return sum / array.length;
    }

    public static double stddev(double[] array) {
        if (array == null || array.length == 0) {
            return Double.NaN;
        }
        double sum = 0;
        double mean_ = mean(array); // 4es feladat

        for (double num : array) {
            sum += pow(mean_ - num, 2);
        }
        return sqrt(sum / array.length);
    }

    public static double[] max2(double[] array) {
        double[] max = {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY};

        if (array == null || array.length == 0) {
            return max;
        }

        for (double num : array) {
            if (num > max[0]) {
                max[1] = max[0];
                max[0] = num;
            }
            else if(num > max[1]){
                max[1] = num;
            }
        }
        return max;
    }
}
