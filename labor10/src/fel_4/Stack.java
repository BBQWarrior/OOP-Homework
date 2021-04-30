package fel_4;

import java.util.ArrayList;

public class Stack {
    private int capacity;
    private ArrayList<Object> items = new ArrayList<>();

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public void push(Object obj) throws StackException {
        if (items.size() == capacity) {
            throw new StackException("Stack is full!");
        }
        items.add(obj);
    }

    public void pop() throws StackException {
        if (items.size() == 0) {
            throw new StackException("Stack is empty!");
        }
        items.remove(items.size() - 1);
    }

    public Object top() throws StackException {
        if (items.size() == 0) {
            throw new StackException("Stack is empty!");
        }
        return items.get(items.size() - 1);
    }

    public int getSize() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }

    public boolean isFull() {
        return items.size() == capacity;
    }
}
