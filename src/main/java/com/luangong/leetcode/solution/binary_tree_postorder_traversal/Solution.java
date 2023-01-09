/**
 * Binary Tree Postorder Traversal
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example: given binary tree {1,#,2,3},
 *   1
 *    \
 *     2
 *    /
 *   3
 * return [3,2,1].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * Tags: Tree, Stack
 */
package com.luangong.leetcode.solution.binary_tree_postorder_traversal;

import java.util.*;

import com.luangong.leetcode.common.binarytree.TreeNode;

public class Solution {
    // Method 1: Recursive solution
    public List<Integer> postorderTraversal(TreeNode root) {
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
        traverse(root.right, result);
        result.add(root.val);
    }

    // Method 2: Iterative solution with a stack
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty()) {
          // TODO: Do something
        }
        return result;
    }

    // Method 3: First get the list of nodes of the mirror tree in preorder,
    // then return the reverse of the list
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
          return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
