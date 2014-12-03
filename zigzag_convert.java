public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1) return s;
        int gap = nRows * 2 - 2;
        int block = (s.length() / gap) + 1;
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            if ((i == 0) || (i == nRows - 1)) {
                for (int j = 0; j < block; j++) {
                    if ((j * gap + i) < s.length())
                      build.append(s.charAt(j * gap + i));
                }
            } else {
                for (int j = 0; j < block; j++) {
                    if ((j * gap + i) < s.length())
                    build.append(s.charAt(j * gap + i));
                    
                    if ((j * gap + 2 * nRows - i -2) < s.length())
                    build.append(s.charAt(j * gap + 2 * nRows - i -2));
                }
            }
        }
        return build.toString();
    }
}