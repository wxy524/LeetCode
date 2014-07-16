/*
Author: Xueyi Wang
Date July 15 2014

Problem Description:
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/

public class ReverseInteger {
    public int reverse(int x) {
        int absX = Math.abs(x), res = 0;

        while(absX > 0) {
            int remainder = absX % 10;
            absX = absX / 10;
            res = res * 10 + remainder;
        }    

        if(res < 0) {
            return -1;
        }

        if( x < 0) {
            res = res * -1;
        }

        return res;
    }
}