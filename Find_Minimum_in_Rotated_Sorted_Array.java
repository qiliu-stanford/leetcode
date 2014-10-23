public class Solution {
    public int findMin(int[] num) {
        if ((num == null) || (num.length == 0)) return 0;
        int left = 0, mid;
        int right = num.length - 1;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (num[mid] > num[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return num[left];
    }
}