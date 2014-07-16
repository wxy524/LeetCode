/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement:
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (num.length < 3) 
            return 0;

        Arrays.sort(num);
        int p1 = 1, p2 = num.length - 1, mindiff = Integer.MAX_VALUE, sum = 0, diff = 0; 
        
        for( int i = 0; i <= num.length - 3; i++) {
            p1 = i + 1;
            p2 = num.length - 1;
            while (p1 < p2) {
                diff = num[i] + num[p1] + num[p2] - target;
                if (Math.abs(diff) == 0) {
                    sum = num[i] + num[p1] + num[p2];
                    return sum;
                } else if (Math.abs(diff) < mindiff) {
                    sum = num[i] + num[p1] + num[p2];
                    mindiff = Math.abs(diff);
                }
                if (diff < 0) {
                    p1++;
                } else{
                    p2--;
                }
            }
        }
        return sum;
    }
}