package ADS_Java.day_8;

public class Palindrome {
    public static int palindrome(int n,int pl){    
        if(n == 0)
            return pl;
        return palindrome(n/10, pl*10 + n%10);
    }

    public static void main(String[] args) {
        System.out.println(palindrome(123,0));    
    }
}
