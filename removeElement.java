public class Solution {
      public int removeElement(int[] A, int elem) {
        int end = A.length - 1;
        int start = 0;
        while (start <= end) {
            if (A[start] == elem) {
                A[start] = A[end];
                end--;
            } else {
                start++;
            }
        }
        return end+1;
    }
}