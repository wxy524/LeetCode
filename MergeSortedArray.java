/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement:
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
*/

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
       int indexofA = m-1, indexofB = n-1, len = m+n-1;
       
       while ( indexofA >= 0 && indexofB >= 0 ) {
           if ( A[indexofA] >= B[indexofB] ) {
               A[len--] = A[indexofA--];
           } else {
               A[len--] = B[indexofB--];
           }
       }
       
       while ( indexofB >= 0 ) {
           A[len--] = B[indexofB--];
       }
       
    }
}