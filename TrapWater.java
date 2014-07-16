/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement:

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public class TrapWater {
    public int trap(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(A.length < 3)
            return 0;
    
        int[] leftToRight = new int[A.length];
        int[] rightToLeft = new int[A.length];
        int volumn = 0, max = A[0];
        
        leftToRight[0] = A[0];
        rightToLeft[A.length-1] = A[A.length-1];
        
        for(int i=1; i< A.length; i++) {
            if(A[i] > max) {
                leftToRight[i] = A[i];
                max = A[i];
            } else {
                leftToRight[i] = max;
            }           
        }
        
        max = A[A.length-1];
        
        for(int i=A.length-2; i>=0; i--) {
            if(A[i] > max) {
                rightToLeft[i] = A[i];
                max = A[i];
            } else {
                rightToLeft[i] = max;
            }
        }
        
        for(int i=0; i<A.length; i++) {
            if(A[i] < leftToRight[i] && A[i] < rightToLeft[i]) {
                volumn += Math.min(leftToRight[i], rightToLeft[i]) - A[i];
            }
        }
        
        return volumn;
    }
}