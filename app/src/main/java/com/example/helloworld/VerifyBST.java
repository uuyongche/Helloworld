package com.example.helloworld;

public class VerifyBST {
    //第一个元素下标low,最后一个元素下标high
    public static boolean verifySequenceBST(int[] sequence,int low,int high){
        if(sequence == null || high-low <0){
            return false;
        }
        int root = sequence[high];
        int i;
        //在二叉搜索树左子数的结点小于根结点
        for(i=low;i<high;i++){
            //如果值大于根结点，停止，说明这个下标开始为右子树
            if(sequence[i]>root){
                break;
            }
        }
        //i=3

        //在二叉搜索树右子数的结点大于根结点
        for (int j=i; j < high; j++) {
            if (sequence[j]<root) {
                return false;
            }
        }

        //判断左子树是不是二叉搜索数
        boolean left = true;
        if(i>0){

            left = verifySequenceBST(sequence,0,i-1);
        }

        //判断右子树是不是二叉搜索数
        boolean right = true;
        if(i<high){

            right = verifySequenceBST(sequence,i+1,high);
        }
        return (left&&right);
    }


    public static void main(String[] args) {
        int[] arr = {5,7,6,9,11,10,8};
        boolean flag =verifySequenceBST(arr, 0, arr.length-1);
        System.out.println(flag);
        int[] arr1 = {7,4,6,5};
        boolean flag1 = verifySequenceBST(arr1, 0, arr1.length-1);
        System.out.println(flag1);
    }
}
