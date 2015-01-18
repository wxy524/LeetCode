/*
Author: Xueyi Wang

Problem Description:
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/ 

public class FindMinimumInRotatedArrayII {
    public int findMin(int[] num) {
        int start = 0, end = num.length - 1;
        while(start < end && num[start] >= num[end]) {
            int mid = (start + end) / 2;
            if(num[mid] < num[start]) {
                end = mid;
            } else if (num[mid] > num[end]) {
                start = mid + 1;
            } else {
                start++;
            }
        }
        return num[start];
    }
}
