package com.example.leetcode.solutions.find_k_pairs_with_smallest_sums;

import static java.util.Comparator.comparingInt;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
// import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
// import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.example.leetcode.solutions.find_k_pairs_with_smallest_sums.Solution;
import com.example.leetcode.util.TestUtil;

public class SolutionTest {
  private Solution solution = new Solution();

  record TestCase(int[] nums1, int[] nums2, int k, int[][] expected) {}

  @Disabled("The answer is not unique.")
  @ParameterizedTest
  @MethodSource("loadTestCases")
  public void testKSmallestPairs(TestCase testCase) {
    // Arrays.sort(testCase.expected(), (int[] a, int[] b) -> {
    //   if (a[0] + a[1] != b[0] + b[1]) {
    //     return a[0] + a[1] - (b[0] + b[1]);
    //   } else {
    //     return a[0] - b[0];
    //   }
    // });
    Arrays.sort(
        testCase.expected(),
        comparingInt((int[] p) -> p[0] + p[1]).thenComparingInt(p -> p[0]));
    var actual = solution
        .kSmallestPairs(testCase.nums1(), testCase.nums2(), testCase.k())
        .stream()
        .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
        .toArray(int[][]::new);
    // Arrays.sort(actual, (int[] a, int[] b) -> {
    //   if (a[0] + a[1] != b[0] + b[1]) {
    //     return a[0] + a[1] - (b[0] + b[1]);
    //   } else {
    //     return a[0] - b[0];
    //   }
    // });
    Arrays.sort(
        actual,
        comparingInt((int[] p) -> p[0] + p[1]).thenComparingInt(p -> p[0]));
    assertArrayEquals(testCase.expected(), actual);
  }

  private static List<TestCase> loadTestCases() throws Exception {
    return TestUtil.loadTestCases(SolutionTest.class, TestCase.class);
  }
}
