/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement:

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
public class MinDepthBT {
    public int minDepth(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(root == null) {
            return 0;
        }    
        
        int depth = 0;
        
        if(root.left == null && root.right == null) {
            depth = 1;
        } else if(root.left == null && root.right != null) {
            depth = 1 + minDepth(root.right);
        } else if(root.left != null && root.right == null) {
            depth = 1 + minDepth(root.left);
        } else {
            depth = 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
        return depth;
    }
}