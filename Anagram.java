/*
Author: Xueyi Wang
Date: August 7 2014

Problem Description:
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/

import java.util.*;

public class Anagram {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        Map<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();

        if(strs == null || strs.length == 1) {
            return res;
        }

        for(String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String s = new String(temp);
            if(hm.containsKey(s)) {
                hm.get(s).add(str);
            } else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                hm.put(s, list);
            }
        }   
        for(ArrayList<String> lst : hm.values()) {
            if(lst.size() > 1) {
                res.addAll(lst);
            }
        }
        return res;
    }
}