/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement:
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class SprialMatrixII {
    public int[][] generateMatrix(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int[][] matrix = new int[n][n];
        int num = 1, iter = n - 1, cnt = 0;
        
        if (n == 1) {
            matrix[0][0] = 1;
            return matrix;
        }
        
        while (iter >= 0) {
            if (iter == 0) {
                matrix[cnt][cnt] = num;
                break;
            }
            for (int i = 0; i < iter; i++ ) {
                matrix[cnt][cnt+i] = num++;
            }
            for (int i = 0; i < iter; i++) {
                matrix[cnt+i][n-cnt-1] = num++;
            }
            for (int i = 0; i < iter; i++) {
                matrix[n-cnt-1][n-cnt-1-i] = num++;
            }
            for (int i = 0; i < iter; i++) {
                matrix[n-cnt-1-i][cnt] = num++;
            }
            iter = iter - 2;
            cnt = cnt + 1;
        }
        return matrix;
        
    }
}