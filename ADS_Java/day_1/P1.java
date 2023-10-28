import java.util.HashMap;

class P1 {
    public static int mostFrequentOccuringElement1(int[] arr) { // brute force - T.C - O(n*n) , S.C - O(1)
        int maxCount = -1, element = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                element = arr[i];
            }
        }
        return element;
    }

    public static int mostFrequentOccuringElement2(int[] arr) { // Optimized Approach - T.C - O(n) , S.C - O(n)
        int maxCount = -1, element = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (mp.containsKey(arr[i])) {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            } else {
                mp.put(arr[i], 1);
            }
            if (maxCount < mp.get(arr[i])) {
                maxCount = mp.get(arr[i]);
                element = arr[i];
            }
        }
        return element;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 10, 10, 5, 5, 5, 5, 10, 4, 4, 7 ,10};
        System.out.println(mostFrequentOccuringElement2(arr));
    }
}