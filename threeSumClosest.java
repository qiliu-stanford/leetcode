public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int diff = Integer.MAX_VALUE, closest = 0;
        int start, end, sum;
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            start = i + 1;
            end = num.length - 1;
            while (start < end) {
                sum = num[i] + num[start] + num[end];
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    closest = sum;
                }
                
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return closest;
    }
}