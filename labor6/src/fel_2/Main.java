package fel_2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String str = "name name";
        StackAggregation stack1 = new StackAggregation(str.length());

        for(char c : str.toCharArray()){
            stack1.push(c);
        }
        while (!stack1.isEmpty()){
            System.out.print(stack1.top());
            stack1.pop();
        }
        System.out.println();
        
        StackAggregation stack2 = new StackAggregation(10);
        Random rand = new Random();
        for(int i=0;i<13;i++){
            int temp = rand.nextInt(1000);
            System.out.print(temp + ", ");
            stack2.push(temp);
        }
        System.out.println();

        while (!stack2.isEmpty()){
            System.out.print(stack2.top() + " ");
            stack2.pop();
        }
        System.out.println();
    }
}
