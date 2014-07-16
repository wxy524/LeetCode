/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement:

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
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
import java.util.Stack;

public class PreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if (root == null) return res;
    
        while(root != null){
            res.add(root.val);
            if (root.right != null) {
                s.add(root.right);
            }
            root = root.left;
            if (root == null && !s.empty()) {
                root = s.pop();
            }
        }
        return res;
    }
}