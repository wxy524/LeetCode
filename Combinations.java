/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement:

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/


import java.util.ArrayList;

public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> cur = new ArrayList<Integer>();
        
        buildTree(res, cur, 0, n, k);
        return res;
    }
    
    private void buildTree(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur, int start, int n, int k) {
        if(cur.size() == k) {
            ArrayList<Integer> temp = new ArrayList<Integer>(cur);
            res.add(temp);
            return;
        }
        
        for(int i = start; i < n; i++) {
            cur.add(i+1);
            buildTree(res, cur, i+1, n, k);
            cur.remove(cur.size()-1);
        }
    }
}