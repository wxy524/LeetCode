/*
Author: Xueyi Wang
Date: August 6 2014

Problem Description:
Given an array S of n integers, find three integers in S such 
that the sum is closest to a given number, target. Return the sum of the three integers. 
You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest (int[] num, int target) {
        if(num.length < 3) {
            return 0;
        }
        Arrays.sort(num);
        int res = 0, start = 0, end = 0, diff = 0, mindiff = Integer.MAX_VALUE;
        for(int i = 0; i < num.length - 2; i++) {
            start = i + 1;
            end = num.length - 1;
            while(start < end) {
                int temp = num[i] + num[start] + num[end];
                diff = temp - target;
                if(temp == target) {
                    return temp;
                } else if (temp > target) {
                    end--;
                } else {
                    start++;
                }
                if(Math.abs(diff) < mindiff) {
                    res = temp;
                    mindiff = Math.abs(diff);
                }
            }
        }
        return res;
    }
}