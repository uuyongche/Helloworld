package com.example.helloworld;

import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Node {
    Node next = null;
    Node left = null;
    Node right = null;
    int value = 0;

    public static List<Integer> mList = new ArrayList<Integer>();

    public static int get(Node node) {
        getH(node);
        if (mList.size() <= 0) return -1;
        int max = mList.get(0);
        for (int i = 0; i < mList.size(); i ++) {
            if (max > mList.get(i)) {
                max = mList.get(i);
            }
        }

        return max;

    }

    public static void getH(Node node) {
        getH(node.left);
        getH(node.right);

        mList.add(getHeight(node));
    }

    /**
     * 遍历深度
     * @param node
     * @return
     */
    public static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }



    public void levelTraversal(Node node) {
        if (node == null) return;
        LinkedList<Integer> res = new LinkedList<>();
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        while (queue.size() > 0) {
            LinkedList<Integer> list = new LinkedList<>();//本层结果
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                list.add(queue.poll().value);
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
            }

            res.add(list.getFirst());
        }
    }

    public int getMaxDeep(Node node) {
        if (node == null) {
            return 0;
        }
        int max1 = getMaxDeep(node.left);
        int max2 = getMaxDeep(node.right);
        return Math.max(max1, max2) + 1;
    }


    /**
     * 先序遍历
     * @param node
     */
    public void xianTree(Node node) {
        if (node == null) return;
        Stack<Node> stack = new Stack();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            Log.i("A", temp.next.toString());
            stack.push(temp.right);
            stack.push(temp.left);
        }
    }

    public void zhongTree(Node node) {
        if (node == null) return;
        Stack<Node> stack = new Stack();
        while (node != null && !stack.isEmpty()) {

            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                // TODO 打印
                node = node.right;
            }
        }
    }

    public void houTree(Node node) {
        if (node == null) return;
        Stack<Node> stack = new Stack();
        while (node != null && !stack.isEmpty()) {

            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                // TODO 打印
                node = node.right;
            }
        }
    }


    public void reverseNode(Node n) {
        if (n == null || n.next == null) {
            return;
        }

        Node tempNode = n;
        Node tempNew = null;
        while (tempNode != null) {
            Node n1 = tempNode.next;
            tempNode.next = tempNew;
            tempNew = tempNode;
            tempNode = n1;
        }

        try {

        } catch (Error e) {

        }

    }
}
