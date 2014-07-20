/*
Author: Xueyi Wang
Date: OCT 2013
Problem Statement:
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values 
in the list, only nodes itself can be changed.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(head == null || head.next == null) {
            return head;
        }    
        ListNode root = new ListNode(Integer.MAX_VALUE), keep_root;
        root.next = head;
        keep_root = root;
        ListNode first = head;
        ListNode second = head.next;
        while(first != null) {
            root.next = second;
            first.next = second.next;
            second.next = first;
            root = first;
            first = first.next;
            if(first != null) {
                if(first.next != null) {
                    second = first.next;
                } else {
                    return keep_root.next;
                }
            } 
        }
        return keep_root.next;
    }
}