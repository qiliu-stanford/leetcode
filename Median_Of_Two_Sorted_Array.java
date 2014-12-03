public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int len1 = A.length;
        int len2 = B.length;
        if (((len1 + len2) %2) == 1) return findMedian(A, 0, B, 0, (len1+len2) / 2+1);
        else {
            return ((double)findMedian(A, 0, B, 0, (len1+len2) / 2) + findMedian(A, 0, B, 0, (len1+len2) / 2 + 1)) /2;
        }
    }
    private int findMedian(int A[], int start1, int B[], int start2, int k) {
        int AMid, BMid;
        if (start1 >= A.length) return B[start2 + k-1];
        if (start2 >= B.length) return A[start1 + k -1];
        if (k == 1) return Math.min(A[start1], B[start2]);
        AMid = ((start1 + k/2 -1) < A.length) ? A[start1 + k/2 -1]: Integer.MAX_VALUE;
        BMid = ((start2 + k/2 -1) < B.length) ? B[start2 + k/2 -1]: Integer.MAX_VALUE;
        if (AMid < BMid) {
            return findMedian(A, start1 + k /2, B, start2, k - k/2);
        } else {
            return findMedian(A, start1, B, start2 + k/2, k - k/2);
        }
    }
}