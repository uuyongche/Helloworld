package com.example.helloworld

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class Main6Activity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStop() {
        super.onStop()

        /*val l1 = ListNode(1)
        l1.next = ListNode(4)
        l1.next.next = ListNode(5)
        val l2 = ListNode(2)
        l2.next = ListNode(4)
        l2.next.next = ListNode(6)
        l2.next.next.next = ListNode(8)
        var result = Solution.hNode(l1, l2)

        while (result != null) {
            Log.i("A", "result:" + result.`val`)
            result = result.next
        }*/

        // Solution.reverse(123);
        // Solution.reOrderArray(intArrayOf(1,2,3,4,5,6,7));
        /*val node = ListNode(1)
        node.next = ListNode(2)
        node.next.next = ListNode(3)
        node.next.next.next = ListNode(4)
        node.next.next.next.next = ListNode(5)
        Solution.FindKthToTail(node, 1)*/
        // Solution.PrintMinNumber(intArrayOf(3,5,1,4,2))
        // Solution.StrToInt("-2147483649");

        // Solution.permutation("abcdefg".toCharArray(), 0, 7);
        // Solution.GetUglyNumber_Solution(11);
        /*val array = intArrayOf(3,8,4,1,6,0,5,7);
        Solution1.kSort(array, 0, 7);
        for (i in array.indices) {
            Log.i("Solution1", "### result: " + array[i])
        }*/
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left.left = TreeNode(4)
        root.left.right = TreeNode(5)
        root.right.left = TreeNode(6)
        root.right.right = TreeNode(7)
        root.left.left.left = TreeNode(8)
        root.left.left.right = TreeNode(9)
        root.left.right.left = TreeNode(10)
        root.left.right.right = TreeNode(11)
        root.right.left.left = TreeNode(12)
        root.right.left.right = TreeNode(13)
        root.right.right.left = TreeNode(14)
        root.right.right.right = TreeNode(15)

        val sb = StringBuffer();
        Solution1.cTree1(root, sb);
        Log.i("#####", "###:" + sb.toString());
    }

}