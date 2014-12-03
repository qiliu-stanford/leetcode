public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] sol = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {

                if (map.containsKey(target-numbers[i])) {
                    sol[0] = map.get(target-numbers[i]);
                    sol[1] = i+1;
                    return sol;
                } else {
                    map.put(numbers[i], i+1);
                }
            
        }
        return sol;
    }
}