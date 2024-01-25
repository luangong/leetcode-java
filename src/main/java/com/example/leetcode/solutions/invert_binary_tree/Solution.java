// https://leetcode.com/problems/invert-binary-tree/

package com.example.leetcode.solutions.invert_binary_tree;

import com.example.leetcode.common.binary_tree.TreeNode;

public class Solution {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
        return null;
    }
    var left = root.left;
    var right = root.right;
    root.left = this.invertTree(right);
    root.right = this.invertTree(left);
    return root;
  }
}
