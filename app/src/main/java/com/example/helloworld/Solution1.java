package com.example.helloworld;

import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution1 {

    /**
     * 按层遍历
     */
    public static void cTree1(TreeNode root, StringBuffer sb) {
        Queue<TreeNode> mQueue = new LinkedList();
        TreeNode node = root;
        mQueue.add(node);
        while (!mQueue.isEmpty()) {
            int count = mQueue.size();
            for (int i = 0; i < count; i ++) {
                TreeNode temp = mQueue.poll();
                sb.append(temp.val).append(",");

                if (temp.left != null) {
                    mQueue.add(temp.left);
                }
                if (temp.right != null) {
                    mQueue.add(temp.right);
                }
            }
        }
    }

    /**
     * 安层遍历
     */
    public static void cTree(TreeNode root, StringBuffer sb) {
        Queue<TreeNode> mQueue = new LinkedList();
        TreeNode node = root;
        mQueue.add(node);
        while (!mQueue.isEmpty()) {
            TreeNode temp = mQueue.poll();
            sb.append(temp.val).append(",");
            if (temp.left != null) {
                mQueue.add(temp.left);
            }
            if (temp.right != null) {
                mQueue.add(temp.right);
            }
        }
    }

    /**
     * 后序遍历
     */
    public static void hTree1(TreeNode root, StringBuffer sb) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode node = root;
        stack1.push(node);

        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null) {
                stack1.push(temp.left);
            }
            if (temp.right != null) {
                stack1.push(temp.right);
            }
        }

        while (!stack2.isEmpty()) {
            TreeNode temp = stack2.pop();
            sb.append(temp.val).append(",");
        }
    }

    /**
     * 中序遍历
     */
    public static void zTree1(TreeNode root, StringBuffer sb) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                sb.append(node.val).append(",");
                node = node.right;
            }
        }
    }

    /**
     * 前序遍历
     */
    public static void qTree1(TreeNode root, StringBuffer sb) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                sb.append(node.val).append(",");
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 前序遍历
     */
    public static void qTree(TreeNode root, StringBuffer sb) {
        if (root == null) return;

        sb.append(root.val).append(",");
        qTree(root.left, sb);
        qTree(root.right, sb);
    }

    /**
     * 中序遍历
     */
    public static void zTree(TreeNode root, StringBuffer sb) {
        if (root == null) return;

        zTree(root.left, sb);
        sb.append(root.val).append(",");
        zTree(root.right, sb);
    }

    /**
     * 后序遍历
     */
    public static void hTree(TreeNode root, StringBuffer sb) {
        if (root == null) return;

        hTree(root.left, sb);
        hTree(root.right, sb);
        sb.append(root.val).append(",");
    }

    /**
     * 快速排序
     */
    public static void kSort(int[] array, int left, int right) {
        if (left >= right) return;
        int i = left;
        int j = right;
        int base = array[left];
        while (i < j) {
            if (array[j] >= base && i < j) {
                j --;
            }
            if (array[i] <= base && i < j) {
                i ++;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        array[left] = array[i];
        array[i] = base;

        kSort(array, left, i - 1);
        kSort(array, i + 1, right);
    }

    /**
     * 插入排序
     */
    public static void cSort(int[] array) {
        if (array.length == 0) return;

        for (int i = 1; i < array.length; i ++) {
            int num = array[i];
            int index = i;
            for (int j = i -1; j >= 0; j --) {
                if (num < array[j]) {
                    array[j + 1] = array[j];
                    index = j;
                }
            }

            array[index] = num;
        }

        for (int i = 0; i < array.length; i ++) {
            Log.i("Solution1", "### result: " + array[i]);
        }
    }

    /**
     * 选择排序
     */
    public static void xSort(int[] array) {
        if (array.length == 0) return;

        for (int i = 0; i < array.length; i ++) {
            int min = array[i];
            int index = i;
            for (int j = i + 1; j < array.length; j ++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }

            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }

        for (int i = 0; i < array.length; i ++) {
            Log.i("Solution1", "### result: " + array[i]);
        }
    }


    /**
     * 冒泡算法
     */
    public static void mSort(int[] array) {
        if (array.length == 0) return;

        for (int i = 0; i < array.length; i ++) {
            for (int j = 0; j < array.length - 1 - i; j ++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i ++) {
            Log.i("Solution1", "### result: " + array[i]);
        }
    }
}
