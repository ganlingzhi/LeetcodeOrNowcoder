package com.ListNode;

public class ReverseListPerK {
    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k ) {
        ListNode length = head;
        int len = 0;
        while (length != null) {
            len++;
            length = length.next;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        ListNode res = pre;
        for (int i = 0; i < len / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                ListNode temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }
        return res.next;
    }
}
