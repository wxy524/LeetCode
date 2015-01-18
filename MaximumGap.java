/*
Author: Xueyi Wang

Problem Description:
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
*/

public class MaximumGap {
    public int maximumGap(int[] num) {
        if(num.length < 2) {
            return 0;
        }
        int min = num[0], max = num[0];
        int[] bucketMin = new int[num.length];
        int[] bucketMax = new int[num.length];
        
        for(int idx = 0; idx < num.length; idx++) {
            if(num[idx] > max) {
                max = num[idx];
            } else if (num[idx] < min) {
                min = num[idx];
            }
            bucketMin[idx] = Integer.MAX_VALUE;
            bucketMax[idx] = Integer.MIN_VALUE;
        }
        
        int gap = (int)Math.ceil((double)(max-min)/(num.length-1));
        for(int idx = 0; idx < num.length; idx++) {
            if(num[idx] == min || num[idx] == max) {
                continue;
            }
            int numIdx = (num[idx] - min) / gap;
            bucketMin[numIdx] = Math.min(num[idx], bucketMin[numIdx]);
            bucketMax[numIdx] = Math.max(num[idx], bucketMax[numIdx]);
        }
        
        int previous = min, res = Integer.MIN_VALUE;
        for(int idx = 0; idx < num.length; idx++) {
            if(bucketMin[idx] == Integer.MAX_VALUE && bucketMax[idx] == Integer.MIN_VALUE) {
                continue;
            } else {
                res = Math.max((bucketMin[idx] - previous), res);
                previous = bucketMax[idx];
            }
        }
        
        return Math.max(res, max-previous);
    }
}
