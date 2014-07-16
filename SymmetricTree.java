/*
Author: Xueyi Wang
Date: One day in 2013...
Problem Statement:
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        boolean istrue = true;
        if (root == null) return istrue;
        else if (root.left != null && root.right != null) { 
            istrue = deepSearch(root.left, root.right); 
            return istrue;
        } else if (root.left != root.right) { istrue = false; }
        return istrue;
    }
    
    private boolean deepSearch(TreeNode lchild, TreeNode rchild) {
        if (lchild == null && rchild == null) return true;
        else if (lchild.val != rchild.val) return false;
        else if (lchild.left == null && rchild.right != null) return false;
        else if (lchild.left != null && rchild.right == null) return false;
        else if (lchild.right == null && rchild.left != null) return false;
        else if (lchild.right != null && rchild.left == null) return false;
        else {
            boolean isLtrue, isRtrue;
            isLtrue = deepSearch(lchild.left, rchild.right);
            isRtrue = deepSearch(lchild.right, rchild.left);
            if (isLtrue != true || isRtrue != true) return false;
        }
        return true;
    }
}