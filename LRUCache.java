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
    Map <Integer, DoubleLinkedList> hs;
    DoubleLinkedList head;
    DoubleLinkedList tail;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoubleLinkedList(Integer.MAX_VALUE, Integer.MAX_VALUE);
        tail = new DoubleLinkedList(Integer.MIN_VALUE, Integer.MIN_VALUE);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
        hs = new HashMap<Integer, DoubleLinkedList>();
    }
    
    public int get(int key) {
       if(hs.containsKey(key)) {
            DoubleLinkedList cur = hs.get(key);
            moveToHead(cur);
            return cur.value;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(hs.containsKey(key)){
            DoubleLinkedList cur = hs.get(key);
            cur.value = value;
            moveToHead(cur);
        } else {
            if(hs.size() >= capacity) {
                hs.remove(tail.prev.key);
                removeTail();
            }
            DoubleLinkedList adding = new DoubleLinkedList(key, value);
            addToHead(adding);
            hs.put(key, adding);
        }    
    }
    
    private void moveToHead(DoubleLinkedList cur) {
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        cur.prev = null;
        cur.next = null;
        addToHead(cur);
    }
    
    private void addToHead(DoubleLinkedList cur) {
        cur.next = head.next;
        cur.prev = head;
        head.next.prev = cur;
        head.next = cur;
    }
    
    private void removeTail() {
        if(head.next == tail) {
            return;
        }
        DoubleLinkedList newPrev = tail.prev.prev;
        tail.prev.next = null;
        tail.prev = null;
        newPrev.next = tail;
        tail.prev = newPrev;
    }
}

class DoubleLinkedList {
    DoubleLinkedList prev;
    DoubleLinkedList next;
    int key;
    int value;
    DoubleLinkedList(int key, int value) {
        this.key = key;
        this.value = value;
    }
}