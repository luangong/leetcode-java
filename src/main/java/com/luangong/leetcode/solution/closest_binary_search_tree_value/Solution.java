package com.luangong.leetcode.solution.closest_binary_search_tree_value;

import com.luangong.leetcode.common.binarytree.TreeNode;

public class Solution {
  public int closestValue(TreeNode root, double target) {
    int closest = root.val;
    while (root != null) {
      if (Math.abs((double) root.val - target) < Math.abs((double) closest - target)) {
        closest = root.val;
      }
      if (target < root.val) {
        root = root.left;
      } else if (target > root.val) {
        root = root.right;
      } else {
        return root.val;
      }
    }
    return closest;
  }
}
