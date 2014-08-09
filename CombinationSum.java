/*
Author: Xueyi Wang
Date: August 9 2014

Given a set of candidate numbers (C) and a target number (T), find all unique combinations 
in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(candidates == null || candidates.length == 0) {
            return res;
        }

        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, res, cur, 0, 0, target);
        return res;
    }
    private void dfs(int[] candidates, List<List<Integer>>res, List<Integer> cur,
                     int start, int sum, int target) {
        if(sum == target) {                     //Find combination
            if(!res.contains(cur)) {
                res.add(new ArrayList<Integer>(cur));           //Add unique combination
            }
            return;
        }
        if(sum > target) {                            //return since array is in the ascending order
            return;
        }
        for(int i = start; i < candidates.length; i++) {        //Depth first search
            cur.add(candidates[i]);                              //add current number
            dfs(candidates, res, cur, i, sum+candidates[i], target);    
            cur.remove(cur.size()-1);                       //remove current nunber, try next number
        }
        return;
    }
}