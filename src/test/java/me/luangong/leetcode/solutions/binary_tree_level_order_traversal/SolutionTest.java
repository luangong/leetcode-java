package me.luangong.leetcode.solutions.binary_tree_level_order_traversal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import me.luangong.leetcode.common.binary_tree.TreeNode;
import me.luangong.leetcode.util.TestUtil;

public class SolutionTest {
  private Solution solution = new Solution();

  record TestCase(TreeNode root, List<List<Integer>> expected) {}

  @ParameterizedTest
  @MethodSource("loadTestCases")
  public void testTraverse(TestCase testCase) {
    assertEquals(testCase.expected(), solution.levelOrder(testCase.root()));
  }

  private static List<TestCase> loadTestCases() throws IOException {
    return TestUtil
        .loadTestCasesFromYamlFile(SolutionTest.class)
        .stream()
        .map(testCase -> new TestCase(
          TreeNode.deserialize((List<Integer>) testCase.get("root")),
          (List<List<Integer>>) testCase.get("expected"))
        )
        .toList();
  }
}
