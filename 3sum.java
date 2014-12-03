public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        List<Integer> pairs;
        int start, end, remain;
        for (int i = 0; i < num.length; i++) {
            if ((i!=0) && (num[i] == num[i -1])) continue;
            remain = -num[i];
            start = i + 1;
            end = num.length - 1;
            while (start < end) {
                if ((num[start] + num[end]) > remain) {
                    end--;
                } else if ((num[start] + num[end]) < remain) {
                    start++;
                } else {
                    pairs = new ArrayList<Integer>();
                    pairs.add(num[i]);
                    pairs.add(num[start]);
                    pairs.add(num[end]);
                    list.add(pairs);
                    start++;
                    while ((start < end) && num[start] == num[start - 1]) {
                        start++;
                    }
                    end--;
                    while ((end > start) && num[end + 1] == num[end]) {
                        end--;
                    }
                }
            }
        }
        return list;
    }
}