package com.luangong.leetcode.solution.number_of_1_bits;

public class Solution {
  // You need to treat n as an unsigned number
  public int hammingWeight(int n) {
    return Integer.bitCount(n);
    // return Long.bitCount((n + (1L << 32)) % (1L << 32));
  }
}
