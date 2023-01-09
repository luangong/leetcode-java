/**
 * 4Sum
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S
 * such that a + b + c + d = target? Find all unique quadruplets in the array
 * which gives the sum of target.
 *
 * Note:
 *
 *    - Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 *      (i.e., a <= b <= c <= d)
 *
 *    - The solution set must not contain duplicate quadruplets.
 *      For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 *      A solution set is:
 *
 *         (-1,  0, 0, 1)
 *         (-2, -1, 1, 2)
 *         (-2,  0, 0, 2)
 *
 * Tags: Array, Hash Table, Two Pointers
 */
package me.luangong.leetcode.solutions.four_sum;

import java.util.*;

public class Solution {
  public List<List<Integer>> fourSum(int[] num, int target) {
    Arrays.sort(num);
    Set<List<Integer>> quadruplets = new HashSet<>();
    for (int i = 0; i < num.length - 3; i++) {
      for (int j = i + 1; j < num.length - 2; j++) {
        int left = j + 1;
        int right = num.length - 1;
        while (left < right) {
          int sum = num[i] + num[j] + num[left] + num[right];
          if (sum < target) {
            left++;
          } else if (sum > target) {
            right--;
          } else {
            quadruplets.add(Arrays.asList(num[i], num[j], num[left], num[right]));
            left++;
            right--;
          }
        }
      }
    }
    return new ArrayList<>(quadruplets);
  }

  class Pair {
    int first;
    int second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  public List<List<Integer>> fourSum2(int[] num, int target) {
    Set<List<Integer>> quadruplets = new HashSet<>();
    Arrays.sort(num);
    Map<Integer, List<Pair>> map = new HashMap<>();
    for (int i = 0; i < num.length - 1; i++) {
      for (int j = i + 1; j < num.length; j++) {
        int sum = num[i] + num[j];
        if (map.containsKey(sum)) {
          map.get(sum).add(new Pair(i, j));
        } else {
          map.put(sum, new ArrayList<>(Arrays.asList(new Pair(i, j))));
        }
      }
    }
    for (int i = 0; i < num.length - 1; i++) {
      for (int j = i + 1; j < num.length; j++) {
        int rest = target - num[i] - num[j];
        for (Pair pair : map.getOrDefault(rest, new ArrayList<>())) {
          if (pair.first > j) {
            quadruplets.add(Arrays.asList(num[i], num[j], num[pair.first], num[pair.second]));
          }
        }
      }
    }
    return new ArrayList<>(quadruplets);
  }
}
