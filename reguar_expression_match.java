public class Solution {
    public boolean isMatch(String s, String p) {
        int m, n;
        m = s.length();
        n = p.length();
        boolean[][] match = new boolean[m+1][n+1];
        boolean matched;
        match[0][0] = true;
        for (int j = 1; j<=n; j++) {
            if (p.charAt(j-1) == '*') match[0][j] = match[0][j-2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                matched = ((charMatch(s.charAt(i-1), p.charAt(j-1)) && match[i-1][j-1]) ||
                    ((p.charAt(j-1) == '*') && (match[i][j-1] || match[i][j-2] || (match[i-1][j] && charMatch(s.charAt(i-1), p.charAt(j-2))))));
                match[i][j] = matched;
            }
        }
        return match[m][n];
    }
    private boolean charMatch(char a, char b) {
        if (b == '.') return true;
        return a == b;
    }
}