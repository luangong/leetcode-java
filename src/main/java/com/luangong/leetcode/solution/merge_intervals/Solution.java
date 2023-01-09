package com.luangong.leetcode.solution.merge_intervals;

import java.util.*;

import com.luangong.leetcode.common.Interval;

public class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() == 0) {
      return new ArrayList<Interval>();
    }
    List<Interval> result = new ArrayList<>();
    Collections.sort(intervals);
    Interval last = intervals.get(0);
    for (int i = 1; i < intervals.size(); i++) {
      Interval current = intervals.get(i);
      if (current.start <= last.end) {
        last.start = Math.min(last.start, current.start);
        last.end = Math.max(last.end, current.end);
      } else {
        result.add(last);
        last = current.clone();
      }
    }
    result.add(last);
    return result;
  }
}
