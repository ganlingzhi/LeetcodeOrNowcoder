package com.ListNode;

public class ReverseList {
    public static void main(String[] args) {
        //构造一条链表
        ListNode res = new ListNode(0);
        ListNode head = res;
        for (int i = 1; i < 5; i++) {
            res.next= new ListNode(i);
            res = res.next;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        while (pre != null) {
            System.out.println(pre.val);
            pre = pre.next;
        }
    }
}
