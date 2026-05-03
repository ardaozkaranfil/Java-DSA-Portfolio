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

        int[] unsorted1 = {5, 3, 8, 1, 9, 2, 7};
        Sorting.bubbleSort(unsorted1);
        System.out.println("bubbleSort (expected 1 2 3 5 7 8 9): ");
        for (int x : unsorted1) System.out.print(x + " ");
        System.out.println();

        int[] unsorted2 = {1};
        Sorting.bubbleSort(unsorted2);
        System.out.println("bubbleSort single element (expected 1): " + unsorted2[0]);

        int[] unsorted3 = {2, 1};
        Sorting.bubbleSort(unsorted3);
        System.out.println("bubbleSort two elements (expected 1 2): " + unsorted3[0] + " " + unsorted3[1]);

        int[] alreadySorted = {1, 2, 3, 4, 5};
        Sorting.bubbleSort(alreadySorted);
        System.out.println("bubbleSort already sorted (expected 1 2 3 4 5): ");
        for (int x : alreadySorted) System.out.print(x + " ");
        System.out.println();

        int[] unsorted4 = {5, 3, 8, 1, 9, 2, 7};
        Sorting.heapSort(unsorted4);
        System.out.println("heapSort (expected 1 2 3 5 7 8 9): ");
        for (int x : unsorted4) System.out.print(x + " ");
        System.out.println();

        int[] unsorted5 = {1};
        Sorting.heapSort(unsorted5);
        System.out.println("heapSort single element (expected 1): " + unsorted5[0]);

        int[] unsorted6 = {2, 1};
        Sorting.heapSort(unsorted6);
        System.out.println("heapSort two elements (expected 1 2): " + unsorted6[0] + " " + unsorted6[1]);

        int[] alreadySorted2 = {1, 2, 3, 4, 5};
        Sorting.heapSort(alreadySorted2);
        System.out.println("heapSort already sorted (expected 1 2 3 4 5): ");
        for (int x : alreadySorted2) System.out.print(x + " ");
        System.out.println();
    }
}
