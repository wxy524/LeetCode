/*
Author: Xueyi Wang
Date: Jan 21 2014
Probelm Description:

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/

import java.util.Set;
import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> hs;
        
        for(int i = 0; i < board.length; i++) {
            hs = new HashSet<Character>();
            for(int ii = 0; ii < board.length; ii++) {
                if(board[i][ii] != '.' && hs.contains(board[i][ii])) {
                    return false;
                } else {
                    hs.add(board[i][ii]);
                }
            }
        }
        
        for(int i = 0; i < board.length; i++) {
            hs = new HashSet<Character>();
            for(int ii = 0; ii < board.length; ii++) {
                if(board[ii][i] != '.' && hs.contains(board[ii][i])) {
                    return false;
                } else {
                    hs.add(board[ii][i]);
                }
            }
        }
        
        for(int i = 0; i < board.length; i++) {
            hs = new HashSet<Character>();
            int row = (i / 3) * 3;
            int col = (i % 3) * 3;
            for(int ii = row; ii < row + 3; ii++) {
                for(int iii = col; iii < col + 3; iii++) {
                    if(board[ii][iii] != '.' && hs.contains(board[ii][iii])) {
                        return false;
                    } else {
                        hs.add(board[ii][iii]);
                    }
                }
            }
        }
        return true;
    }
}