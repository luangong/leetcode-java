/**
 * Binary Tree Right Side View
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * For example: Given the following binary tree,
 *
 *       1            <---
 *     /   \
 *    2     3         <---
 *    \      \
 *    5       4       <---
 *
 * You should return [1, 3, 4].
 *
 * Credits: Special thanks to @amrsaqr for adding this problem and creating all
 * test cases.
 *
 * Tags: Tree, Depth-first Search, Breadth-first Search
 */
package com.luangong.leetcode.solution.binary_tree_right_side_view;

import java.util.*;

import com.luangong.leetcode.common.binarytree.TreeNode;

public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      result.add(queue.peek().val);
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        // Push right before pushing left
        if (node.right != null) {
          queue.offer(node.right);
        }
        if (node.left != null) {
          queue.offer(node.left);
        }
      }
    }
    return result;
  }

  public List<Integer> rightSideView2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    DFS(root, 1, result);
    return result;
  }

  public void DFS(TreeNode root, int level, List<Integer> result) {
    if (root == null) {
      return;
    }
    if (result.size() < level) {
      result.add(root.val);
    }
    DFS(root.right, level + 1, result);
    DFS(root.left, level + 1, result);
  }

  class StackNode {
    TreeNode node;
    int level;

    StackNode(TreeNode node, int level) {
      this.node = node;
      this.level = level;
    }
  }

  public List<Integer> rightSideView3(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<StackNode> stack = new Stack<>();
    stack.push(new StackNode(root, 1));
    while (!stack.empty()) {
      StackNode node = stack.pop();
      if (result.size() < node.level) {
        result.add(node.node.val);
      }
      if (node.node.left != null) {
        stack.push(new StackNode(node.node.left, node.level + 1));
      }
      if (node.node.right != null) {
        stack.push(new StackNode(node.node.right, node.level + 1));
      }
    }
    return result;
  }
}
