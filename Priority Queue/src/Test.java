import java.util.NoSuchElementException;

public class Test {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        pq.enqueue(3, "C");
        pq.enqueue(1, "A");
        pq.enqueue(2, "B");
        pq.enqueue(2, "D");
        pq.enqueue(0, "X");
        pq.printQueue();

        System.out.println(pq.findPlace("D"));
        System.out.println(pq.findPlace("A"));

        pq.promote("C");
        pq.printQueue();

        pq.promote("A");
        pq.printQueue();

        System.out.println(pq.dequeue());
        pq.printQueue();

        try {
            pq.findPlace("Z");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}