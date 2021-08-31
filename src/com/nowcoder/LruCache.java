package com.nowcoder;

import java.util.HashMap;

public class LruCache {
    class DLinkedNode {
        int key, val;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public DLinkedNode() {
        }
    }

    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LruCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
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
            moveToHead(head);
        } else {
            DLinkedNode newNode = new DLinkedNode(key, val);
            cache.put(key, newNode);
            addToHead(node);
            ++size;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
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
