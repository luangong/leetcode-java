/**
 * Binary Tree Level Order Traversal
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 *
 * For example, given binary tree {3,9,20,#,#,15,7},
 *
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 *
 * return its level order traversal as:
 *
 *    [
 *      [3],
 *      [9,20],
 *      [15,7]
 *    ]
 *
 * Tags: Tree, Breadth-first Search
 */
package com.luangong.leetcode.solution.binary_tree_level_order_traversal;

import java.util.*;

import com.luangong.leetcode.common.binarytree.TreeNode;

public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>(Arrays.asList(root));
    // queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      result.add(level);
    }
    return result;
  }
}
