package org.example;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.cn/problems/intersection-of-two-linked-lists/ 两条无环链表是否相交
public class Leetcode160 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //因为要构造相交的，所以返回一个list
    public static List<ListNode> setupNodes() {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(8);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(1);
        b1.next = b2;
        b2.next = b3;
        b3.next = a3;

        List<ListNode> ret = new ArrayList<>();
        ret.add(a1);
        ret.add(b1);
        return ret;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ret = null;

        if (headA == null || headB == null) return ret;

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }

        ret = pA;

        return ret;
    }

    public static void main(String[] args) {
        List<ListNode> nodes = setupNodes();
        System.out.println(getIntersectionNode(nodes.get(0), nodes.get(1)).val);
    }

}
