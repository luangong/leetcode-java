/**
 * Binary Tree Preorder Traversal
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *   1
 *    \
 *     2
 *    /
 *   3
 * return [1,2,3].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * Tags: Tree, Stack
 */
package com.example.leetcode.solutions.binary_tree_preorder_traversal;

import java.util.*;

import com.example.leetcode.common.binary_tree.TreeNode;

public class Solution {
  // Method 1: Recursion
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    traverse(root, result);
    return result;
  }

  // Helper
  private void traverse(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    result.add(root.val);
    traverse(root.left, result);
    traverse(root.right, result);
  }

  // Method 2: Use a stack
  public List<Integer> preorderTraversal2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    while (!stack.empty() || node != null) {
      if (node != null) {
        result.add(node.val);
        stack.push(node);
        node = node.left;
      } else {
        node = stack.pop().right;
      }
    }
    return result;
  }

  // Method 3: Use a stack
  public List<Integer> preorderTraversal3(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    while (!stack.empty() || node != null) {
      while (node != null) {
        result.add(node.val);
        stack.push(node);
        node = node.left;
      }
      node = stack.pop().right;
    }
    return result;
  }

  // Method 4: Analogous to level order traversal, but use a stack, and also
  // push right before push left.
  public List<Integer> preorderTraversal4(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.empty()) {
      TreeNode node = stack.pop();
      result.add(node.val);
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
    return result;
  }
}
