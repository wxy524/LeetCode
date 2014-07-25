/*
Author: Xueyi Wang
Date: July 24 2014

Problem Description:
Given n pairs of parentheses, write a function to generate all 
combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        String cur = new String();
        int open = 0;               // number of open parentheses
        int close = 0;              // number of close parentheses
        helper(res, cur, open, close, n);
        return res;
    }
    private void helper(List<String> res, String cur, int open, int close, int num) {
        if(open == num) {
            while(close < num) {
                cur = cur + ')';
                close++;
            }
            res.add(cur);
            return;
        }
        helper(res, cur + '(', open+1, close, num);
        if(open > close) {
            helper(res, cur + ')', open, close+1, num);
        }
        return;
    }
}