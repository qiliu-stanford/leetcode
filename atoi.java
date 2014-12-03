public class Solution {
    public int atoi(String str) {
        long result = 0;
        int start = 0;
        boolean isNegative = false;
        str = str.trim();
        if (str.length() == 0) return 0;
        if (str.charAt(start) == '+') {
            start++;
        } else if (str.charAt(start) == '-') {
            start++;
            isNegative = true;
        }
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            result = result * 10 + str.charAt(i) - '0';
            if (result > (long)Integer.MAX_VALUE + 1) {
                break;
            }
        }
        if (isNegative == true) {
            result = -result;
        }
        if ((result > Integer.MAX_VALUE)) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) 
            return Integer.MIN_VALUE;
        return (int)result;
    }
}