/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

import java.util.*;

public class Permutation {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        boolean[] isVisited = new boolean[num.length];
        permuteDfs(num, isVisited, res, cur);
        return res;
    }
    private void permuteDfs(int[] num, boolean[] isVisited, List<List<Integer>> res, ArrayList<Integer> cur) {
        if(cur.size() == num.length) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                cur.add(num[i]);
                permuteDfs(num, isVisited, res, cur);
                cur.remove(cur.size()-1);
                isVisited[i] = false;
            }
        }
    } 
}