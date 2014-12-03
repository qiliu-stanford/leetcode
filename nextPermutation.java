public class Solution {
    public void nextPermutation(int[] num) {
        int len = num.length;
        if (len == 0) return;

        int index;
        for (index = len - 1; index > 0; index--) {
            if (num[index] > num[index - 1]) {
                break;
            }
        }
        if (index == 0) {
            Arrays.sort(num);
            return;
        }
        int min = num[index - 1];
        int big = num[index];
        int targetIndex = index;
        for (int i = index; i < len; i++) {
            if (num[i] > min) {
                if (num[i] < big) {
                    big = num[i];
                    targetIndex = i;
                }
            }
        }
        num[targetIndex] = num[index - 1];
        num[index - 1] = big;
        Arrays.sort(num, index, len);
    }
}