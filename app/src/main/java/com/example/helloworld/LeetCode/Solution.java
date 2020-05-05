package com.example.helloworld.LeetCode;

import android.os.Looper;
import android.util.Log;

import com.example.helloworld.TreeNode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Handler;

public class Solution {

    List<Integer[]> mList = new ArrayList();

    public int InversePairs(int [] array) {
        int sum = 0;
        for (int i = array.length - 1; i >= 0; i --) {
            for (int j = 0; j < i; j ++) {
                if (array[j] > array[i]) {
                    sum ++;
                }
            }
        }

        return sum % 1000000007;
    }

    public static int index2 = 1;
    public static int index3 = 1;
    public static int index5 = 1;
    public static List<Integer> result = new ArrayList();

    public static int GetUglyNumber_Solution(int index) {
        if (index == 1) return 1;
        result.add(1);
        while (result.size() < index) {
            int temp = Math.min(2 * index2, Math.min(3 * index3, 5 * index5));
            int t = getIndex();

            if (t == 2) {
                index2 = index2 + 2;
            } else if (t == 3) {
                index3 = index3 + 3;
            } else if (t == 5) {
                index5 = index5 + 5;
            }
            if (temp != result.get(result.size() - 1)) {
                result.add(temp);
            }

        }
        return result.get(index - 1);
    }

    public static int getIndex() {
        if (2 * index2 < 3 * index3) {
            if (2 * index2 < 5 * index5) {
                return 2;
            } else {
                return 5;
            }
        } else if (2 * index2 > 3 * index3) {
            if (3 * index3 < 5 * index5) {
                return 3;
            } else {
                return 5;
            }
        } else if (2 * index2 < 5 * index5) {
            if (2 * index2 < 3 * index3) {
                return 2;
            } else {
                return 3;
            }
        } else if (2 * index2 > 5 * index5) {
            if (5 * index5 > 3 * index3) {
                return 3;
            } else {
                return 5;
            }
        } else if (3 * index3 < 5 * index5) {
            if (3 * index3 < 2 * index2) {
                return 3;
            } else {
                return 2;
            }
        } else {
            if (5 * index5 > 2 * index2) {
                return 2;
            } else {
                return 5;
            }
        }
    }

    public static void permutation(char[] array, int start, int end) {
        /*if(end < 0) { //字符数组中没有元素直接返回
            return;
        }*/
        StringBuffer sb = new StringBuffer();
        sb.append(12);
        if(start == end) {
            Log.i("TAG...........", new String(array));
        }else {
            for(int i = start; i < end; i++) {
                swap(array, i, start); //更换前缀
                permutation(array, start + 1, end); //递归将剩余元素全排列
                swap(array, start, i);  //将前缀换回，以便进行上一个前缀的全排列
            }
        }
    }

    public static void swap(char[] array, int i, int j) { //用来交换前缀
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) return listAll;
        list.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) return true;
        return verify(sequence);
    }

    public boolean verify(int[] seq) {
        if (seq.length <= 1) return true;
        int root = seq[seq.length - 1];
        int index = 0;
        for (int i = 0; i < seq.length - 1; i ++) {
            if (seq[i] > root) {
                index = i;
            }
        }

        boolean isSmall = true;
        int[] sArray = new int[index];
        for (int i = 0; i < index; i ++) {
            if (seq[i] > root) {
                isSmall = false;
            }
            sArray[i] = seq[i];
        }
        boolean isBig = true;
        int[] bArray = new int[seq.length -1 - index];
        for (int i = index; i < seq.length - 1; i ++) {
            if (seq[i] < root) {
                isBig = false;
            }
            bArray[i - index] = seq[i];
        }



        return isSmall && isBig && verify(sArray) && verify(bArray);

    }


    public static int StrToInt(String str) {
        if (str.length() == 0) return 0;
        if (isS(str)) {
            return changeInt(str);
        }

        return 0;
    }

    public static int changeInt(String str) {
        char[] temp = str.toCharArray();
        int index = 0;
        if (temp[0] == '+' || temp[0] == '-') {
            index = 1;
        }

        int sum = 0;
        for (int i = index; i < temp.length; i ++) {
            sum = sum * 10 + getCharInt(temp[i]);
        }

        if (temp[0] == '-') {
            return -sum;
        }
        return sum;
    }

    public static int getCharInt(char t) {
        if (t =='1') {
            return 1;
        } else if (t == '2') {
            return 2;
        } else if (t == '3') {
            return 3;
        } else if (t == '4') {
            return 4;
        } else if (t == '5') {
            return 5;
        } else if (t == '6') {
            return 6;
        } else if (t == '7') {
            return 7;
        } else if (t == '8') {
            return 8;
        } else if (t == '9') {
            return 9;
        } else if (t == '0') {
            return 0;
        }

        return -1;
    }


    public static boolean isS(String str) {
        char[] temp = str.toCharArray();
        char[] sChar1 = {'1','2','3','4','5','6','7','8','9','0','+','-'};
        char[] sChar2 = {'1','2','3','4','5','6','7','8','9','0'};
        for (int i = 0; i < temp.length; i ++) {
            boolean isSChar = false;
            for (int j = 0; j < sChar1.length; j ++) {
                if (i == 0 && temp[i] == sChar1[j]) {
                    isSChar = true;
                    break;
                }
                if (j < sChar2.length && temp[i] == sChar2[j]) {
                    isSChar = true;
                    break;
                }
            }
            if (!isSChar) {
                return false;
            }
        }

        return true;
    }


    public static int LastRemaining_Solution(int n, int m) {
        List<Integer> mList = new LinkedList();
        for (int i = 0; i < n; i ++) {
            mList.add(i);
        }

        while (mList.size() > 1) {
            int index = -1;
            if (m % mList.size() == 0) {
                index = mList.size() - 1;
            } else {
                index = m % mList.size() - 1;
            }
            mList.remove(index);
            for (int i = 0; i < index; i ++) {
                mList.add(mList.get(0));
                mList.remove(0);
            }
        }

        return mList.get(0);
    }

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> mList = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> mQueue = new LinkedList<TreeNode>();
        mQueue.add(pRoot);
        while (!mQueue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList();
            for (int i =0; i < mQueue.size(); i ++) {
                TreeNode node = mQueue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    mQueue.add(node.left);
                }
                if (node.right != null) {
                    mQueue.add(node.right);
                }
            }
            mList.add(temp);
        }

        return mList;
    }

    public static String PrintMinNumber(int [] numbers) {
        String[] temp = new String[numbers.length];
        for (int i = 0; i < numbers.length; i ++) {
            temp[i] = String.valueOf(numbers[i]);
        }

        for (int i = 0; i < temp.length; i ++) {
            for (int j = 0; j < temp.length - 1 - i; j ++) {
                if ((temp[j] + temp[j + 1]).compareTo(temp[j + 1] + temp[j]) > 0) {
                    String t = temp[j + 1];
                    temp[j + 1] = temp[j];
                    temp[j] = temp[j + 1];
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < temp.length; i ++) {
            sb.append(temp[i]);
        }

        return sb.toString();
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        Queue<TreeNode> mQueue = new LinkedList<TreeNode>();
        ArrayList<Integer> mList = new ArrayList<Integer>();
        mQueue.add(root);
        while (!mQueue.isEmpty()) {
            TreeNode temp = mQueue.poll();
            mList.add(temp.val);
            if (temp.left != null) {
                mQueue.add(temp.left);
            }
            if (temp.right != null) {
                mQueue.add(temp.right);
            }
        }

        return mList;
    }

    Stack<Integer> stack = new Stack();
    int min = Integer.MIN_VALUE;

    public void push(int node) {
        stack.push(node);
        if (node < min) {
            min = node;
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        StringBuffer sb1 = levelTravel(root1);
        StringBuffer sb2 = levelTravel(root2);
        if (sb1.toString().contains(sb2.toString())) {
            return true;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public StringBuffer levelTravel(TreeNode root2) {
        Queue<TreeNode> mQueue = new LinkedList<TreeNode>();
        mQueue.add(root2);
        StringBuffer sb = new StringBuffer();
        while (root2 != null) {
            TreeNode temp = mQueue.poll();
            sb.append(String.valueOf(temp.val));
            if (root2.left != null) {
                mQueue.add(root2.left);
            }
            if (root2.right != null) {
                mQueue.add(root2.right);
            }

        }

        return sb;
    }

    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) return null;
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length ++;
            temp = temp.next;
        }
        if (k > length) {
            return null;
        }

        int index = length - k + 1;
        int curIndex = 1;
        ListNode result = null;
        while (head != null) {
            curIndex ++;
            head = head.next;
            if (curIndex == index) {
                result = head;
                break;
            }

        }
        new StringBuffer("").toString().contains("");
        new LinkedList().poll();
        return result;
    }

    public static void reOrderArray(int [] array) {
        int[] array1 = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i ++) {
            if (array[i] % 2 == 1) {
                array1[index] = array[i];
                index ++;
            }
        }

        for (int i = 0; i < array.length; i ++) {
            if (array[i] % 2 == 0) {
                array1[index] = array[i];
                index ++;
            }
        }

        array = array1;
    }

    public static int reverse(int x) {
        boolean isZ = true;
        if (x < 0) {
            isZ = false;
        }
        int y = Math.abs(x);

        String temp = String.valueOf(y);
        char[] sChar = temp.toCharArray();
        for (int i = 0; i < sChar.length / 2; i ++) {
            char cTemp = sChar[i];
            sChar[i] = sChar[sChar.length - 1 - i];
            sChar[sChar.length - i] = cTemp;
        }

        int mInt = Integer.valueOf(new String(sChar));
        new StringBuffer("").reverse();
        if (isZ) {
            return mInt;
        } else {
            return -mInt;
        }
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] tempChar = s.toCharArray();
        String[] tempStr = new String[tempChar.length];
        for (int i = 0; i < tempChar.length; i++ ){
            for (int j = tempChar.length; j > i; j --) {
                if (isH(s, i, j)) {
                    tempStr[i] = s.substring(i, j);
                    break;
                }
            }
        }

        String maxStr = tempStr[0];
        for (int i = 0; i < tempStr.length; i ++) {
            if (tempStr[i] != null && tempStr[i].length() > maxStr.length()) {
                maxStr = tempStr[i];
            }
        }

        return maxStr;
    }

    public static boolean isH(String s, int start, int end) {
        if (end - start == 1) {
            return true;
        }
        StringBuffer sb = new StringBuffer(s);
        if ((start + end) % 2 == 0) {
            String temp1 = sb.substring(start, (start + end) / 2);
            String temp2 = sb.substring((start + end) / 2, end);
            StringBuffer sb1 = new StringBuffer(temp2);
            sb1.reverse();
            if (temp1.equals(sb1.toString())) {
                return true;
            }
        } else {
            String temp1 = sb.substring(start, (start + end) / 2);
            String temp2 = sb.substring((start + end) / 2 + 1, end);
            StringBuffer sb2 = new StringBuffer(temp2);
            sb2.reverse();
            if (temp1.equals(sb2.toString())) {
                return true;
            }
        }

        return false;
    }


    public static ListNode hNode(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    temp.next = new ListNode(l1.val);
                    temp = temp.next;
                    l1 = l1.next;
                } else {
                    temp.next = new ListNode(l2.val);
                    temp = temp.next;
                    l2 = l2.next;
                }
            } else if (l1 != null && l2 == null) {
                temp.next = new ListNode(l1.val);
                temp = temp.next;
                l1 = l1.next;
            } else {
                temp.next = new ListNode(l2.val);
                temp = temp.next;
                l2 = l2.next;
            }
        }

        result = result.next;
        return result;

    }
}
