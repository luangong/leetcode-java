package me.luangong.leetcode.solutions.merge_intervals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import me.luangong.leetcode.util.TestUtil;

public class SolutionTest {
  private Solution solution = new Solution();

  record TestCase(int[][] intervals, int[][] expected) {}

  @ParameterizedTest
  @MethodSource("loadTestCases")
  public void testMerge(TestCase testCase) {
    assertArrayEquals(testCase.expected(), solution.merge(testCase.intervals()));
  }

  @ParameterizedTest
  @MethodSource("loadTestCases")
  public void testMerge2(TestCase testCase) {
    assertArrayEquals(testCase.expected(), solution.merge2(testCase.intervals()));
  }

  private static List<TestCase> loadTestCases() throws Exception {
    return TestUtil.loadTestCases(SolutionTest.class, TestCase.class);
  }
}
