/*
Author: Xueyi Wang
Date: July 24 2014

Problem Description:

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class WordSearch {
    public boolean exist(char[][] board, String word) {
               boolean used[][] = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int ii = 0; ii < board[0].length; ii++) {
                if(isValid(board, used, word, i, ii, 0)) {          
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(char[][]board, boolean[][]used, String word, int row, int col, int idx) {
       if(board[row][col] == word.charAt(idx) && used[row][col] == false) {
            if(idx == word.length() - 1) {                  //find word in the board
                return true;
            } else {
                used[row][col] = true;
                boolean up = false, down = false, left = false, right = false;
                if(row - 1 >= 0) {
                    up = isValid(board, used, word, row-1, col, idx+1);   //To see if upper cell is valid.
                }
                if(row + 1 < board.length) {
                    down = isValid(board, used, word, row+1, col, idx+1);   //To osee if lower cell is valid
                } 
                if(col - 1 >= 0) {
                    left = isValid(board, used, word, row, col-1, idx+1);      //To see if left cell is valid
                }
                if(col + 1 < board[0].length) {
                    right = isValid(board, used, word, row, col+1, idx+1);     //To see if right cell is valid
                }
                if(up || down || left || right) {
                    return true;
                } else {
                    used[row][col] = false;                 //current cell is not valid
                    return false;
                }
            }
       }
       else {
            return false;
        }  
    }
}



       