package ADS_Java.day_10;

public class LinearSearch {
    public static int linearSearch(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(linearSearch(arr, 4));
    }
}
