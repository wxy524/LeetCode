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
Populate each next pointer to point to its next right node. If there is no next right node, 
the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, 
and every parent has two children).
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
        if(root == null || root.left == null) {
            return;
        }
        TreeLinkNode lastLevel = root;
        while(lastLevel.left != null) {
            TreeLinkNode p1 = lastLevel;
            TreeLinkNode p2 = lastLevel.next;
            while(p2 != null) {
                p1.left.next = p1.right;
                p1.right.next = p2.left;
                p1 = p2;
                p2 = p2.next;
            }
            p1.left.next = p1.right;
            lastLevel = lastLevel.left;
        }
    }
}