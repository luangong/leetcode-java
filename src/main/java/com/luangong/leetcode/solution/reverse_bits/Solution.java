package com.luangong.leetcode.solution.reverse_bits;

public class Solution {
  public int reverseBits(int n) {
    return Integer.reverse(n);
  }

  // You need to treat n as an unsigned value
  public int reverseBits2(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      result = result * 2 + ((n >> i) & 1);
    }
    return result;
  }
}
