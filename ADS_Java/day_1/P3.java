public class P3 {
    public static boolean oneStringAway(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }
        int misMatch = 0, idx = 0;
        while (idx < Math.min(s1.length(),s2.length())) {
            if (misMatch > 1)
                return false;
            if (s1.charAt(idx) != s2.charAt(idx)) {
                misMatch++;
            }
            idx++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(oneStringAway("abc", "abd"));
    }
}
