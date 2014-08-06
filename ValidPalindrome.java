/*
Author: Xueyi Wang
Date: August 5 2014

Problem Description:
Given a string, determine if it is a palindrome, considering only alphanumeric characters 
and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
*/

import java.util.*;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() < 2) {
            return true;
        }
        int start = 0, end = s.length()-1;
        while(start < end) {
            if(!isChar(s.charAt(start)) && !isNum(s.charAt(start))) {
                start++;
                continue;
            }     
            if(!isChar(s.charAt(end)) && !isNum(s.charAt(end))) {
                end--;
                continue;
            } 
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
    private boolean isNum(char c) {
        if(0 <= c - '0' && c - '0' <= 9) {
            return true;
        } else {
            return false;
        }
    }
    private boolean isChar(char c) {
        if(('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
            return true;
        } else {
            return false;
        }
    }
}