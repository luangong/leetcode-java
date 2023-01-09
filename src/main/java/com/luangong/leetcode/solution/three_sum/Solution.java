/**
 * 3Sum
 *
 * Given an array S of n integers, are there elements a, b, c in S such that
 * a + b + c = 0?  Find all unique triplets in the array which gives the sum of
 * zero.
 *
 * Note:
 *
 *    - Elements in a triplet (a, b, c) must be in non-descending order (i.e.,
 *      a <= b <= c).
 *
 *    - The solution set must not contain duplicate triplets.
 *      For example, given array S = {-1 0 1 2 -1 -4},
 *      A solution set is:
 *         (-1, 0, 1)
 *         (-1, -1, 2)
 *
 * Tags: Array, Two Pointers
 */
package com.luangong.leetcode.solution.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> triplets = new HashSet<>();
    for (int i = 0; i < nums.length-2; i++) {
      int j = i+1, k = nums.length-1;
      while (j < k) {
        if (nums[i] + nums[j] + nums[k] < 0) {
            j++;
        } else if (nums[i] + nums[j] + nums[k] > 0) {
            k--;
        } else {
            // triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
            triplets.add(List.of(nums[i], nums[j], nums[k]));
            j++; k--;
        }
      }
    }
    return new ArrayList<>(triplets);
  }

  public List<List<Integer>> threeSum2(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> triplets = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      int j = i + 1, k = nums.length - 1;
      while (j < k) {
        if (j > i + 1 && nums[j - 1] == nums[j]) {
          j++;
          continue;
        }
        if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
          k--;
          continue;
        }
        if (nums[i] + nums[j] + nums[k] < 0) {
          j++;
        } else if (nums[i] + nums[j] + nums[k] > 0) {
          k--;
        } else {
          // triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
          triplets.add(List.of(nums[i], nums[j], nums[k]));
          j++;
          k--;
        }
      }
    }
    return triplets;
  }
}
