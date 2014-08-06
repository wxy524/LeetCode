/*
Author: Xueyi Wang
Date: August 05 2014

Problem Description:
Given a string S, find the longest palindromic substring in S. You may assume 
that the maximum length of S is 1000, and there exists one unique longest palindromic 
substring.
*/

import java.util.*;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) {
            return s;
        }
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            String temp = findPalindrome(s, i, i);              //find palindrome like: aba
            if(temp.length() > res.length()) {
                res = temp;
            }
            temp = findPalindrome(s, i, i+1);                   //find palindrome like: abba
            if(temp.length() > res.length()) {
                res = temp;
            }
        }
        return res;
    }
    private String findPalindrome(String s, int start, int end) {
        while(0 <= start && end < s.length()) {
            if(Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))) {
                start--;
                end++;
            } else {
                return s.substring(start+1, end);
            }
        }
        return s.substring(start+1, end);
    }
}