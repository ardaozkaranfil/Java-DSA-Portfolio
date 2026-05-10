import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeap {

    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private int[] array;

    public MinHeap(){
        this (DEFAULT_CAPACITY);
    }

    public MinHeap(int capacity){
        currentSize = 0;
        array = new int[capacity + 1];
    }


    public MinHeap(int[] items){
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

    public int findMin(){
        if( isEmpty() ) return -1;
        return array[1];
    }

    /**
     * Allocates a new array of the given size and copies existing elements.
     * @time O(n)
     */
    private void enlargeArray(int newSize){
        int[] newArray = new int[newSize];
        System.arraycopy(array,0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * Inserts a positive integer into the heap.
     * @time O(log n)
     */
    public void insert(int x){
        if(x <= 0){
            throw new IllegalArgumentException("Inserted value must be a positive integer");
        }
        else if(currentSize == array.length - 1){
            enlargeArray(array.length * 2);
        }

        currentSize++;
        percolateUp(x, currentSize);
    }

    /**
     * Moves the element at the given hole upward to restore heap order.
     * @time O(log n)
     */
    private void percolateUp(int x, int hole){
        if(array.length == 0 || x >= array[hole / 2]){
            array[hole] = x;
        }
        else {
            for (int i = hole; i > 1; i = i / 2) {
                if (x < array[i / 2]) {
                    array[i] = array[i / 2];
                    array[i / 2] = x;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Moves the element at the given hole downward to restore heap order.
     * @time O(log n)
     */
    private void percolateDown(int hole){
        int temp;

        for(int i = hole; i * 2 < currentSize || i * 2 == currentSize; ){
            if(i * 2 == currentSize && array[i] > array[i*2]){
                temp = array[i * 2];
                array[i * 2] = array[i];
                array[i] = temp;

                i = i * 2;
            }
            else if(array[i] <= array[i*2] && i * 2 == currentSize){
                break;
            }
            else {

                int minChild = Math.min(array[i * 2], array[(i * 2) + 1]);

                if (minChild == array[i * 2] && array[i] > minChild) {
                    temp = array[i * 2];
                    array[i * 2] = array[i];
                    array[i] = temp;

                    i = i * 2;
                } else if (minChild == array[(i * 2) + 1] && array[i] > minChild) {
                    temp = array[(i * 2) + 1];
                    array[(i * 2) + 1] = array[i];
                    array[i] = temp;

                    i = (i * 2) + 1;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Removes and returns the minimum element.
     * @time O(log n)
     */
    public int deleteMin(){
        if(currentSize == 0){
            throw new NoSuchElementException("Heap is empty");
        }
        else{
            int temp = array[1];
            array[1] = array[currentSize];
            currentSize--;

            percolateDown(1);

            return temp;
        }
    }

    /**
     * Builds a valid heap from an unordered array.
     * @time O(n)
     */
    private void buildHeap(){
        for(int i = currentSize / 2; i >= 1; i--){
            percolateDown(i);
        }
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

    /**
     * Returns the zero-based height of the heap.
     * @time O(1)
     */
    public Integer getHeight(){
        if(currentSize == 0){
            throw new NoSuchElementException("Heap is empty");
        }
        else{
            return (int) (Math.log(currentSize) /  Math.log(2));
        }
    }

    /**
     * Decreases the value at the given index by the specified amount.
     * @time O(log n)
     */
    public Boolean decreaseKey(int index, int amount) {
        if(index > currentSize){
            System.out.println("Index out of bounds");
            return false;
        }
        else if(index < 1){
            System.out.println("Index out of bounds");
            return false;
        }
        else if(array[index] - amount < 1){
            System.out.println("New value must be a positive integer");
            return false;
        }
        else if(amount <= 0){
            System.out.println("Amount must be a positive integer");
            return false;
        }
        else {
            percolateUp(array[index] - amount, index);
            return true;
        }
    }

    /**
     * Increases the value at the given index by the specified amount.
     * @time O(log n)
     */
    public Boolean increaseKey(int index, int amount){
        if(index > currentSize){
            System.out.println("Index out of bounds");
            return false;
        }
        else if(index < 1){
            System.out.println("Index out of bounds");
            return false;
        }
        else if(amount <= 0){
            System.out.println("Amount must be a positive integer");
            return false;
        }
        else{
            array[index] += amount;
            percolateDown(index);
            return true;
        }
    }

    /**
     * Deletes the element at the given index.
     * @time O(log n)
     */
    public Boolean delete(int index){
        if(index > currentSize){
            System.out.println("Index out of bounds");
            return false;
        }
        else if(index < 1){
            System.out.println("Index out of bounds");
            return false;
        }
        else{
            array[index] = array[currentSize];
            currentSize--;

            if((index * 2 + 1 <= currentSize || index * 2 == currentSize) && (array[index] > array[index * 2 + 1] || array[index] > array[index * 2])) {
                percolateDown(index);
                return true;
            }
            else if(array[index] < array[index / 2]){
                percolateUp(array[index], index);
                return true;
            }
            else {
                return true;
            }
        }
    }

    /**
     * Checks whether the given array satisfies the min-heap property.
     * @time O(n)
     */
    public Boolean isMinHeap(int[] arr){
        if (arr == null || arr.length < 2) {
            return false;
        }

        int n = arr.length - 1;

        for (int i = 1; i <= n / 2; i++) {
            if (i * 2 <= n && arr[i] > arr[i * 2]) {
                return false;
            }
            else if (i * 2 + 1 <= n && arr[i] > arr[i * 2 + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Merges the given heap into this heap.
     * @time O(n log n)
     */
    public Boolean mergeHeaps(MinHeap otherHeap){
        if (this.isEmpty() || otherHeap.isEmpty()) {
            return false;
        }

        int[] otherArray = otherHeap.getArray();
        int otherSize = otherHeap.getCurrentSize();

        for (int i = 1; i <= otherSize; i++) {
            this.insert(otherArray[i]);
        }
        return true;
    }
}