/**
 * Subsets II
 *
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 *
 * Note:
 *
 * - Elements in a subset must be in non-descending order.
 * - The solution set must not contain duplicate subsets.
 *
 * For example, if S = [1,2,2], a solution is:
 *
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 *
 * Tags: Array, Backtracking
 */
package me.luangong.leetcode.solutions.subsets_ii;

import java.util.*;

public class Solution {
  public List<List<Integer>> subsetsWithDup(int[] num) {
    Arrays.sort(num);
    Set<List<Integer>> result = new HashSet<List<Integer>>();
    for (int x = 0; x < (1 << num.length); x++) {
      List<Integer> subset = new ArrayList<>();
      for (int i = 0; i < 32; i++) {
        if ((x & (1 << i)) != 0) {
          subset.add(num[i]);
        }
      }
      result.add(subset);
    }
    return new ArrayList<List<Integer>>(result);
  }
}
