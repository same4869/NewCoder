package org.example;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

//https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
public class Leetcode_offer_32 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode setupTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode a = new TreeNode(20);
        root.right = a;
        a.left = new TreeNode(15);
        a.right = new TreeNode(7);
        return root;
    }


    public static void main(String[] args) {
        System.out.println(levelOrder(setupTree()));
    }

    //广度遍历,不太符合预期
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root != null) queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (level % 2 == 0) {
                List<Integer> temp2 = new ArrayList<>();
                for (int j = temp.size() - 1; j >= 0; j--) {
                    temp2.add(temp.get(j));
                }
                temp = temp2;
            }
            ret.add(temp);
            level++;
        }

        return ret;
    }


    //深度遍历
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = stack.size(); i > 0; i--) {
                TreeNode node = stack.pop();
                temp.add(node.val);
                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            }
            ret.add(temp);
        }


        return ret;
    }
}
