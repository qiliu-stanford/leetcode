public class Solution {
    public List<String> letterCombinations(String digits) {
        char[] num = digits.toCharArray();
        List<String> list = new LinkedList<String>();
        list.add("");
        int size, total;
        String tmp;
        char add;
        for (int i = 0; i < num.length; i++) {
            size = list.size();
            for (int j = 0; j < size; j++) {
                tmp = list.remove(0);
                if ((num[i] == '7') || (num[i] == '9')) {
                    total = 4;
                } else {
                    total = 3;
                }
                for (int k = 0; k < total; k++) {
                    add = (char)('a' + (num[i] - '2') * 3 + k);
                    if ((num[i] == '8') || (num[i] == '9')) add += 1;
                    list.add(tmp + add);
                }
            }
        }
        return list;
    }
}