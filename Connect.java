/*
Author:Xueyi Wang
Date: One day in 2013...
Problem Statement:
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Connect {
    public void connect(TreeLinkNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        TreeLinkNode memory_root = root;
        TreeLinkNode temp_root = root;
        if (root == null) return;
        else if ( root.right == null) {
            root.next = null;
            return;
        } else {
            while (temp_root.right != null) {
                while (temp_root.next != null) {
                    temp_root.left.next = temp_root.right;
                    temp_root.right.next = temp_root.next.left;
                    temp_root = temp_root.next;
                }
                temp_root.left.next = temp_root.right;
                temp_root = memory_root.left;
                memory_root = temp_root;
            }
        }
        
        return;
    }
}