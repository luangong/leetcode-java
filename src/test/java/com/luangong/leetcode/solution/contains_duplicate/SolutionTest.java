package com.luangong.leetcode.solution.contains_duplicate;

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
  @JsonFileSource(resources = "/contains_duplicate/data.json")
  public void testContainsDuplicate(JsonObject testCase) {
    boolean expected = testCase.getBoolean("expected");
    int[] nums = StreamSupport
        .stream(testCase.getJsonArray("nums").spliterator(), false)
        .mapToInt((value) -> ((JsonNumber)value).intValue())
        .toArray();
    assertEquals(expected, solution.containsDuplicate(nums));
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/contains_duplicate/data.json")
  public void testContainsDuplicate2(JsonObject testCase) {
    boolean expected = testCase.getBoolean("expected");
    int[] nums = StreamSupport
        .stream(testCase.getJsonArray("nums").spliterator(), false)
        .mapToInt((value) -> ((JsonNumber)value).intValue())
        .toArray();
    assertEquals(expected, solution.containsDuplicate2(nums));
  }
}
