package com.leetcode;

import java.util.HashMap;

public class LRUCache {
    class DLinkedNode {
        int key, val;
        DLinkedNode next;
        DLinkedNode prev;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, DLinkedNode> cache;
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        size = 0;
        cache = new HashMap<>();
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int val) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.val = val;
            addToHead(node);
        } else {
            DLinkedNode newNode = new DLinkedNode(key, val);
            cache.put(key, newNode);
            addToHead(node);
            ++size;
            if (size > capacity) {
                DLinkedNode newTail = removeTail();
            }
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
