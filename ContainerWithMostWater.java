/*
Author: Xueyi Wang
Date: Sep 1 2014

Problem Description:

Given n non-negative integers a1, a2, ..., an, where each represents 
a point at coordinate (i, ai). n vertical lines are drawn such that 
the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
which together with x-axis forms a container, such that the container 
contains the most water.

Note: You may not slant the container.
*/

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height == null) {
            return 0;
        }
        int curMax = 0, cur = 0, left = 0, right = height.length - 1;
        while(left < right) {
            if(height[left] >= height[right]) {
                cur = height[right] * (right - left);
                right -= 1;
            } else {
                cur = height[left] * (right - left);
                left += 1;
            }
            if(cur > curMax) {
                curMax = cur;
            }
        }
        return curMax;
    }
}