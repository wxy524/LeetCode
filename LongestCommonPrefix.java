/*
Author: Xueyi Wang

Date: August 24 2014

Problem Description:
Write a function to find the longest common prefix string amongst an array of strings.
*/

import java.util.*;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new String();
        }
        String res = new String();
        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(int ii = 1; ii < strs.length; ii++) {
                if(strs[ii].length() <= i || strs[ii].charAt(i) != c) {
                    return res;
                }
            }
            res += c;
        }
        return res;
    }
}