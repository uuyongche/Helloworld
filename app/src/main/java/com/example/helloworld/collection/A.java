package com.example.helloworld.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Vector;

public class A {

    public static void main(String[] args) {
        ArrayList a1 = new ArrayList<String>();
        LinkedList a2 = new LinkedList<String>();
        Vector a3 = new Vector<ArrayList>();
        Set a4 = new HashSet<String>();

        // 非线程安全：ArrayList,LinkedList,HashSet,HashMap
        // 线程安全：Vector，HashTable
    }
}
