package com.example.leetcode.solutions.binary_tree_level_order_traversal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.example.leetcode.common.binary_tree.TreeNode;
import com.example.leetcode.solutions.binary_tree_level_order_traversal.Solution;
import com.example.leetcode.util.TestUtil;

public class SolutionTest {
  private Solution solution = new Solution();

  record TestCase(List<Integer> root, List<List<Integer>> expected) {}

  @ParameterizedTest
  @MethodSource("loadTestCases")
  public void testTraverse(TestCase testCase) {
    assertEquals(
        testCase.expected(),
        solution.levelOrder(TreeNode.deserialize(testCase.root())));
  }

  private static List<TestCase> loadTestCases() throws Exception {
    return TestUtil.loadTestCases(SolutionTest.class, TestCase.class);
  }
}
