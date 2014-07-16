/*
Author: Xueyi Wang
Date: Jan 10 2014
Probelm Description:

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        
        if(row == 0 && column == 0) {
            return 0;
        } 

        int[][] path = new int[row][column];
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(obstacleGrid[i][j] == 0) {
                    if(i == 0 && j == 0) {
                        path[i][j] = 1;
                    } else {
                        path[i][j] = (i > 0 ? path[i-1][j] : 0 ) + ( j > 0 ? path[i][j-1] : 0);    
                    }
                }                       
            }
        } 
        return path[row-1][column-1];
    }
}