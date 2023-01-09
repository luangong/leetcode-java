package me.luangong.leetcode.solutions.largest_number;

import java.util.Arrays;

public class Solution {
  public String largestNumber(int[] nums) {
    String[] strs = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
    Arrays.sort(strs, (x, y) -> (y + x).compareTo(x + y));
    return String.join("", strs);
  }
}
