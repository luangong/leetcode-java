package com.example.leetcode.solutions.single_number;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.example.leetcode.solutions.single_number.Solution;
import com.example.leetcode.util.TestUtil;

public class SolutionTest {
  private Solution solution = new Solution();

  record TestCase(int[] nums, int expected) {}

  @ParameterizedTest
  @MethodSource("loadTestCases")
  public void testSingleNumber(TestCase testCase) {
    assertEquals(testCase.expected(), solution.singleNumber(testCase.nums()));
  }

  private static List<TestCase> loadTestCases() throws Exception {
    return TestUtil.loadTestCases(SolutionTest.class, TestCase.class);
  }
}
