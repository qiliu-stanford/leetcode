public class Solution {
    public int search(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[low] <= A[mid]) {
                if ((A[mid] > target) && (A[low] <= target)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if ((A[mid] < target) && (A[high] >= target)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}