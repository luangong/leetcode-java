/**
 * Binary Tree Level Order Traversal II
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (i.e., from left to right, level by level from leaf to root).
 *
 * For example: given binary tree {3,9,20,#,#,15,7},
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its bottom-up level order traversal as:
 *
 *   [
 *     [15,7]
 *     [9,20],
 *     [3],
 *   ]
 *
 * Tags: Tree, Breadth-first Search
 */
package com.luangong.leetcode.solution.binary_tree_level_order_traversal_ii;

import java.util.*;

import com.luangong.leetcode.common.binarytree.TreeNode;

public class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
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
    Collections.reverse(result);
    return result;
  }
}
