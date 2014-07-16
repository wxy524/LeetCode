/*
Author: Xueyi Wang
Date: OCT 2013
Problem Statement:
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
]
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;
import java.util.Queue;


public class LevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        
        if (root == null) return levels;

        int curr = 1, next = 0;
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            level.add(n.val);
            curr = curr - 1; 
            if (n.left != null) {
                q.add(n.left);
                next = next + 1;
            }
            if (n.right != null) {
                q.add(n.right);
                next = next + 1;
            }
            if (curr == 0) {
                levels.add(level);
                level = new ArrayList<Integer>();
                curr = next;
                next = 0;
            }
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = levels.size()-1; i >= 0; i--) {
            result.add(levels.get(i));
        }
        return result;
    }
}