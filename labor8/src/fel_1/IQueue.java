package fel_1;

public interface IQueue {
    public boolean isEmpty();
    public boolean isFull();
    public void enQueue(Object obj);
    public Object deQueue();
    public void printQueue();
    public boolean equals(Object obj);
}
