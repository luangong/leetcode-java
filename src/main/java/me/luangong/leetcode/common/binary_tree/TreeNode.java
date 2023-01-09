package me.luangong.leetcode.common.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.StreamSupport;

// public record TreeNode(int val, TreeNode left, TreeNode right) {}

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {}

  public TreeNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }

  public TreeNode(int val, TreeNode left) {
    this.val = val;
    this.left = left;
    this.right = null;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public static List<Integer> serialize(TreeNode root) {
    if (root == null) {
      return List.of();
    }
    List<Integer> values = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>(List.of(root));
    while (!queue.isEmpty()) {
      // Exit the loop if every node on the queue is null
      var stream = StreamSupport.stream(queue.spliterator(), false);
      if (stream.allMatch(node -> node == null)) {
        break;
      }
      var node = queue.poll();
      if (node == null) {
        values.add(null);
        continue;
      }
      values.add(node.val);
      queue.add(node.left);
      queue.add(node.right);
    }
    return values;
  }

  public static TreeNode deserialize(List<Integer> values) {
    if (values.isEmpty()) {
      return null;
    }
    var root = new TreeNode(values.get(0));
    Queue<TreeNode> queue = new LinkedList<TreeNode>(List.of(root));
    for (int i = 1; i < values.size(); i += 2) {
      var node = queue.poll();
      if (values.get(i) != null) {
        node.left = new TreeNode(values.get(i));
        queue.add(node.left);
      }
      if (i + 1 < values.size() && values.get(i + 1) != null) {
        node.right = new TreeNode(values.get(i + 1));
        queue.add(node.right);
      }
    }
    return root;
  }
}
