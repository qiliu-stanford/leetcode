public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int base = 1;
        while (x / base >= 10) {
            base = base * 10;
        }
        
        while (x > 0) {
            if ((x / base) != x % 10) return false;
            x = x % base;
            x /= 10;
            base /= 100;
        }
        return true;
    }
}