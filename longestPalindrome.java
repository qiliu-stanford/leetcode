public class Solution {
    public String longestPalindrome(String s) {
        if ((s == null) || (s.length() == 0)) return null;
        int len = 1;
        int start, k, cur;
        start = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            cur = longestStrLen(s, i, i+1);
            if (cur > len) {
                len = cur;
                start = i - len/2 + 1;
            }
            cur = longestStrLen(s, i, i);
            if (cur > len) {
                len = cur;
                start = i - len/2;
            }
        }
        return s.substring(start, start+len);
    }
    private int longestStrLen(String s, int start, int end) {
        while ((start >= 0) && (end < s.length())) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start--;
            end++;
        }
        return (end-start-1);
    }
}