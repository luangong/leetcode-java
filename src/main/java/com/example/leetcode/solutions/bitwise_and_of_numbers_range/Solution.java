/**
 * Bitwise AND of Numbers Range
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 *
 * For example, given the range [5, 7], you should return 4.
 *
 * Credits: Special thanks to @amrsaqr for adding this problem and creating all
 * test cases.
 *
 * Tags: Bit Manipulation
 */
package com.example.leetcode.solutions.bitwise_and_of_numbers_range;

/*
 * The idea is to use a mask to find the leftmost common digits of m and n.
 * Example: m=1110001, n=1110111, and you just need to find 1110000 and it will
 * be the answer.
 */

public class Solution {
  public int rangeBitwiseAnd(int m, int n) {
    int r = Integer.MAX_VALUE;
    while ((m & r) != (n & r)) {
      r = r << 1;
    }
    return n & r;
  }

  public int rangeBitwiseAnd2(int m, int n) {
    int c = 0;
    while (m != n) {
      m >>= 1;
      n >>= 1;
      c++;
    }
    return m << c;
  }
}
