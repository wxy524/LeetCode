/*
Author: Xueyi Wang
Date: 12 August 2014

Problem Description:
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

public class Jump {
    public boolean canJump(int[] A) {
        if(A == null) {
            return true;
        }
        boolean canReach = true;
        int dest = A.length - 1;
        while(dest > 0) {
            canReach = false;
            for(int i = 0; i < dest; i++) {
                if(A[i] >= dest - i) {
                    dest = i;
                    canReach = true;
                }
            }
            if(!canReach) {
                return canReach;
            }
        }
        return canReach;
    }
}