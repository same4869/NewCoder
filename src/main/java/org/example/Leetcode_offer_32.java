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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if(root != null)queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            ret.add(temp);
        }

        return ret;
    }
}
