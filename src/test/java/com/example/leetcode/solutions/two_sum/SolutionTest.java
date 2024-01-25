package com.example.leetcode.solutions.two_sum;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.example.leetcode.solutions.two_sum.Solution;
import com.example.leetcode.util.TestUtil;

// https://www.baeldung.com/parameterized-tests-junit-5
// https://www.arhohuttunen.com/junit-5-parameterized-tests/
public class SolutionTest {
  private Solution solution = new Solution();

  record TestCase(int[] nums, int target, int[] expected) {}

  @ParameterizedTest
  @MethodSource("loadTestCases")
  public void testTwoSum(TestCase testCase) {
    assertArrayEquals(
        testCase.expected(),
        solution.twoSum(testCase.nums(), testCase.target()));
  }

  @ParameterizedTest
  @MethodSource("loadTestCases")
  public void testTwoSum2(TestCase testCase) {
    assertArrayEquals(
        testCase.expected(),
        solution.twoSum2(testCase.nums(), testCase.target()));
  }

  private static List<TestCase> loadTestCases() throws Exception {
    return TestUtil.loadTestCases(SolutionTest.class, TestCase.class);
  }
}
