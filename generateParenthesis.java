public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generateHelper(list, "", n, 0);
        return list;
    }
    private void generateHelper(List<String> list, String prev, int left, int right) {
        if ((left == right) && (left == 0)) list.add(prev);
        if (left > 0) {
            generateHelper(list, prev + "(", left - 1, right + 1);
        }
        if (right > 0) {
            generateHelper(list, prev + ")", left, right - 1);
        }
    }
}