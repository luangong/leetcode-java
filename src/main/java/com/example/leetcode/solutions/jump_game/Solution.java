/**
 * Jump Game
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 *
 * Each element in the array represents your maximum jump length at that
 * position.
 *
 * Determine if you are able to reach the last index.
 *
 * For example:
 *
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 *
 * Tags: Array, Greedy
 */
package com.example.leetcode.solutions.jump_game;

import java.util.*;

public class Solution {
  public boolean canJump(List<Integer> nums) {
    int i = 0, maxIndex = 0;
    while (i <= maxIndex) {
      maxIndex = Math.max(maxIndex, i + nums.get(i));
      if (maxIndex >= nums.size() - 1) {
        return true;
      }
      i++;
    }
    return false;
  }
}
