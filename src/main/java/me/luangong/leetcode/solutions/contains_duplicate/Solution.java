package me.luangong.leetcode.solutions.contains_duplicate;

import java.util.*;
import java.util.stream.*;

public class Solution {
  public boolean containsDuplicate(int[] nums) {
    return nums.length > IntStream.of(nums).boxed().collect(Collectors.toSet()).size();
  }

  public boolean containsDuplicate2(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    for (int num : nums) {
      if (seen.contains(num)) {
        return true;
      }
      seen.add(num);
    }
    return false;
  }
}
