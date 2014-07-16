/*
Author: Xueyi Wang
Date: July 15 2014

Problem Description:

Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
*/

public class SodokuSolver {
    public void solveSudoku(char[][] board) {
        findValid(board, 0, 0);            
    }
    
    private boolean findValid(char[][] board, int row, int col) {
        if(col >= 9) {
            col = 0;
            row = row + 1;
        }
        if(row >= 9) {
            return true;
        }
        
        if(board[row][col] == '.') {
            for(int i = 0; i < 9; i++) {
                board[row][col] = (char)(i+1+'0');
                if(isValid(board, row, col)) {
                    if(findValid(board, row, col+1)) {
                        return true;
                    }
                }
                board[row][col] = '.';
            }
        } else {
            return findValid(board, row, col+1);
        }
        return false;
    }
    
    private boolean isValid(char[][]board, int row, int col) {
        for(int i = 0; i < 9; i++) {
            if(i != col && board[row][i] == board[row][col]) {
                return false;
            }
            if(i != row && board[i][col] == board[row][col]) {
                return false;
            }
        }    
        int row_range = (row / 3)*3;
        int col_range = (col / 3)*3;
        
        for(int i = row_range; i < row_range+3; i++) {
            for(int ii = col_range; ii < col_range+3; ii++) {
                if(i != row && ii != col && board[i][ii] == board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}