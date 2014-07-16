/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement: 

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
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

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (head == null) return null;
        if (head.next == null) return null;
        int cnt = 0;
        ListNode oldhead = head;
        while (head != null) {
            head = head.next;
            cnt ++;
        }
        
        head = oldhead;
        
        int diff = cnt - n;
        
        if (diff > 0) {
            while (diff > 1) {
                head = head.next;
                diff--;
            }
        
            head.next = head.next.next;
            head = oldhead;
        
        } else head = head.next;
        return head;
    }
}