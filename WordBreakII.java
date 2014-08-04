/*
Author: Xueyi Wang
Date: August 2 2014

Problem Description:
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence 
where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/

import java.util.*;

public class WordBreakII {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        int len = s.length();
        if(!isValid(s, dict)) {
            return new ArrayList<String>();
        }
        boolean[] checker = new boolean[len+1];
        checker[0] = true;
        res.add(new ArrayList<String>());
        res.get(0).add("");
        for(int i = 1; i < len+1; i++) {
            res.add(new ArrayList<String>());
            for(int ii = 0; ii < i; ii++) {
                if(!checker[ii]) {
                    continue;
                }
                String temp = s.substring(ii, i);
                if(dict.contains(temp)) {
                    checker[i] = true;
                    for(String str : res.get(ii)) {
                        res.get(i).add(str + temp + " ");
                    }
                }
            }
        }
        for(int i = 0; i < res.get(len).size(); i++) {
            String str = res.get(len).get(i);
            res.get(len).set(i, str.substring(0, str.length()-1));
        }
        return res.get(len);
    }
    private boolean isValid(String s, Set<String> dict) {
        int len = s.length();
        boolean[] checker = new boolean[len+1];
        checker[0] = true;
        for(int i = 1; i < len+1; i++) {
            for(int ii = 0; ii < i; ii++) {
                if(!checker[ii]) {
                    continue;
                }
                String temp = s.substring(ii, i);
                if(dict.contains(temp)) {
                    checker[i] = true;
                }
            }
        }
        return checker[len];
    }
}