import java.sql.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {30, 58, 89, 50, 94, 17, 46, 85, 9, 28,
                74, 97, 13, 83, 64, 37, 72, 20, 70, 88,
                77, 68, 39, 67, 41, 7, 25, 84, 21, 73,
                78, 96, 29, 18, 53, 66, 69, 14, 42, 5,
                81, 76, 59, 15, 61, 71, 36, 79, 60, 22,
                33, 6, 10, 44, 2, 34, 38, 91, 80, 24,
                48, 3, 16, 92, 87, 12, 35, 65, 26, 93,
                62, 75, 45, 86, 1, 8, 23, 31, 11, 49,
                27, 90, 32, 19, 4, 40, 63, 52, 55, 47,
                56, 43, 51, 95, 54, 82, 57, 98, 99, 100};
        int[] array2 = {3,2,1,4};
        Sorts.mergeSort(array);
        System.out.println(Arrays.toString(array2));
    }
}