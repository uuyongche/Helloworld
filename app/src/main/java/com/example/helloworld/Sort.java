package com.example.helloworld;

import android.util.Log;

import java.util.Arrays;

public class Sort {

    /**
     * 快速排序
     */
    public static void sort1(int[] array, int left, int right) {
        if (left >= right) return;
        int base = array[left];
        int i = left + 1; int j = right;
        while (i <= j) {
            while (array[i] <= base && j <= j) {
                i ++;
            }
            while (array[j] >= base && i <= j) {
                j --;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int tIndex = Math.min(i, j);
        array[left] = array[tIndex];
        array[tIndex] = base;
        sort1(array, left, i -1);
        sort1(array, i + 1, right);
    }

    /**
     * 插入排序
     */
    public static void insertSort() {
        int[] nums = new int[]{4, 2, 7, 3, 1, 9, 8, 5};
        for (int i = 1; i < nums.length; i++) {
            int replaceIndex = i;
            int temp = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < nums[j]) {
                    nums[j + 1] = nums[j];
                    replaceIndex = j;
                }
            }
            nums[replaceIndex] = temp;
        }

        for (int i = 0; i < nums.length; i++) {
            Log.i("A", "nums: " + nums[i]);
        }
    }


    /**
     * 冒泡排序
     */
    public static void bubbSort() {
        int[] nums = new int[]{4, 2, 7, 3, 1, 9, 8, 5};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            Log.i("A", "nums: " + nums[i]);
        }
    }


    /**
     * 选择排序
     */
    public static void selectSort() {
        int[] nums = new int[]{4, 2, 7, 3, 1, 9, 8};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            Log.i("A", "nums: " + nums[i]);
        }
    }

}
