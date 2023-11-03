package ADS_Java.day_10;

public class BinarySearch {
    public static int binarySearch(int[] arr, int val, int low, int high) {
        if (high >= low && low < arr.length) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == val)
                return mid;
            if (val > arr[mid])
                return binarySearch(arr, val, mid + 1, high);
            return binarySearch(arr, val, low, mid - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5 };
        System.out.println(binarySearch(arr, 4, 0, arr.length - 1));
    }
}
