package ADS_Java.day_10;

public class BubbleSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
    }

    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length;j++){
                if(arr[j] < arr[j-1])
                    swap(arr, j, j-1);
            }
        }
        display(arr);
    }
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        bubbleSort(arr);
    }
}
