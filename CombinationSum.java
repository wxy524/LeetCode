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