/*
Author: Xueyi Wang
Date: One day in 2013...
Problem Statement:
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
*/

public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = A.length, pre = 0, cur = 1;
        if (n <= 1) return n;
        else {
            while (cur < n ) {
                if (A[pre] == A[cur]) {
                    cur = cur + 1;
                    continue;
                }
                pre = pre + 1;
                A[pre] = A[cur];
            }
        }
        return pre+1;
    }
}