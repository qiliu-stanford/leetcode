public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        letterCombine(digits, 0, "", list);
        return list;
    }
    private void letterCombine(String digits, int start, String prev, List<String> list) {
        if (start == digits.length()) {
            list.add(prev);
            return;
        }
        int cur = digits.charAt(start) - '0';
        int left = 3 * (cur - 2);
        int len = 3;
        if (cur == 7) {
            len = 4;
        } else if (cur == 8) {
            left += 1;
        } else if (cur == 9) {
            left += 1;
            len = 4;
        }
        for (int i = left; i < left + len; i++) {
            letterCombine(digits, start + 1, prev + ((char)('a' + i)), list);
        }
    }
}