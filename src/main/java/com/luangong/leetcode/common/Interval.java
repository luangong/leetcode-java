package com.luangong.leetcode.common;

public class Interval implements Comparable<Interval> {
  public int start;
  public int end;

  public Interval() {
    this.start = 0;
    this.end = 0;
  }

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public Interval clone() {
    return new Interval(this.start, this.end);
  }

  @Override
  public int compareTo(Interval other) {
    if (this.start < other.start) {
      return -1;
    } else if (this.start > other.start) {
      return 1;
    } else {
      return this.end - other.end;
    }
  }
}
