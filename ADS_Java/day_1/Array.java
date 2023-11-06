import java.util.Scanner;

public class Array {
    private static void printEvenOddSeprate(int[] arr) {
        for (int i : arr)
            if (i % 2 == 0)
                System.out.print(i);
        System.out.println();
        for (int i : arr)
            if (i % 2 != 0)
                System.out.print(i);
    }

    private static int maxOfArray(int[] arr) {
        int mx = Integer.MIN_VALUE;
        for (int i : arr)
            if (i > mx)
                mx = i;
        return mx;
    }

    private static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        return sum;
    }

    private static int[] reverse(int[] arr) {
        int[] temp = new int[arr.length];
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp[j] = arr[i];
            j++;
        }
        return temp;
    }

    private static void displayArray(int[] arr) {
        for (int i : arr)
            System.out.println(i);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of elements to insert in array");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the elemets of array");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            boolean flag = true;
            while (flag) {
                System.out.println(
                        "1 -> Display\n 2 -> Reverse the array\n 3 -> Replace the nth element from the array and print\n 4 -> Find the addition of all elements of the array\n 5 -> Find the maximum number from the array\n 6 -> Print the average of all the elements from the array.\n 7 -> Display the even and odd number from the array separately.\n 0 -> Exit");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        displayArray(arr);
                        break;
                    case 2:
                        int temp[] = reverse(arr);
                        for (int i : temp)
                            System.out.println(i);
                        break;
                    case 3:
                        System.out.println("Enter the element to replace");
                        int x = sc.nextInt();
                        System.out.println("Enter the index to repace with");
                        int idx = sc.nextInt();
                        arr[idx] = x;
                        for (int i : arr)
                            System.out.println(i);
                        break;
                    case 4:
                        int sum = sumOfArray(arr);
                        System.out.println(sum);
                        break;
                    case 5:
                        int mx = maxOfArray(arr);
                        System.out.println(mx);
                        break;
                    case 6:
                        int sm = sumOfArray(arr);
                        System.out.println(sm / n);
                        break;
                    case 7:
                        printEvenOddSeprate(arr);
                        break;
                    case 0:
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            }
        }
    }
}

/*
 * 
 */