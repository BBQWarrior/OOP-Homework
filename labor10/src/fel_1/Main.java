package fel_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(" ");
        double sum = 0;
        for(String item : items){
            try{
                sum += Double.parseDouble(item.trim());
            }catch (Exception e){
                System.out.println("Not a number: " + item);
            }
        }
        System.out.println("Sum: " + sum);
    }
}
