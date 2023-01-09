package me.luangong.leetcode.solutions.single_number;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import me.luangong.leetcode.util.TestUtil;

public class SolutionTest {
  private Solution solution = new Solution();

  record TestCase(int[] nums, int expected) {}

  @ParameterizedTest
  @MethodSource("loadTestCases")
  public void testSingleNumber(TestCase testCase) {
    assertEquals(testCase.expected(), solution.singleNumber(testCase.nums()));
  }

  private static List<TestCase> loadTestCases() throws IOException {
    return TestUtil
        .loadTestCasesFromYamlFile(SolutionTest.class)
        .stream()
        .map(testCase -> new TestCase(
            TestUtil.getIntArray(testCase, "nums"),
            TestUtil.getInt(testCase, "expected")
        ))
        .toList();
  }
}
