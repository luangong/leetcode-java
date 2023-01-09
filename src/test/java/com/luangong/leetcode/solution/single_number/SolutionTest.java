package com.luangong.leetcode.solution.single_number;

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
  @JsonFileSource(resources = "/single_number/data.json")
  public void testTwoSum(JsonObject testCase) {
    int expected = testCase.getJsonNumber("expected").intValue();
    int[] nums = StreamSupport
        .stream(testCase.getJsonArray("nums").spliterator(), false)
        .mapToInt((value) -> ((JsonNumber)value).intValue())
        .toArray();
    assertEquals(expected, solution.singleNumber(nums));
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/single_number/data.json")
  public void testTwoSum2(JsonObject testCase) {
    int expected = testCase.getJsonNumber("expected").intValue();
    int[] nums = StreamSupport
        .stream(testCase.getJsonArray("nums").spliterator(), false)
        .mapToInt((value) -> ((JsonNumber)value).intValue())
        .toArray();
    assertEquals(expected, solution.singleNumber2(nums));
  }
}
