public class Test {
    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap();
        heap.insert(10);
        heap.insert(3);
        heap.insert(7);
        heap.insert(1);
        heap.insert(5);
        System.out.println("findMax (expected 10): " + heap.findMax());
        heap.printHeap();

        System.out.println("deleteMax (expected 10): " + heap.deleteMax());
        System.out.println("findMax after delete (expected 7): " + heap.findMax());
        heap.printHeap();

        int[] arr = {9, 4, 7, 2, 6, 3, 8};
        MaxHeap heap2 = new MaxHeap(arr);
        System.out.println("findMax after buildHeap (expected 9): " + heap2.findMax());
        heap2.printHeap();

        System.out.println("deleteMax (expected 9): " + heap2.deleteMax());
        System.out.println("deleteMax (expected 8): " + heap2.deleteMax());
        System.out.println("deleteMax (expected 7): " + heap2.deleteMax());
        heap2.printHeap();

        MaxHeap heap3 = new MaxHeap(3);
        heap3.insert(1);
        heap3.insert(2);
        heap3.insert(3);
        heap3.insert(4);
        heap3.insert(5);
        System.out.println("findMax after enlargeArray trigger (expected 5): " + heap3.findMax());
        heap3.printHeap();

        MaxHeap single = new MaxHeap();
        single.insert(42);
        System.out.println("deleteMax single element (expected 42): " + single.deleteMax());
        System.out.println("isEmpty after delete (expected true): " + single.isEmpty());

        try {
            heap.insert(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("insert exception (expected): " + e.getMessage());
        }

        try {
            heap.insert(0);
        } catch (IllegalArgumentException e) {
            System.out.println("insert 0 exception (expected): " + e.getMessage());
        }

        try {
            MaxHeap empty = new MaxHeap();
            empty.deleteMax();
        } catch (IllegalStateException e) {
            System.out.println("deleteMax on empty exception (expected): " + e.getMessage());
        }
    }
}
