package fel_2;

import java.util.Random;

public class Main {
    public static void main(String[] args){
        Rectangle[] rectangles = new Rectangle[10];
        Random rand = new Random();
        for(int i=0;i<10;i++){
            rectangles[i] = new Rectangle(1 + rand.nextInt(10), 1 + rand.nextInt(10));
        }
        double totalArea = 0;
        for(Rectangle rect : rectangles){
            System.out.println( rect.toString() + " Area: " + rect.area() + " Perimeter: " + rect.perimeter() );
            totalArea += rect.area();
        }
        System.out.println(totalArea);
    }
}
