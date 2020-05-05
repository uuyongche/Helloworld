package com.example.helloworld;

public class Node1 {

    public static boolean eTree(int[] nodes, int low, int high) {
        if (nodes == null || high - low < 0) return false;
        int root = nodes[high];
        int i;
        for (i = low; i < high; i ++) {
            if (nodes[i] > root) {
                break;
            }
        }

        for (int j = i; j < high; j ++) {
            if (nodes[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if (i > 0) {
            left = eTree(nodes, 0, i - 1);
        }

        boolean right = true;
        if (i < high) {
            right = eTree(nodes, i + 1, high);
        }

        return left && right;
    }
}
