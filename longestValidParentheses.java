public class Solution {
    public int longestValidParentheses(String s) {
        if ((s == null) || (s.length() == 0)) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max =0;
        int sum = 0, tmp, prev = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    sum = 0;
                } else {
                    tmp = stack.pop();
                    if (stack.isEmpty()) {
                        sum += i - tmp + 1;
                        max = Math.max(max, sum);
                    } else {
                        max = Math.max(max, i - stack.peek());   
                    }
                }
            }
        }
        return max;
    }
}