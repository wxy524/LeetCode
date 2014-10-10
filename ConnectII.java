/*
Author: Xueyi Wang
Date: Oct 10 2014

Problem Description:
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

public class ConnectII {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        TreeLinkNode cur = root;
        TreeLinkNode nextLevel = null, pre = null;
        while(cur != null) {
            if(cur.left != null) {
                if(pre == null) {
                    pre = cur.left;
                    nextLevel = pre;
                } else {
                    pre.next = cur.left;
                    pre = pre.next;
                }
            }    
            if(cur.right != null) {
                if(pre == null) {
                    pre = cur.right;
                    nextLevel = pre;
                } else {
                    pre.next = cur.right;
                    pre = pre.next;
                }
            }
            cur = cur.next;
            if(cur == null) {
                cur = nextLevel;
                pre = null;
                nextLevel = null;
            }
        }
    }
}