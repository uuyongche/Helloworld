package com.example.helloworld;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A implements Serializable {

    volatile String a = "";

    public class Solution {
        public boolean Find(int target, int [][] array) {
            for (int i = 0;i < array.length;i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (target == array[i][j]) {

                        return true;
                    }
                }

            }

            List mList = new ArrayList<Integer>();
            Collections.reverse(mList);



            return false;
        }
    }


    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        } else {
            int min = array[0];
            for (int i = 1; i < array.length; i++) {
                if (min > array[i]) {
                    min = array[i];
                }
            }

            return min;
        }

    }
}
