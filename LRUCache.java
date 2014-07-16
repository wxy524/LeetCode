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
    
    Map<Integer, DoubleLinkedList> map;
    DoubleLinkedList head;
    DoubleLinkedList tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, DoubleLinkedList>();
        head = new DoubleLinkedList(Integer.MAX_VALUE, Integer.MAX_VALUE);
        tail = new DoubleLinkedList(Integer.MIN_VALUE, Integer.MIN_VALUE);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
         if(map.containsKey(key)) {
            DoubleLinkedList cur = map.get(key);
            moveToHead(cur);
            return cur.value;
         } else {
            return -1;
         }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            DoubleLinkedList cur = map.get(key);
            cur.value = value;
            moveToHead(cur);
        } else {
            DoubleLinkedList cur = new DoubleLinkedList(key, value);
            addToHead(cur);
            map.put(cur.key, cur);
            if(map.size() > this.capacity) {
                removeTail();
            }
        }   
    }

    private void moveToHead(DoubleLinkedList cur) {
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        cur.next = null;
        cur.prev = null;
        addToHead(cur);
    }

    private void addToHead(DoubleLinkedList cur) {
        cur.prev = head;
        cur.next = head.next;
        head.next.prev = cur;
        head.next = cur;
    }

    private void removeTail() {
        if(head.next == tail) {
            return;
        }
        DoubleLinkedList rm = map.remove(tail.prev.key);
        rm.prev.next = rm.next;
        rm.next.prev = rm.prev;
        rm.next = null;
        rm.prev = null;
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