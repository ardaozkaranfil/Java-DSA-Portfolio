public class Sorting {

    public static void bubbleSort(int[] arr){


        for(int j = 0; j < arr.length - 1; j++) {
            boolean sorted = false;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];

                    arr[i - 1] = arr[i];
                    arr[i] = temp;

                    sorted = true;
                }
            }

            if(!sorted){
                break;
            }
        }
    }

    public static void heapSort(int[] arr){
        MaxHeap heap = new MaxHeap(arr.clone());

        for(int i = arr.length; i != 0; i--){
            arr[i - 1] = heap.deleteMax();
        }
    }
}