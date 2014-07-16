/*
Author: Xueyi Wang
Date: One day in 2013...
Problem Statement:
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

public class ClimbingStairs {
    public int climbStairs(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int num1 = 1, num2 = 1, num = 0;
        if ( n == 0 ) num = 0;
        else if ( n == 1 ) num = 1;
        else {
            for ( int i = 1; i < n; i++ ) {
                num = num1 + num2;
                num1 = num2;
                num2 = num;
            }
        }
        return num;       
    }
}