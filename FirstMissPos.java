/*
Author: Xueyi Wang
Date: August 7 2014

Problem Description:
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

public class FirstMissPos {
    public int firstMissingPositives(int[] A) {
        if(A == null || A.length == 0) {
            return 1;
        }
        for(int i = 0; i < A.length; i++) {
            /*Based on counting sort. A[i] = i+1; else, swap. Overlook the number n 
            such that n > A.length and n < 0, since such number cannot be our result.*/
            if(A[i] > 0 && A[i] < A.length && A[A[i]-1] != A[i]) {            
                int temp = A[i];
                A[i] = A[temp-1];
                A[temp-1] = temp;
                i--;
            }
        }
        for(int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) {
                return i+1;
            }
        }
        return A.length + 1;   
    }
}