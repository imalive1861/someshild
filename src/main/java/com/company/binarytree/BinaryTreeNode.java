package com.company.binarytree;

public class BinaryTreeNode {
    public Integer value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    BinaryTreeNode(Integer value) {
        this.value = value;
    }

    public String toString() {
        return "KEY: " + value;
    }
}
