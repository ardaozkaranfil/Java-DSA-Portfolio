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


    private void enlargeArray(int newSize){
        int[] newArray = new int[newSize];
        System.arraycopy(array,0, newArray, 0, array.length);
        array = newArray;
    }

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


    public Integer getHeight(){
        if(currentSize == 0){
            throw new NoSuchElementException("Heap is empty");
        }
        else{
            return (int) (Math.log(currentSize) /  Math.log(2));
        }
    }

    public Boolean decreaseKey(int index, int amount) {
        return true;
    }

    public Boolean increaseKey(int index, int amount){
        return true;
    }

    public Boolean delete(int index){
        return true;
    }

    public Boolean isMinHeap(int[] arr){
        return true;
    }

    public Boolean mergeHeaps(MinHeap otherHeap){
        return true;
    }
}