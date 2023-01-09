package me.luangong.leetcode.solutions.contains_duplicate;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import me.luangong.leetcode.util.TestUtil;

/**
 * https://www.baeldung.com/parameterized-tests-junit-5
 * https://www.arhohuttunen.com/junit-5-parameterized-tests/
 */
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

  private static List<TestCase> loadTestCases() throws IOException {
    return TestUtil
        .loadTestCasesFromYamlFile(SolutionTest.class)
        .stream()
        .map(testCase -> new TestCase(
            TestUtil.getIntArray(testCase, "nums"),
            TestUtil.getBoolean(testCase, "expected")
        ))
        .toList();
  }
}
