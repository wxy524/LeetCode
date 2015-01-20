/*
Author: Xueyi Wang

Problem Description:
Find the contiguous subarray within an array (containing at least one number) 
which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public class MaxProductSubarray {
    public int maxProduct(int []A) {
        int local_max = A[0], local_min = A[0], global_max = A[0];
        
        for(int idx = 1; idx < A.length; idx++) {
            int cur_max = Math.max(A[idx]*local_max, A[idx]*local_min);
            int cur_min = Math.min(A[idx]*local_max, A[idx]*local_min);
            local_max = Math.max(cur_max, A[idx]);
            local_min = Math.min(cur_min, A[idx]);
            global_max = Math.max(local_max, global_max);
        }
        
        return global_max;
    }
}
