package tsinghua.cs.zhangfei.leetcode;

/**
 * Created by zhangfei614 on 2017/5/16.
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * <p/>
 * Assume a BST is defined as follows:
 * <p/>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 思路1：采用map来记录各个元素的频路，取所有的最多元素。
 * 思路2：第一次遍历找出最大值，第二次遍历找出所有与最大次数相同的元素。
 */
public class FindModeBinarySearchTree {
}
