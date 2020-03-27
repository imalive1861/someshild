package com.company.binarytree;

import java.util.ArrayList;
import java.util.Collection;

public class BinaryTree {
    private BinaryTreeNode root;
    private long size = 0;

    public boolean isEmpty() {
        return root == null;
    }

    public BinaryTreeNode get(Integer key) {
        BinaryTreeNode current = root;
        while (!current.value.equals(key)) {
            if (current.value < key) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void add(Integer key) {
        if (key == null) {
            return;
        }
        BinaryTreeNode node = new BinaryTreeNode(key);
        size++;
        if (isEmpty()) {
            root = node;
        } else {
            BinaryTreeNode current = root;
            BinaryTreeNode prev = null;
            while (true) {
                prev = current;
                if (key < prev.value) {
                    current = current.left;
                    if (current == null) {
                        prev.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        prev.right = node;
                        return;
                    }
                }
            }
        }
    }

    public void addAll(Collection<Integer> data) {
        data.forEach(this::add);
    }

    public String output() {
        if (root != null)
            return "Все элементы бинарного дерева: " + output(root);
        return "Бинарное дерево не содержит элементов";
    }

    private ArrayList<BinaryTreeNode> output(BinaryTreeNode element) {
        ArrayList<BinaryTreeNode> result = new ArrayList<>();
        if (element.left != null) {
            ArrayList<BinaryTreeNode> temp = output(element.left);
            result.addAll(temp);
        }
        result.add(element);
        if (element.right != null) {
            ArrayList<BinaryTreeNode> temp = output(element.right);
            result.addAll(temp);
        }
        return result;
    }

    public long size() {
        return size;
    }

    public String getCount() {
        return "Количество элементов: " + size();
    }

    public String getCountEvenVertices() {
        return "Количество четных чисел: "
                + output(root).stream().filter(value -> value.value % 2 == 0).count();
    }

    public String getCountLeaves() {
        return "Количество листьев: "
                + output(root)
                .stream()
                .filter(node -> node.left == null && node.right == null)
                .count();
    }

    public String getCountTopsOneChild() {
        return "Количество вершин дерева, имеющих только одного потомка: "
                + output(root)
                .stream()
                .filter(node -> (node.left == null && node.right != null) || (node.left != null && node.right == null))
                .count();
    }
}
