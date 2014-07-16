/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statment:
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
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
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        ListNode head, root;
        root = new ListNode(-1);
        head  = root;
        
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else {
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    head.next = l1;
                    l1 = l1.next;
                } else {
                    head.next = l2;
                    l2 = l2.next;
                }
                head = head.next;
            }
        }
        if (l1 == null && l2 != null) {
            head.next = l2;
        } else {
            head.next = l1;
        }
        head = root.next;
        return head;
      
    }
}