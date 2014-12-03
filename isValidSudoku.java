public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9) return false;
        if (board[0].length != 9) return false;
        int[][] column = new int[9][9];
        int[][] row = new int[9][9];
        int[][] block = new int[9][9];
        int a, b;
        int num;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if ((board[i][j] - '1' < 0) || (board[i][j] - '1' > 8)) return false;
                num = board[i][j] - '1';
                if (row[i][num] >= 1) {
                    return false;
                } else {
                    row[i][num] = 1;
                }
                if (column[j][num] >= 1) {
                    return false;
                } else {
                    column[j][num] = 1;
                }
                a = i / 3;
                b = j / 3;
                if (block[a * 3 + b][num] >= 1) {
                    return false;
                } else {
                    block[a * 3 + b][num] = 1;
                }
            }
        }
        return true;
    }
}