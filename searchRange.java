public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] pos = new int[2];
        pos[0] = -1;
        pos[1] = -1;
        int low, high, mid, low2, high2, left, find;
        low = 0;
        mid = 0;
        high = A.length - 1;
        while (low <= high) {
            mid = low + (high  - low) / 2;
            if (A[mid] == target) break;
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low > high) return pos;
        low2 = low;
        high2 = mid;
        find = 0;
        while (low2 <= high2) {
            left = low2 + (high2 - low2) / 2;
            if (A[left] == target) {
                high2 = left - 1;
                find = left;
            } else {
                low2 = left + 1;
            }
        }
        pos[0] = find;
        low2 = mid;
        high2 = high;
        find = 0;
        while (low2 <= high2) {
            left = low2 + (high2 - low2) / 2;
            if (A[left] == target) {
                 low2 = left + 1;
            
                find = left;
            } else {
                   high2 = left - 1;
            }
        }
        pos[1] = find;
        return pos;
    }
}