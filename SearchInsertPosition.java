/*
Author: Xueyi Wang
Date: One day in 2013...
Problem Statement:

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

*/

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int min = 0;
        int max = A.length;
        int index = bSearch(A, target, min, max);
        return index;
    }
    
    private int bSearch(int []A, int target, int min, int max) {
        int mid = (min + max - 1)/2;
      
        if ( max <= min) {
            if (A[mid] < target) mid = mid + 1;
        }
        else{
            if ( A[mid] == target ) {
                min = max;
            }
            else if ( A[mid] < target ) {
                min = mid + 1;
                mid = bSearch(A, target, min, max);
            } else {
                max = mid;
                mid = bSearch(A, target, min, max);
            }
        }
        return mid;
        
    }
}