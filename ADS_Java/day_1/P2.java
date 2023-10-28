import java.util.ArrayList;

public class P2 {
    public static boolean binarySearch(int[] b,int key){  // Binary Search - T.C - O(log n)
        int low = 0,high = b.length -1;
        while(low<high){
            int mid = low + (high - low)/2;
            if(b[mid] == key){
                return true;
            }
            else if(b[mid] > key){
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;

    }
    public static void commonElements1(int[] a, int[] b) { // Brute Force - T.C- O(n*n) , S.C - O(1)
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    ls.add(a[i]);
                }
            }
        }
        for (int i : ls)
            System.out.print(i+" ");
    }
    public static void commonElements2(int[] a, int[] b) { // Optimized - T.C- O(n*log n) , S.C - O(1)
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            if(binarySearch(b, a[i])){
                ls.add(a[i]);
            }
        }
        for (int i : ls)
            System.out.print(i+" ");
    }
    public static void commonElements3(int[] a, int[] b) { // Most optimized - T.C- O(n) , S.C - O(1)
        ArrayList<Integer> ls = new ArrayList<Integer>();
        int x = 0,y = 0;
        while(x<a.length && y<b.length){
            if(a[x] == b[y]){
                ls.add(a[x]);
                x++;y++;
            }else if(a[x] > b[y]){
                y++;
            }else {
                x++;
            }
        }
        for (int i : ls)
            System.out.print(i+" ");
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 4, 6, 7, 9 };
        int[] b = { 1, 2, 4, 5, 9, 10 };
        commonElements3(a, b);
    }
}
