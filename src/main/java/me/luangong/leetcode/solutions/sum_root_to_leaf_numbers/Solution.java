package me.luangong.leetcode.solutions.sum_root_to_leaf_numbers;

import me.luangong.leetcode.common.binary_tree.TreeNode;

public class Solution {
  public int sumNumbers(TreeNode root) {
    return sumNumbers(root, 0);
  }

  public int sumNumbers(TreeNode root, int num) {
    if (root == null) {
      return 0;
    }
    num = num * 10 + root.val;
    if (root.left == null && root.right == null) {
      return num;
    }
    return (sumNumbers(root.left, num) + sumNumbers(root.right, num));
  }
}
