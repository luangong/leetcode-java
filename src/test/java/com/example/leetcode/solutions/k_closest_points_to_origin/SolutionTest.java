package com.example.leetcode.solutions.k_closest_points_to_origin;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.example.leetcode.solutions.k_closest_points_to_origin.Solution;
import com.example.leetcode.util.TestUtil;

public class SolutionTest {
  private Solution solution = new Solution();

  record TestCase(int[][] points, int k, int[][] expected) {}

  @ParameterizedTest
  @MethodSource("loadTestCases")
  public void testKClosest(TestCase testCase) {
    var actual = solution.kClosest(testCase.points(), testCase.k());
    // Arrays.sort(
    //     testCase.expected(), comparingInt((int[] p) -> p[0]).thenComparingInt(p -> p[1]));
    // Arrays.sort(testCase.expected(), (p1, p2) -> Arrays.compare(p1, p2));
    Arrays.sort(testCase.expected(), Arrays::compare);
    // Arrays.sort(actual, comparingInt((int[] p) -> p[0]).thenComparingInt(p -> p[1]));
    // Arrays.sort(actual, (p1, p2) -> Arrays.compare(p1, p2));
    Arrays.sort(actual, Arrays::compare);
    assertArrayEquals(testCase.expected(), actual);
  }

  @ParameterizedTest
  @MethodSource("loadTestCases")
  public void testKClosest2(TestCase testCase) {
    var actual = solution.kClosest2(testCase.points(), testCase.k());
    // Arrays.sort(
    //     testCase.expected(), comparingInt((int[] p) -> p[0]).thenComparingInt(p -> p[1]));
    // Arrays.sort(testCase.expected(), (p1, p2) -> Arrays.compare(p1, p2));
    Arrays.sort(testCase.expected(), Arrays::compare);
    // Arrays.sort(actual, comparingInt((int[] p) -> p[0]).thenComparingInt(p -> p[1]));
    // Arrays.sort(actual, (p1, p2) -> Arrays.compare(p1, p2));
    Arrays.sort(actual, Arrays::compare);
    assertArrayEquals(testCase.expected(), actual);
  }

  private static List<TestCase> loadTestCases() throws Exception {
    return TestUtil.loadTestCases(SolutionTest.class, TestCase.class);
  }
}
