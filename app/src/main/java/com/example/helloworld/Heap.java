package com.example.helloworld;

import android.graphics.BitmapFactory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Heap {

    /**
     * 找数组中第一个只出现一次的数
     * @return
     */
    public static int firstOnce(int[] nums) {
        List<Integer> mlIST = new LinkedList();
        mlIST.add(1);
        for (int i = 0; i < nums.length; i ++) {
            int temp = nums[i];
            boolean isFirstOnce = true;
            for (int j = i + 1; j < nums.length; j ++) {
                if (temp == nums[j]) {
                    isFirstOnce = false;
                    break;
                }
            }

            if (isFirstOnce) {
                return temp;
            }
        }

        return -1;
    }

    public static double t(double d, int n) {
        for (int i = 0; i < n + 1; i ++) {
            d = d * 10;
        }
        long res = (long)d % 10;
        d = (long) d;
        if (res > 5) {
            d += 10;
        } else {
            d -=res;
        }
        double result = 0.0;
        for (int i = 0; i < n + 1; i ++) {
            result = d / 10;
        }

        return result;
    }

    public static void adjustHeap(int[] array, int index, int leght) {
        int child;
        int father;
        HashMap map = new HashMap();
        map.size();
    }

    public static int binarySearch(int[] array, int k, int low, int high) {
        if (k < array[low] || k > array[high] || low > high) return -1;

        int middle = (low + high) / 2;
        if (k > middle) {
            return binarySearch(array, k, middle + 1, high);
        } else if (k < middle) {
            return binarySearch(array, k, low, middle - 1);
        } else {
            return middle;
        }
    }
}
