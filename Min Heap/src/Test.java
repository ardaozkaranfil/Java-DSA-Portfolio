import java.util.NoSuchElementException;

public class Test{
    public static void main(String[] args) {

        MinHeap heap = new MinHeap();
        heap.insert(10);
        heap.insert(3);
        heap.insert(7);
        heap.insert(1);
        heap.insert(5);
        System.out.println("findMin (expected 1): " + heap.findMin());
        heap.printHeap();

        System.out.println("deleteMin (expected 1): " + heap.deleteMin());
        System.out.println("findMin after delete (expected 3): " + heap.findMin());
        heap.printHeap();

        int[] arr = {9, 4, 7, 2, 6, 3, 8};
        MinHeap heap2 = new MinHeap(arr);
        System.out.println("findMin after buildHeap (expected 2): " + heap2.findMin());
        heap2.printHeap();

        MinHeap h1 = new MinHeap();
        h1.insert(1);
        System.out.println("height 1 node (expected 0): " + h1.getHeight());
        h1.insert(2);
        h1.insert(3);
        System.out.println("height 3 nodes (expected 1): " + h1.getHeight());
        h1.insert(4);
        h1.insert(5);
        h1.insert(6);
        h1.insert(7);
        System.out.println("height 7 nodes (expected 2): " + h1.getHeight());

        MinHeap h2 = new MinHeap();
        h2.insert(5); h2.insert(10); h2.insert(8);
        System.out.println("decreaseKey valid (expected true): " + h2.decreaseKey(2, 4));
        System.out.println("decreaseKey out of bounds (expected false): " + h2.decreaseKey(10, 1));
        System.out.println("decreaseKey bad amount (expected false): " + h2.decreaseKey(1, 0));
        System.out.println("decreaseKey result < 1 (expected false): " + h2.decreaseKey(1, 100));
        h2.printHeap();

        MinHeap h3 = new MinHeap();
        h3.insert(1); h3.insert(3); h3.insert(2);
        System.out.println("increaseKey valid (expected true): " + h3.increaseKey(1, 5));
        System.out.println("increaseKey out of bounds (expected false): " + h3.increaseKey(10, 1));
        System.out.println("increaseKey bad amount (expected false): " + h3.increaseKey(1, -1));
        h3.printHeap();

        MinHeap h4 = new MinHeap();
        h4.insert(1); h4.insert(4); h4.insert(2); h4.insert(8); h4.insert(6);
        System.out.println("delete valid (expected true): " + h4.delete(2));
        System.out.println("delete out of bounds (expected false): " + h4.delete(0));
        System.out.println("delete out of bounds (expected false): " + h4.delete(10));
        h4.printHeap();

        int[] valid   = {0, 1, 3, 2, 7, 5, 4};
        int[] invalid = {0, 5, 3, 2, 7, 1, 4};
        int[] tooShort = {0};
        System.out.println("isMinHeap valid (expected true): "   + heap.isMinHeap(valid));
        System.out.println("isMinHeap invalid (expected false): " + heap.isMinHeap(invalid));
        System.out.println("isMinHeap too short (expected false): " + heap.isMinHeap(tooShort));

        MinHeap h5 = new MinHeap();
        h5.insert(2); h5.insert(6); h5.insert(4);
        MinHeap h6 = new MinHeap();
        h6.insert(1); h6.insert(5); h6.insert(3);
        System.out.println("mergeHeaps (expected true): " + h5.mergeHeaps(h6));
        System.out.println("findMin after merge (expected 1): " + h5.findMin());
        h5.printHeap();

        MinHeap empty = new MinHeap();
        System.out.println("mergeHeaps with empty (expected false): " + h5.mergeHeaps(empty));

        try {
            heap.insert(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("insert exception (expected): " + e.getMessage());
        }

        try {
            empty.deleteMin();
        } catch (NoSuchElementException e) {
            System.out.println("deleteMin exception (expected): " + e.getMessage());
        }

        try {
            empty.getHeight();
        } catch (NoSuchElementException e) {
            System.out.println("getHeight exception (expected): " + e.getMessage());
        }
    }
}