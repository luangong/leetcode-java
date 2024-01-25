package com.example.leetcode.common;

import java.util.Objects;

// public record Interval(int start, int end) {}

// @EqualsAndHashCode
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
  public boolean equals(Object other) {
    if (other == null || !(other instanceof Interval)) {
      return false;
    }
    if (this == other) {
      return true;
    }
    return this.start == ((Interval) other).start && this.end == ((Interval) other).end;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.start, this.end);
  }

  @Override
  public int compareTo(Interval other) {
    // if (this.start != other.start) {
    //   return this.start - other.start;
    // } else {
    //   return this.end - other.end;
    // }
    return this.start != other.start ? this.start - other.start : this.end - other.end;
  }
}
