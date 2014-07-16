/*
Author:Xueyi Wang
Date: Nov 2013
Problem Statement:

Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        res.add(cur);
        int level = 1, idx = 0;
        
        Arrays.sort(S);
        buildTree(cur, res, S, level, idx);
        return res;
    }
    
    private void buildTree(ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res, int[] S, int level, int idx) {
        
        if(cur.size() == level) {
            ArrayList<Integer> temp = new ArrayList<Integer>(cur);
            res.add(temp);
            return;
        }
        
        for(int i = idx; i < S.length; i++) {
            cur.add(S[i]);
            buildTree(cur, res, S, level, i);
            if( level < S.length && i < S.length-1) {
                buildTree(cur, res, S, level+1, i+1);
            }
            cur.remove(cur.size()-1);
        }
        
        return;
    }
}