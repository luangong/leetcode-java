package com.example.leetcode.solutions.invert_binary_tree;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.example.leetcode.common.binary_tree.TreeNode;
import com.example.leetcode.solutions.invert_binary_tree.Solution;
import com.example.leetcode.util.TestUtil;

public class SolutionTest {
  private Solution solution = new Solution();

  record TestCase(int[] root, int[] expected) {}

  @ParameterizedTest
  @MethodSource("loadTestCases")
  public void testInvertTree(TestCase testCase) {
    var actual = solution.invertTree(TreeNode.deserialize(testCase.root()));
    assertArrayEquals(
        testCase.expected(),
        TreeNode.serialize(actual).stream().mapToInt(i -> i).toArray());
  }

  private static List<TestCase> loadTestCases() throws Exception {
    return TestUtil.loadTestCases(SolutionTest.class, TestCase.class);
  }
}
