public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        int len = L.length, start, size, index;
        List<Integer> list = new ArrayList<Integer>();
        HashMap<String, Integer> set = new HashMap<String, Integer>();
        HashMap<String, Integer> cur = new HashMap<String, Integer>();
        String tmp, prev;
        if (len == 0) return list;
        for (int i = 0; i < len; i++) {
            if (!set.containsKey(L[i])) {
                set.put(L[i], 1);
            } else {
                set.put(L[i], set.get(L[i]) + 1);
            }
        }
        size = L[0].length();
        for (int i = 0; i < size; i++) {
            start = -1;
            cur.clear();
            for (int j = 0; j < (S.length() - i) / size; j++) {
                index = i + j * size;
                tmp = S.substring(index, index + size);
                if (set.containsKey(tmp)) {
                    if (start == -1) {
                        start = j;
                    } else {
                        if (cur.get(tmp) == set.get(tmp)) {
                            for (int k = start; k < j; k++) {
                                prev = S.substring(k*size+i, (k+1)*size+i);
                                if (cur.get(prev) == 1) {
                                    cur.remove(prev);
                                } else {
                                    cur.put(prev, cur.get(prev) - 1);
                                }
                                if (prev.equals(tmp)) {
                                    start = k+1;
                                    break;
                                }
                            }
                        }
                    }
                    if (cur.containsKey(tmp)) {
                        cur.put(tmp, cur.get(tmp) + 1);
                    } else {
                        cur.put(tmp, 1);
                    }
                    if (j-start+1 == len) {
                         list.add(i + start * size);
                    }
                } else {
                    start = -1;
                    cur.clear();
                }
            }
        }
        return list;
    }
}