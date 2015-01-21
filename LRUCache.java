/*
Author: Xueyi Wang
Date: Dec 2013
Problem Statement:

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

import java.util.Map;
import java.util.HashMap;

public class LRUCache {
    
    DoubleLinkedList frontSentinel, backSentinel;
    HashMap<Integer, DoubleLinkedList> hm;
    int capacity;
    
    public LRUCache(int capacity) {
        hm = new HashMap<Integer, DoubleLinkedList>();
        frontSentinel = new DoubleLinkedList(Integer.MAX_VALUE, Integer.MAX_VALUE);
        backSentinel = new DoubleLinkedList(Integer.MAX_VALUE, Integer.MAX_VALUE);
        frontSentinel.next = backSentinel;
        frontSentinel.prev = backSentinel;
        backSentinel.next = frontSentinel;
        backSentinel.prev = frontSentinel;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)) {
            DoubleLinkedList cur = hm.get(key);
            delete(cur);
            moveToHead(cur);
            return cur.value;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(hm.containsKey(key)) {
            DoubleLinkedList cur = hm.get(key);
            delete(cur);
            moveToHead(cur);
            cur.value = value;
        } else {
            if(hm.size() == capacity) {
                hm.remove(backSentinel.prev.key);
                delete(backSentinel.prev);
            } 
            DoubleLinkedList cur = new DoubleLinkedList(key, value);
            moveToHead(cur);
            hm.put(key, cur);
        }    
    }
    
    private void delete(DoubleLinkedList link) {
        link.prev.next = link.next;
        link.next.prev = link.prev;
        link.next = null;
        link.prev = null;
    }
    
    private void moveToHead(DoubleLinkedList link) {
        frontSentinel.next.prev = link;
        link.next = frontSentinel.next;
        frontSentinel.next = link;
        link.prev = frontSentinel;
    }
}

class DoubleLinkedList {
        DoubleLinkedList next;
        DoubleLinkedList prev;
        int key, value;
        DoubleLinkedList(int key, int value) {
            next = null;
            prev = null;
            this.key = key;
            this.value = value;
        }
}
