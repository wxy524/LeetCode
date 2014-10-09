/*
Date: Oct 08 2014
Author: Xueyi Wang

Problem Description:
Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = new ListNode(Integer.MAX_VALUE);
        ListNode record = prev;
        prev.next = head;
        while(cur.next != null) {
            ListNode next = cur.next;
            if(cur.val != next.val) {
                if(prev.next == cur) {
                    prev = cur;
                } else {
                    prev.next = next;
                }
                if(next.next != null) {
                    cur = next;
                } else {
                    break;
                }
            } else {
               if(next.next == null) {
                   prev.next = null;
                   break;
               } else {
                   cur = next;
               }
            }
        }
        return record.next;
    }
}