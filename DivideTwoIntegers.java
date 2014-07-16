/*
Author: http://yucoding.blogspot.com/2013/01/leetcode-question-28-divide-two-integers.html
Date: Nov 2013
Problem Statement:

Divide two integers without using multiplication, division and mod operator.
*/

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    boolean signA = dividend >= 0, signB = divisor > 0;

    long num = Math.abs((long) dividend);
    long div = Math.abs((long) divisor);
    long res = 0;
    long curr = 0;
    
    for (int idx = 31; idx >= 0; idx--) {
        curr <<= 1;
        curr |= ((num >> idx) & 1);

        res = res << 1;
        if (curr >= div) {
            curr -= div;
            res |= 1;
        }
    }

    if (signA ^ signB)
        return -(int) res;
        
    return (int) res;
    }
}
