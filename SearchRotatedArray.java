/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement:

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class SearchRotatedArray {
    public int search(int[] A, int target) {
        
        if (A.length == 0)
            return -1;
            
        if (A.length == 1) {
            if (target == A[0])
                return 0;
            else 
                return -1;
        }
            
        int head = 0, back = A.length-1;
        
        if(A[head] < A[back]) {
            return biSearch(A, target, head, back);
        } else {
            if(A[head] > target) {
                for(int i = head+1; i < A.length; i++) {
                    if(A[i] < A[head]) {
                        head = i;
                        return biSearch(A, target, head, back);
                    }
                }
            } else if (A[head] < target) {
                for(int i = back; i >= 0; i--) {
                    if(A[i] > A[back]) {
                        back = i;
                        return biSearch(A, target, head, back);
                    }
                }
            }
        }
        
        return head;
    }
    
    private int biSearch(int[]A, int target, int low, int high) {
        
        while(low <= high) {
            int mid = (low + high)/2;
            if(target == A[mid]) {
                return mid;
            } else if(target < A[mid]) {
                return biSearch(A, target, low, mid-1);
            } else {
                return biSearch(A, target, mid+1, high);
            }
        }
        
        return -1;
    }
}