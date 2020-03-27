package com.company;

import com.company.binarytree.BinaryTree;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addAll(Arrays.asList(3, 8, 1, null, 5, 7, 9, 2, 4, 6, 10));

        System.out.println(tree.output());
        System.out.println(tree.getCount());
        System.out.println(tree.getCountEvenVertices());
        System.out.println(tree.getCountLeaves());
        System.out.println(tree.getCountTopsOneChild());
    }
}
