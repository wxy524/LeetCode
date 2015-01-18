/*
Author: Xueyi Wang

Problem Description:
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/ 

public class FindMinimumInRotatedArray {
    public int findMin(int[] num) {
        int len = num.length;
        int start = 0, end = len-1;
        
        while(start < end) {
            if(num[start] > num[end]) {
                int mid = (start + end) / 2;
                if(num[start] > num[mid]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else {
                break;
            }
        }
        return num[start];
    }
}
