/*
Author: Xueyi Wang
Date: Sep 10, 2014;

Problen Description:
N Queen problem~ easy~
*/

import java.util.*;

public class NQueens {
    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
        if(n <= 0) {
            return res;
        }
        char[][] board = new char[n][n]; 
        for(int i = 0; i < n; i++) {
            for(int ii = 0; ii < n; ii++) {
                board[i][ii] = '.';
            }
        }
        solver(res, board, 0, n);
        return res;
    }
    private void solver(List<String[]>res, char[][]board, int row, int n) {
        if(row == n) {
            String[] s = new String[n];
            for(int i = 0; i < n; i++) {
               String tmp = new String(board[i]);
               s[i] = tmp;
            }
            
            res.add(s);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(checker(board, row, i, n)) {
                board[row][i] = 'Q';
                solver(res, board, row+1, n);
            }
            board[row][i] = '.';
        }
        return;
    }
    private boolean checker(char[][] board, int row, int col, int n) {
        for(int i = 0; i < row; i++) {
            if(col - row + i >= 0 && board[i][col-row+i] == 'Q') {
                return false;
            }
            if(col + row - i < n && board[i][col+row-i] == 'Q') {
                return false;
            }
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        for(int i = 0; i < col; i++) {
            if(board[row][i] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 2;
        NQueens test = new NQueens();
        test.solveNQueens(2);
    }
}