package com.luangong.leetcode.solution.compare_version_numbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
  public int compareVersion(String version1, String version2) {
    List<Integer> v1 = Arrays.stream(version1.split("\\."))
        .map(Integer::valueOf)
        .collect(Collectors.toList());
    List<Integer> v2 = Arrays.stream(version2.split("\\."))
        .map(Integer::valueOf)
        .collect(Collectors.toList());
    // Method compareTo() is not defined for List<Integer>
    // return v1.compareTo(v2);
    return 0;
  }
}
