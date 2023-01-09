/**
 * Binary Tree Inorder Traversal
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2]
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, where '#'
 * signifies a path terminator where no node exists below.
 *
 * Here's an example:
 *    1
 *   / \
 *  2   3
 *     /
 *    4
 *     \
 *      5
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 *
 * Tags: Tree, Hash Table, Stack
 */

package me.luangong.leetcode.solutions.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import me.luangong.leetcode.common.binary_tree.TreeNode;

public class Solution {
  /**
   * Method 1: Recursive solution
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    traverse(root, result);
    return result;
  }

  // Helper
  private void traverse(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    traverse(root.left, result);
    result.add(root.val);
    traverse(root.right, result);
  }

  /**
   * Method 2: Iterative solution using a stack and a nested loop
   */
  public List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    while (!stack.empty() || node != null) {
      while (node != null) {
        stack.add(node);
        node = node.left;
      }
      node = stack.pop();
      result.add(node.val);
      node = node.right;
    }
    return result;
  }

  /**
   * Method 3: Iterative solution using a stack
   */
  public List<Integer> inorderTraversal3(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    while (!stack.empty() || node != null) {
      if (node != null) {
        stack.add(node);
        node = node.left;
      } else {
        node = stack.pop();
        result.add(node.val);
        node = node.right;
      }
    }
    return result;
  }
}
