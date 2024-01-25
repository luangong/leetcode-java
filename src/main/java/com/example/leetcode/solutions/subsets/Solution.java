/**
 * Subsets
 *
 * Given a set of distinct integers, S, return all possible subsets.
 *
 * Note:
 *
 *   - Elements in a subset must be in non-descending order.
 *   - The solution set must not contain duplicate subsets.
 *
 * For example, if S = [1, 2, 3], a solution is:
 *
 *   [
 *     [3],
 *     [1],
 *     [2],
 *     [1,2,3],
 *     [1,3],
 *     [2,3],
 *     [1,2],
 *     []
 *   ]
 *
 * Tags: Array, Backtracking, Bit Manipulation
 */
package com.example.leetcode.solutions.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (long x = 0; x < (1 << nums.length); x++) {
      List<Integer> subset = new ArrayList<>();
      for (int i = 0; i < 32; i++) {
        if ((x & (1 << i)) != 0) {
          subset.add(nums[i]);
        }
      }
      result.add(subset);
    }
    return result;
  }
}
