/*
Author: Xueyi Wang
Date: Nov 2013
Porblem Statement:
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer 
approach, which is more subtle.
*/

public class MaxSubArray {
    public int maxSubArray(int[] A) {
        int[] sum = new int[A.length];
        int global_max = A[0];
        sum[0] = A[0];
        for(int idx = 1; idx < A.length; idx++) {
            sum[idx] = Math.max(sum[idx-1]+A[idx], A[idx]);
            global_max = Math.max(sum[idx], global_max);
        }
        return global_max;
    }
}
