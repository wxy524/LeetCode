/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement:

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid 
but "(]" and "([)]" are not.
*/

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        Stack <Character> stk = new Stack<Character>();
        
        if(s == null) {
            return true;
        }    
        
        for(int i = 0; i < s.length(); i++) {
            if(stk.empty()) {
                stk.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')' && stk.peek() == '(') {
                stk.pop();
            } else if (s.charAt(i) == ']' && stk.peek() == '[') {
                stk.pop();
            } else if (s.charAt(i) == '}' && stk.peek() == '{') {
                stk.pop();
            } else {
                stk.push(s.charAt(i));
            }
        }
        return stk.empty();
    }
}
