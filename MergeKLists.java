/*
Author: Xueyi Wang
Date: July 18 2014

Problem Description:
Merge k sorted linked lists and return it as one sorted list. 
Analyze and describe its complexity.
*/

import java.util.*;

public class MergeKLists {
   public ListNode mergeKLists(ArrayList<ListNode> lists){
       if(lists == null || lists.size() == 0) {
           return null;
       }
       
       PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), 
                                new Comparator<ListNode>() {
                                    public int compare(ListNode a, ListNode b) {
                                        if(a.val > b.val) {
                                            return 1;
                                        } else if(a.val == b.val) {
                                            return 0;
                                        } else {
                                            return -1;
                                        }
                                    }
                                });
        for(ListNode lst : lists) {
            if(lst != null) {
                q.add(lst);
            }
        }    
        ListNode root = new ListNode(Integer.MAX_VALUE);
        ListNode head = root, prev;
        while(q.size() > 0) {
            prev = q.poll();
            head.next = prev;
            head = head.next;
            if(prev.next != null) {
                q.add(prev.next);
            }
        }
        return root.next;
    }
}
