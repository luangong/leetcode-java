/**
 * Longest Consecutive Sequence
 *
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 *
 * For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements
 * sequence is [1, 2, 3, 4].  Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Tags: Array
 */
package com.luangong.leetcode.solution.longest_consecutive_sequence;

import java.util.*;

public class Solution {
  public int longestConsecutive(int[] num) {
    Arrays.sort(num);
    int length = 1, maxLength = 1;
    for (int i = 1; i < num.length; i++) {
      if (num[i] == num[i - 1] + 1) {
        ++length;
      } else if (num[i] > num[i - 1] + 1) {
        length = 1;
      }
      maxLength = Math.max(maxLength, length);
    }
    return maxLength;
  }
}
