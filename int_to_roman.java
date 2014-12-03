public class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        int divide = 1000, digit;
        while (num != 0) {
            digit = num / divide;
            if (digit == 0) {
                divide = divide / 10;
                continue;
            }
            if (digit == 9) {
                sb.append(map.get(divide));
                sb.append(map.get(digit * divide + divide));
            } else if (digit == 4) {
                sb.append(map.get(divide));
                sb.append(map.get(digit * divide + divide));
            } else if (digit >= 5) {
                sb.append(map.get(5 * divide));
                for (int i = 0; i < digit - 5; i++) {
                    sb.append(map.get(divide));
                }
            } else {
                for (int i = 0; i < digit; i++) {
                    sb.append(map.get(divide));
                }
            }
          
            num -= digit * divide;
            divide /= 10;
        }
        return sb.toString();
    }
}