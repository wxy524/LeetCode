/*
Name: Xueyi Wang
Date: Sep 12 2014

Problem Description:
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
*/

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode first = head.next;
        ListNode second = head.next.next;
        while(second != null) {
            first = first.next;
            second = second.next;
            if(second == null) {
                return null;
            }
            second = second.next;
            if(first == second) {
                break;
            }
        }
        if(second == null) {
            return null;
        }
        first = head;
        while(first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }
}