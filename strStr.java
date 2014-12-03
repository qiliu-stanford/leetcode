public class Solution {
    public int strStr(String haystack, String needle) {
        int lenA, lenB, j;
        lenA = haystack.length();
        lenB = needle.length();
        if ((needle == null) || (haystack == null) || (lenB == 0)) return 0;
        for (int i = 0; i <= lenA - lenB; i++) {
            for (j = 0; j < lenB; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == lenB) return i;
        }
        return -1;
    }
}