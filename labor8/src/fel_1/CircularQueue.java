package fel_1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class CircularQueue implements IQueue {
    private final int CAPACITY;
    private Object[] items;
    private int front = -1;
    private int rear = -1;

    public CircularQueue(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        this.items = new Object[CAPACITY];

    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public boolean isFull() {
        if (front == 0 && rear == CAPACITY - 1) {
            return true;
        }
        return front == (rear + 1);
    }

    @Override
    public void enQueue(Object obj) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % CAPACITY;
        items[rear] = obj;
    }

    @Override
    public Object deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        int oldFront = front;
        if (front == rear) {
            front = -1;
            rear = -1;
            return items[oldFront];
        }
        front = (front + 1) % CAPACITY;
        return items[oldFront];
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(items[i] + ", ");
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
        CircularQueue temp = (CircularQueue) obj;
        return Objects.equals(items, temp.items);
    }
}
