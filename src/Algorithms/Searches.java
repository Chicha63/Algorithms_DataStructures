package Algorithms;

public class Searches {
    public static int binarySearch(int[] array, int val){
        int bot = 0;
        int top = array.length;
        while (bot < top){
            int mid = (bot + top) / 2;
            if (mid == val)
                return mid;
            if (mid < val)
                bot = mid+1;
            else
                top = mid;
        }
        return -1;
    }

    public static int linearSearch(int[] array, int val){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val)
                return i;
        }
        return -1;
    }
}
