/*
Author: Xueyi Wang
Date: Nov 2013
Problem Statement:

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int size = getSize(head);
        
        if(size < 2) 
            return head;
            
        int index = n % size;
        
        if(index == 0)
            return head;
    
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode first = head, second = head;
        ListNode newEnd = dummy, oldEnd = dummy;
        
        for(int i=0; i<index; i++) {
            first = first.next;
            oldEnd = oldEnd.next;
        }
        
        while(first != null) {
            first = first.next;
            second = second.next;
            newEnd = newEnd.next;
            oldEnd = oldEnd.next;
        }
        
        newEnd.next = null;
        oldEnd.next = head;
        
        return second;
    }
    
    private int getSize(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;    
        }
        return len;
    }
}
