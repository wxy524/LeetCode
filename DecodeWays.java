/*
Author: Xueyi Wang
Date: August 8 2014

Problem Description:
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

public class DecodeWays {
    public int numDecodings(String s) {
        int[] res = new int[s.length()+1];
        if(s == null || s.length() == 0) {
            return 0;
        } 
        res[0] = 1;
        if(toNum(s.charAt(0)) == 0) {
            res[1] = 0;
        } else {
            res[1] = 1;
        }
        for(int i = 1; i < s.length(); i++) {
            if(toNum(s.charAt(i)) == 0) {
                /*Not valid, such as 100, 30*/
                if (toNum(s.charAt(i-1)) == 0 || toNum(s.charAt(i-1)) > 2) {
                    return 0;
                } else {
                    /*110*/
                    res[i+1] = res[i-1];
                }
            } else {
                /*inValid, such as 01*/
                if(res[i] == 0) {
                    return 0;
                /*valid, 26 or 12*/
                } else if ((toNum(s.charAt(i-1)) == 2 && toNum(s.charAt(i)) <= 6)
                        || toNum(s.charAt(i-1)) == 1) {
                    res[i+1] = res[i] + res[i-1];
                } else if (toNum(s.charAt(i-1)) == 0) {
                    res[i+1] = res[i-1];
                } else {
                    res[i+1] = res[i];
                }
            }
        }
        return res[s.length()];
    }
    private int toNum(char c) {
        return c - '0';
    }
}