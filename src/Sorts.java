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
        sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int l, int r){
        if (l < r){
            int m = (r - l) / 2 + l;
            sort(arr, l, m);
            sort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right){
        int size1 = mid - left + 1;
        int size2 = right - mid;
        int[] leftSib = new int[size1];
        int[] rightSib = new int[size2];
        System.arraycopy(arr, left, leftSib, 0, size1);
        System.arraycopy(arr, mid + 1, rightSib, 0, size2);
        int i = 0;
        int j = 0;
        int k = left;
        while (i < size1 && j < size2){
            if (leftSib[i] < rightSib[i]){
                arr[k] = leftSib[i];
                i++;
            }else {
                arr[k] = rightSib[i];
                j++;
            }
            k++;
        }
        if (i < size1)
            System.arraycopy(leftSib, i, arr, k, size1);
        k += size1-i-1;
        if (j < size2)
            System.arraycopy(leftSib, j, arr, k, size2);
    }

    private static void swap(int[] arr, int i, int j){
        if (i != j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
