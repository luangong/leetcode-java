package me.luangong.leetcode.solutions.contains_duplicate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import me.luangong.leetcode.util.TestUtil;

public class SolutionTest {
  private Solution solution = new Solution();

  record TestCase(int[] nums, boolean expected) {}

  @ParameterizedTest
  @MethodSource("loadTestCases")
  public void testTwoSum(TestCase testCase) {
    assertEquals(testCase.expected(), solution.containsDuplicate(testCase.nums()));
  }

  @ParameterizedTest
  @MethodSource("loadTestCases")
  public void testTwoSum2(TestCase testCase) {
    assertEquals(testCase.expected(), solution.containsDuplicate2(testCase.nums()));
  }

  private static List<TestCase> loadTestCases() throws Exception {
    return TestUtil.loadTestCases(SolutionTest.class, TestCase.class);
  }
}
