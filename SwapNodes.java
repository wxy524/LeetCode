/*
Author: Xueyi Wang
Date: OCT 2013
Problem Statement:
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
        
        ListNode temp = head;
        ListNode temp2 = head;
        if (head == null || head.next == null) return head;
        ListNode oldhead = head.next;
        
        temp = head;
        temp2 = head.next.next;
        head = head.next;
        head.next = temp;
        head.next.next = temp2;
        head = head.next;
        
        while (head != null) {
            if (head.next == null || head.next.next == null) break;
            temp = head.next;
            temp2 = temp.next.next;
            head.next = temp.next;
            head = temp.next;
            head.next = temp;
            head.next.next = temp2;
            head = head.next;
        }
        
        head = oldhead;
        return head;
    }
}