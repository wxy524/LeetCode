/*
Author: Xueyi Wang
Date: One day in 2013...
Problem Statement:
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = A.length, cnt = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] != elem) {
                A[cnt++] = A[i];
            }
        }
        return cnt;
    }
}