/*
Author: Xueyi Wang
Date: Sep 20 2014

Problem Description:
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).
*/

public class BinaryTreeLevelOrderII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<TreeNode>();        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root == null) {
            return res;
        }
        Deque<TreeNode> tempQ = new LinkedList<TreeNode>();
        List<Integer> tempList = new ArrayList<Integer>();
        q.add(root);
        
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            tempList.add(node.val);
            if(node.left != null) {
                tempQ.add(node.left);
            }
            if(node.right != null) {
                tempQ.add(node.right);
            }
            if(q.isEmpty()) {
                q = new LinkedList<TreeNode>(tempQ);
                tempQ = new LinkedList<TreeNode>();
                res.add(tempList);
                tempList = new ArrayList<Integer>();
            }
        }
        List<List<Integer>> revRes = new ArrayList<List<Integer>>();
        for(int i = res.size()-1; i >=0; i--){
            revRes.add(res.get(i));
        }
        return revRes;
    }
}