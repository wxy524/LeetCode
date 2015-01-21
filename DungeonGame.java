/*
Author: Xueyi Wang
*/

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length, col = dungeon[0].length;
        int[][] cost = new int[row][col];
        
        if(dungeon[row-1][col-1] > 0) {
            cost[row-1][col-1] = 1;
        } else {
            cost[row-1][col-1] = Math.abs(dungeon[row-1][col-1]) + 1;
        }
        
        for(int row_idx = row-2; row_idx >=0; row_idx--) {
            cost[row_idx][col-1] = Math.max(cost[row_idx+1][col-1] - dungeon[row_idx][col-1], 1);
        }
        
        for(int col_idx = col-2; col_idx >= 0; col_idx--) {
            cost[row-1][col_idx] = Math.max(cost[row-1][col_idx+1] - dungeon[row-1][col_idx], 1);
        }
        
        for(int row_idx = row-2; row_idx >= 0; row_idx--) {
            for(int col_idx = col-2; col_idx >= 0; col_idx--) {
                int path1 = Math.max(cost[row_idx+1][col_idx] - dungeon[row_idx][col_idx], 1);
                int path2 = Math.max(cost[row_idx][col_idx+1] - dungeon[row_idx][col_idx], 1);
                cost[row_idx][col_idx] = Math.min(path1, path2);
            }
        }
        
        return cost[0][0];
    }
}
