/*
Author: Xueyi Wang
Date: August 7 2014

Problem Description:
Implement atoi to convert a string to an integer.
*/

public class StringToInteger {
    public int atoi(String str) {
        int res = 0, start = 0, zero = 0;
        boolean neg = false, begin = false;
        if(str == null || str.length() == 0) {
            return res;
        }        
        if(!isNum(str.charAt(0))) {
            while(str.charAt(start) == ' ') {
                start++;
            }
            if(str.charAt(start) == '-') {
                neg = true;
                start += 1;
            } else if(str.charAt(start) == '+') {
                start += 1;
            } 
        }
        for(int i = start; i < str.length(); i++) {
            if(isNum(str.charAt(i))) {
                int temp = str.charAt(i) - '0';
                if((Integer.MAX_VALUE - temp) / 10 < res) {        //To determine if result will be out of range
                    if(neg) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                res = res * 10 + temp;
            } else {                                //If contains NAN, return closest number
                return neg ? -res : res;
            }   
        }
        return neg ? -res : res;
    }
    private boolean isNum(char c) {
        if(0 <= c - '0' && c - '0' <= 9) {
            return true;
        } else {
            return false;
        }
    }
}