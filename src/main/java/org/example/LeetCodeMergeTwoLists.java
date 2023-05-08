package org.example;

public class LeetCodeMergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode setupNodeA() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        return a1;
    }

    public static ListNode setupNodeB() {
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        return b1;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode pA = l1;
        ListNode pB = l2;
        ListNode ret;

        if (l1.val < l2.val) {
            ret = pA;
            pA = pA.next;
        } else {
            ret = pB;
            pB = pB.next;
        }

        while (pA != null && pB != null) {
            if (pA.val < pB.val) {
                ret.next = pA;
                pA = pA.next;
            } else {
                ret.next = pB;
                pB = pB.next;
            }
            ret = ret.next;
        }

        if (pA != null) {
            ret.next = pA;
        }
        if (pB != null) {
            ret.next = pB;
        }

        return ret;
    }

    public static void main(String[] args) {
        ListNode ret = mergeTwoLists(setupNodeA(), setupNodeB());
        while (ret.next != null) {
            System.out.println(ret.val + " ");
            ret = ret.next;
        }
    }
}
