package Algorithms.Searches;

public class BinarySearch {
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
}
