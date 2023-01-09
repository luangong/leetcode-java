package com.luangong.leetcode.solution.two_sum;

import java.util.stream.StreamSupport;
import javax.json.JsonNumber;
import javax.json.JsonObject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;

import net.joshka.junit.json.params.JsonFileSource;

/**
 * https://www.baeldung.com/parameterized-tests-junit-5
 * https://www.arhohuttunen.com/junit-5-parameterized-tests/
 */
public class SolutionTest {
  private Solution solution = new Solution();

  @ParameterizedTest
  @JsonFileSource(resources = "/two_sum/data.json")
  public void testTwoSum(JsonObject testCase) {
    int[] expected = StreamSupport
        .stream(testCase.getJsonArray("expected").spliterator(), false)
        .mapToInt((value) -> ((JsonNumber)value).intValue())
        .toArray();
    int[] nums = StreamSupport
        .stream(testCase.getJsonArray("nums").spliterator(), false)
        .mapToInt((value) -> ((JsonNumber)value).intValue())
        .toArray();
    int target = testCase.getJsonNumber("target").intValue();
    assertArrayEquals(expected, solution.twoSum(nums, target));
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/two_sum/data.json")
  public void testTwoSum2(JsonObject testCase) {
    int[] expected = StreamSupport
        .stream(testCase.getJsonArray("expected").spliterator(), false)
        .mapToInt((value) -> ((JsonNumber)value).intValue())
        .toArray();
    int[] nums = StreamSupport
        .stream(testCase.getJsonArray("nums").spliterator(), false)
        .mapToInt((value) -> ((JsonNumber)value).intValue())
        .toArray();
    int target = testCase.getJsonNumber("target").intValue();
    assertArrayEquals(expected, solution.twoSum2(nums, target));
  }

  // @ParameterizedTest
  // @MethodSource("getTestCases")
  // public void testContainsDuplicate(int[] expected, int[] nums, int target) {
  //   assertArrayEquals(expected, solution.twoSum(nums, target));
  // }

  // public static Stream<Arguments> getTestCases() {
  //   return Stream.of(
  //     Arguments.of(new int[]{ 0, 1 }, new int[]{ 2, 7, 11, 15 }, 9),
  //     Arguments.of(new int[]{ 1, 2 }, new int[]{ 3, 2, 4 },      6),
  //     Arguments.of(new int[]{ 0, 1 }, new int[]{ 3, 3 },         6)
  //   );
  // }
}
