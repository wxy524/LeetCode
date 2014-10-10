/*
Author: Xueyi Wang
Date: Oct 10 2014

Problem Description:
Given a binary tree and a sum, find all root-to-leaf paths 
where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/

import java.util.*;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }
        Deque<TreeNode> q = new LinkedList<TreeNode>();
        Deque<Integer> cur = new LinkedList<Integer>();
        List<List<Integer>> curList = new ArrayList<List<Integer>>();
        q.add(root);
        cur.add(root.val);
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(root.val);
        curList.add(temp);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            int curSum = cur.poll();
            temp = new ArrayList<Integer>(curList.get(0));
            curList.remove(0);
            if(node.left == null && node.right == null && curSum == sum) {
                res.add(temp); 
            } 
            if(node.left != null) {
                q.add(node.left);
                cur.add(curSum+node.left.val);
                temp.add(node.left.val);
                curList.add(new ArrayList<Integer>(temp));
                temp.remove(temp.size()-1);
            }
            if(node.right != null) {
                q.add(node.right);
                cur.add(curSum+node.right.val);
                temp.add(node.right.val);
                curList.add(new ArrayList<Integer>(temp));
            
            }
        }
        return res;
    }
}