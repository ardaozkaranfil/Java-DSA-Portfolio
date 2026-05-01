public class MaxHeap {

    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private int[] array;

    public MaxHeap(){
        this (DEFAULT_CAPACITY);
    }

    public MaxHeap(int capacity){
        currentSize = 0;
        array = new int[capacity + 1];
    }

    public MaxHeap(int[] items){
        currentSize = items.length;
        array = new int[(currentSize + 2) * 11 / 10];

        int i = 1;
        for(int item:items)
            array[i++] = item;

        buildHeap();
    }

    public int[] getArray(){
        return this.array;
    }
    public int getCurrentSize(){
        return currentSize;
    }
    public boolean isEmpty(){
        return currentSize == 0;
    }
    public void makeEmpty(){
        currentSize = 0;
    }

    public int findMax(){
        if( isEmpty() ) return -1;
        return array[1];
    }

    private void enlargeArray(int newSize){
        return;
    }

    public void insert(int x){
        return;
    }

    private void percolateUp(int x, int hole){
        return;
    }

    private void percolateDown(int hole){
        return;
    }

    public int deleteMax(){
        return 0;
    }

    private void buildHeap(){
        return;
    }

    public void printHeap(){
        int level = 0;

        System.out.println("\n---------------------------");
        for (int i = 1; i < currentSize + 1; i++)
        {
            System.out.print(array[i] + " ");
            if ((i + 1) % Math.pow(2, level) == 0) {
                System.out.println();
                level++;
            }
        }
        System.out.println("\n---------------------------\n");
    }
}