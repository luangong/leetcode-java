package com.example.leetcode.solutions.factorial_trailing_zeroes;

public class Solution {
  public int trailingZeroes(int n) {
    int count = 0;
    while (n >= 5) {
      n /= 5;
      count += n;
    }
    return count;
  }
}
