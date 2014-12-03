public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m, n;
        m = A.length;
        n = B.length;
        if (((m + n) % 2) == 1) return findKth(A, 0, B, 0, (m + n)/2 +1);
        else 
            return (double)(findKth(A, 0, B, 0, (m + n)/2) + findKth(A, 0, B, 0, (m + n)/2 +1))/2;
    }
    private int findKth(int A[], int startA, int B[], int startB, int k) {
        if (startA >= A.length) return B[startB + k-1];
        if (startB >= B.length) return A[startA + k-1];
        if (k == 1) return Math.min(A[startA], B[startB]);
        int mA = Math.min(A.length - startA, k/2);
        int mB = Math.min(B.length - startB, k/2);
        if (A[startA + mA - 1] < B[startB + mB - 1]) {
            return findKth(A, startA + mA, B, startB, k - mA);
        } else {
            return findKth(A, startA, B, startB + mB, k - mB);
        }
    }
}