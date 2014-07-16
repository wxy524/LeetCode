/*
Author: Xueyi Wang
Date: NOV 2013
Problem Statement:
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
public class IsBalancedBT {
    public boolean isBalanced(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (root == null) return true;
        int heightl = 1 + Height(root.left);
        int heightr = 1 + Height(root.right);
        
        if (Math.abs(heightl - heightr) < 2) { return (isBalanced(root.left) && isBalanced(root.right));}
        return false;
        
    }
    private int Height(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) {
            return (1 + Height(root.right));
        }
        if (root.right == null) {
            return (1 + Height(root.left));
        }
        return 1 + Math.max(Height(root.left), Height(root.right));
    }
}