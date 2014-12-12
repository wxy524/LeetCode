/*
Author: Xueyi Wang

Problem Description:
Normal NQueen problem. only return number of valid borad.
*/

public class NQueensII {
    int count = 0;
    public int totalNQueens(int n) {
        if(n == 0) {
            return 0;
        }
        if(n== 1) {
            return 1;
        }
        
        boolean[][] isVisited = new boolean[n][n];
        
        findValid(isVisited, 0, n);
        
        return count;
    }
    private void findValid(boolean[][] isVisited, int row, int n) {
        if(row == n) {     
            count++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if(checker(isVisited, row, i, n)) {
                isVisited[row][i] = true;
                findValid(isVisited, row+1, n);
            }
            isVisited[row][i] = false;
        }
    }
    private boolean checker(boolean[][] isVisited, int row, int col, int n) {
        for(int i = 0; i <= row; i++) {
            if(isVisited[i][col]) {
                return false;
            }
        } 
        for(int i = 0; i < row; i++) {
            if(col-row+i >= 0 && isVisited[i][col-row+i]) {
                return false;
            }
            if(col+row-i < n && isVisited[i][col+row-i]) {
                return false;
            }
        }
        return true;
    }
}