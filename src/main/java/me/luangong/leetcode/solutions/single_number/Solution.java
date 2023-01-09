/**
 * Single Number
 *
 * Given an array of integers, every element appears twice except for one.  Find
 * that single one.
 *
 * Note: Your algorithm should have a linear runtime complexity.  Could you
 * implement it without using extra memory?
 *
 * Tags: Hash Table, Bit Manipulation
 */
package me.luangong.leetcode.solutions.single_number;

import java.util.Arrays;

public class Solution {
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
      result ^= num;
    }
    return result;
  }

  public int singleNumber2(int[] nums) {
    return Arrays.stream(nums).reduce(0, (x, y) -> x ^ y);
  }
}
