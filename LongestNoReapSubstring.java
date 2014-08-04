/*
Author: Xueyi Wang
Date: August 3 2014

Problem Description:
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

import java.util.*;

public class LongestNoReapSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int max = 0, cur = 0, idx = 0;
        Map<Character, Integer> hm = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            if(hm.containsKey(s.charAt(i))) {
                cur = 0;
                i = hm.get(s.charAt(i));
                hm.clear();
            } else {
                cur += 1;
                hm.put(s.charAt(i), i);
                if(cur > max) {
                    max = cur;
                }
            }
        }
        return max;
    }
}