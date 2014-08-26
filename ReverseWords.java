/*
Author: Xueyi Wang
Date: August 25 2014
Problem Description:

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/

import java.util.*;

public class ReverseWords{
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return s;
        } 
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = str.length - 1; i >= 0; i--) {
            if(str[i].length() != 0) {
                sb.append(str[i]).append(" ");
            }
        }
        if(sb.length() == 0) {
            return "";
        } else {
            return sb.substring(0, sb.length()-1);
        }
    }
}