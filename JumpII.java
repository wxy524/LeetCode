/*
Author: Xueyi Wang
Date: 12 August 2014

Problem Description:
Given an array of non-negative integers, you are initially positioned at the first index 
of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, 
then 3 steps to the last index.)
*/

public class JumpII {
    public int jump(int[] A) {
        int res = 0, n = A.length - 1;
        if(A == null) {
            return res;
        }
        while(n > 0) {
            for(int i = 0; i < n; i++) {
                if(A[i] >= n - i) {
                    n = i;
                    res++;
                }
            }
        }
        return res;
    }
}