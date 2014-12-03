public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char tmp;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '(') || (s.charAt(i) == '{') || (s.charAt(i) == '[')) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() == true) return false;
                tmp = stack.pop();
                switch (s.charAt(i)) {
                    case ')':
                        if (tmp != '(') return false;
                        break;
                    case '}':
                        if (tmp != '{') return false;
                        break;   
                    case ']':
                        if (tmp != '[') return false;
                        break;  
                    default:
                        return false;
                }
            }
        }
        return (stack.isEmpty() == true);
    }
}