package me.luangong.leetcode.solutions.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public int[][] merge(int[][] intervals) {
    if (intervals.length == 0) {
      return new int[][]{};
    }
    List<int[]> result = new ArrayList<>();
    // Sort the array in place, first comparing the start of the two interval, and if they
    // are equal, then comparing the end.
    Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
    int[] last = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] <= last[1]) {
        last[1] = Math.max(last[1], intervals[i][1]);
      } else {
        result.add(last);
        last = intervals[i];
      }
    }
    result.add(last);
    return result.toArray(new int[result.size()][]);
  }

  public int[][] merge2(int[][] intervals) {
    List<int[]> result = new ArrayList<>();
    // Sort the array in place, first comparing the start of the two interval, and if they
    // are equal, then comparing the end.
    Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
    for (int[] interval : intervals) {
      if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
        result.add(interval);
      } else {
        int[] last = result.get(result.size() - 1);
        last[1] = Math.max(last[1], interval[1]);
      }
    }
    return result.toArray(new int[result.size()][]);
  }
}
