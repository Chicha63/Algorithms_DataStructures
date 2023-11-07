import java.util.Arrays;

public class Sorts {
    public static void bubbleSort(int[] arr){
        for (int wall = arr.length-1; wall>0; wall--){
            for (int i = 0; i < wall; i++){
                if (arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        for (int wall = arr.length-1; wall>0; wall--){
            int maxId = 0;
            for (int i = 1; i <= wall; i++){
                if (arr[i] > arr[maxId]){
                    maxId = i;
                }
            }
            swap(arr, maxId, wall);
        }
    }

    public static void insertionSort(int[] arr){
        for (int wall = 1; wall<arr.length; wall++){
            int unsortedEl = arr[wall];
            int i = 0;
            for (i = wall; i > 0 && arr[i-1] > unsortedEl; i--){
                arr[i] = arr[i-1];
            }
            arr[i] = unsortedEl;
        }
    }

    public static void shellSort(int[] arr){
        int gap = 1;
        while (gap < arr.length/3){
            gap = 3 * gap +1;
        }
        while (gap>=1){
            for (int i = gap; i < arr.length; i++){
                for (int j = i; j >= gap && arr[j] < arr[j-gap]; j--){
                    swap(arr, j, j - gap);
                }
            }
            gap /= 3;
        }
    }

    public static void mergeSort(int[] arr){
        int[] additional = new int[arr.length];
    }

    private static void swap(int[] arr, int i, int j){
        if (i != j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
