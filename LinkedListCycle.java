/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement:
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode head1 = head;
        ListNode head2 = head;
        if(head == null) return false;
        
        while (head2 != null) {
            head1 = head1.next;
            if (head2.next != null) head2 = head2.next.next;
            else    return false;
            
            if (head1 == head2) return true;
        }
        return false;
    }
}