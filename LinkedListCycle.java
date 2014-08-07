/*
Author: Xueyi Wang
Date: August 6 2014
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
        if(head == null || head.next == null) {
            return false;
        }    
        ListNode first = head, second = head;
        while(second != null) {
            first = first.next;
            if(second.next != null) {
                second = second.next.next;
            } else {
                return false;
            }
            if(first == second) {           //fast pointer meet slow pointer, cycle exists
                return true;
            }
        }
        return false;
    }
}