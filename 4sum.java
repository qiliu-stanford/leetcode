public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list;
        int len = num.length;
        int start, end, sum;
        Arrays.sort(num);
        for (int i = 0; i < len-3; i++) {
            if ((i != 0) && (num[i] == num[i-1])) continue;
            for (int j = i+1; j < len-2; j++) {
                if ((j != i+1) && (num[j] == num[j-1])) continue;
                start = j+1;
                end = len - 1;
                while (start < end) {
                    sum = num[i] + num[j] + num[start] + num[end];
                    if (sum == target) {
                        list = new ArrayList<>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[start]);
                        list.add(num[end]);
                        result.add(list);
                        start++;
                        end--;
                        while ((start < end) && (num[start] == num[start-1])) {
                            start++;
                        }
                        while ((start < end) && (num[end] == num[end+1])) {
                            end--;
                        }
                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return result;
    }
}