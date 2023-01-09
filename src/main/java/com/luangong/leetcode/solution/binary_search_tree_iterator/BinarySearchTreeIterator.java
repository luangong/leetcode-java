/**
 * Binary Search Tree Iterator
 *
 * Implement an iterator over a binary search tree (BST).  Your iterator will be
 * initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 *
 * Credits: Special thanks to @ts for adding this problem and creating all test
 * cases.
 *
 * Tags: Tree, Stack
 */
package com.luangong.leetcode.solution.binary_search_tree_iterator;

import java.util.*;

import com.luangong.leetcode.common.binarytree.TreeNode;

public class BinarySearchTreeIterator {
  private Stack<TreeNode> stack;

  public BinarySearchTreeIterator(TreeNode root) {
    stack = new Stack<>();
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  /**
   * @return whether we have a next smallest number
   */
  public boolean hasNext() {
    return !stack.empty();
  }

  /**
   * @return the next smallest number
   */
  public int next() {
    int value = stack.peek().val;
    TreeNode node = stack.pop().right;
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
    return value;
  }
}

/*
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
