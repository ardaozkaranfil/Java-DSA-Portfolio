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
        int[] newArray = new int[newSize];
        System.arraycopy(array, 0,newArray,0,currentSize + 1);
        array = newArray;
    }

    public void insert(int x){
        if(x <= 0){
            throw new IllegalArgumentException("x must be a positive integer");
        }
        else if(array.length == 0){
            throw new IllegalStateException("Heap array is not initialized");
        }
        else if(array.length - 1 == currentSize){
            enlargeArray(array.length * 2);
            insert(x);
        }
        else if(currentSize == 0){
            array[1] = x;
            currentSize++;
        }
        else{
            currentSize++;
            percolateUp(x, currentSize);

        }
    }

    private void percolateUp(int x, int hole){
        for(int i = hole; i > 1; i /= 2){
            if(x > array[i / 2]){
                int temp = array[i / 2];

                array[i / 2] = x;
                array[i] = temp;
            }
            else {
                array[i] = x;
                break;
            }
        }
    }

    private void percolateDown(int hole){
        int temp;

        for(int i = hole; i * 2 < currentSize || i * 2 == currentSize; ){
            if(i * 2 == currentSize && array[i] < array[i*2]){
                temp = array[i * 2];
                array[i * 2] = array[i];
                array[i] = temp;

                i = i * 2;
            }
            else if(array[i] >= array[i*2] && i * 2 == currentSize){
                break;
            }
            else {

                int maxChild = Math.max(array[i * 2], array[(i * 2) + 1]);

                if (maxChild == array[i * 2] && array[i] < maxChild) {
                    temp = array[i * 2];
                    array[i * 2] = array[i];
                    array[i] = temp;

                    i = i * 2;
                } else if (maxChild == array[(i * 2) + 1] && array[i] < maxChild) {
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

    public int deleteMax(){
        if(array.length <= 1 || currentSize == 0){
            throw new IllegalStateException("Heap array is not initialized");
        }
        else if(currentSize == 1){
            return array[currentSize--];
        }
        else{
            int max = array[1];
            array[1] = array[currentSize];
            currentSize--;

            percolateDown(1);

            return max;
        }
    }

    private void buildHeap(){
        for(int i = currentSize / 2; i > 0; i--){
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
}