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
package me.luangong.leetcode.solutions.subsets;

import java.util.*;

public class Solution {
  public List<List<Integer>> subsets(int[] S) {
    Arrays.sort(S);
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    for (long x = 0; x < (1 << S.length); x++) {
      List<Integer> subset = new ArrayList<Integer>();
      for (int i = 0; i < 32; i++) {
        if ((x & (1 << i)) != 0) {
          subset.add(S[i]);
        }
      }
      result.add(subset);
    }
    return result;
  }
}
