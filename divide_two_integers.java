public class Solution {
    public int divide(int dividend, int divisor) {
        int result = 0;
        int shift;
        long step;
        boolean sign = ((dividend > 0) && (divisor > 0)) || ((dividend < 0) && (divisor < 0));
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        while (a >= b) {
            step = b;
            shift = 0;
            while (step <= a) {
                step <<= 1;
                shift++;
            }
            result += 0x1 << (shift - 1);
            a -= step >> 1;
        }
        return sign?result:-result;
    }
}