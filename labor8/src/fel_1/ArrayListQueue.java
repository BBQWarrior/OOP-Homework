package fel_1;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListQueue implements IQueue {
    private final int CAPACITY;
    private ArrayList<Object> items;

    public ArrayListQueue(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        this.items = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean isFull() {
        return items.size() == CAPACITY;
    }

    @Override
    public void enQueue(Object obj) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        items.add(obj);
    }

    @Override
    public Object deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return items.remove(0);
    }

    @Override
    public void printQueue() {
        for (Object item : items) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ArrayListQueue temp = (ArrayListQueue) obj;
        return Objects.equals(items, temp.items);
    }
}
