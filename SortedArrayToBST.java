/*
Author: Xueyi Wang
Date: Nov 2013
Probelm Statment:
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int left = 0, right = num.length - 1;
        TreeNode root = buildBST(left, right, num);
        return root;
    }
    
    private TreeNode buildBST (int left, int right, int[] num) {
        
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(num[mid]);
        
        root.left = buildBST(left, mid-1, num);
        root.right = buildBST(mid+1, right, num);
        
        return root;
    }
}