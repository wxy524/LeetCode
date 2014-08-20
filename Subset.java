/*
Author: Xueyi Wang
Date: August 20 2014

Problem Description:
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

import java.util.*;

public class Subset {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer>cur = new ArrayList<Integer>();
        Arrays.sort(S);
        buildTree(res,cur,S,0);
        return res;
    }
    private void buildTree(List<List<Integer>> res, ArrayList<Integer> cur, 
                           int[] S, int level) {
        res.add(new ArrayList<Integer>(cur));
        for(int i = level; i < S.length; i++) {
            cur.add(S[i]);
            if(level < S.length) {
                buildTree(res, cur, S, i+1);
            }
            cur.remove(cur.size()-1);
        }
        return;
    }
}