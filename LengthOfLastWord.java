/*
Date: Oct 1 2014
Author: Xueyi Wang

Problem Description:
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int res = 0;
        if(len == 0) {
            return 0;
        }
        for(int i = len-1; i>=0 ;i--) {
            if(s.charAt(i) == ' ' && res == 0) {
                continue;
            }
            if(s.charAt(i) == ' ' && res != 0) {
                return res;
            }
            if(s.charAt(i) != ' ') {
                res ++;
            }
        }
        return res;
    }
}