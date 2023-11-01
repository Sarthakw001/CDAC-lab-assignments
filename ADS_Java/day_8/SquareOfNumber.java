package ADS_Java.day_8;

public class SquareOfNumber {
    public static int squareOfNumber(int n){
        if(n == 1)
            return 1;
        return squareOfNumber(n-1) + 2*n -1;
    }
    public static void main(String[] args) {
        System.out.println(squareOfNumber(13));
    }
}
