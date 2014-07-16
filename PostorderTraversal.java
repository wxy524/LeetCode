/*
Author: Xueyi Wang
Date: Jua 10 2014
Probelm Description:

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.Stack;
import java.util.ArrayList;

public class PostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode prev = root;
        
        if(root == null) {
            return res;
        }
        
        stk.push(root);
        while(!stk.isEmpty()) {
            root = stk.peek();
            if(root.left != null && root.left != prev && root.right != prev) {
                stk.push(root.left);
            } else if (root.right != null && root.right != prev) {
                stk.push(root.right);
            } else {
                if(root.left != null && root.left == prev && root.right != null) {
                    stk.push(root.right);
                } else {
                    prev = root;
                    res.add(root.val);
                    stk.pop();
                }
            }
        }
        return res;
    }
}

