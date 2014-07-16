/*
Author: Xueyi Wang
Date: Jan 13, 2014
Problem Description:

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/

public class LastWord {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null) {
            return 0;
        }
        
        int tail = s.length()- 1, head = tail;
        
        while(head >= 0) {
            if(isLetter(s.charAt(head))) {
                head--;
            } else {
                if(s.charAt(head) == ' ' && head == tail) {
                    head --;
                    tail --;
                } else if(s.charAt(head) == ' ' && head < tail) {
                    return tail - head;
                } else {
                    return 0;
                }
            }
        }
        System.out.println("head is " + head);
        return tail - head;
    }
    
    private boolean isLetter(char c){
        if(c>='a' && c<='z' || c>='A' && c<='Z')
            return true;
        else
            return false;
    }
}
