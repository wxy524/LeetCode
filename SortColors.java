/*
Author: Xueyi Wang
Date: Jan 6 2014
Problem Statement:

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
*/

public class SortColors {
    public void sortColors(int[] A) {
        int low = 0, high = A.length-1, i = 0;
        
        while(i <= high){
            if(A[i] == 0) {
                A[i++] = A[low];
                A[low++] = 0;
            } else if (A[i] == 2) {
                int tmp = A[i];
                A[i] = A[high];
                A[high--] = tmp;
            } else {
                i++;
            } 
        }
    }
}