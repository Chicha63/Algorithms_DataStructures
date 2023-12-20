package Algorithms.Searches;

public class LinearSearch {
    public static int linearSearch(int[] array, int val){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val)
                return i;
        }
        return -1;
    }
}
