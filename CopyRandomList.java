/*
Author: Xueyi Wang
Date: July 2014

Problem Description:
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

public class CopyRandomList {
public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
    
        RandomListNode p = head;

        while(p != null) {
            RandomListNode temp = new RandomListNode(p.label);
            temp.next = p.next;
            p.next = temp;
            p = temp.next;
        }

        p = head;
        RandomListNode q = head.next;

        while(p != null) {
            if(p.random != null) {
                q.random = p.random.next;
            } else {
                q.random = null;
            } 
            p = q.next;
            if(p != null) {
                q = p.next;
            }
        }

        p = head;
        q = head.next;
        RandomListNode newHead = q;
        while(p != null) {
            if(q.next != null) {
                p.next = q.next;
                p = p.next;
                q.next = p.next;
                q = q.next;
            } else {
                p.next = null;
                p = p.next;
            }
        }
        return newHead;
    }
}