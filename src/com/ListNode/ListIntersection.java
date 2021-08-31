package com.ListNode;

public class ListIntersection {
    public static void main(String[] args) {

    }

    public static boolean isListIntersection(ListNode l1, ListNode l2) {
        int lenA = getListLength(l1);
        int lenB = getListLength(l2);
        int diff = lenB - lenA;

        ListNode shorter = l1;
        ListNode longer = l2;

        if (lenA > lenB) {
            shorter = l2;
            longer = l1;
            diff = lenA - lenB;
        }

        for (int i = 0; i < diff; i++) {
            longer = longer.next;
        }
        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }
        return longer != null;
    }

    public static int getListLength(ListNode listNode) {
        int len = 0;
        while (listNode != null) {
            len++;
            listNode = listNode.next;
        }
        return len;
    }
}
