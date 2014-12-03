public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int max = 0;
        int index;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) == true) {
                index = map.get(s.charAt(i));
                for (int j = start; j <= index; j++) {
                    map.remove(s.charAt(j));
                }
                start = index+1;
            }
            map.put(s.charAt(i), i);
            if (map.size() > max) max = map.size();
        }
        return max;
    }
}