// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

package com.example.leetcode.solutions.find_k_pairs_with_smallest_sums;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import javafx.util.Pair;

class Solution {
  /*
   * Note that the resulting pairs are not unique because if several pairs are tied as the
   * kth smallest pairs (they have the same sum), any of the pairs could be included in
   * the resulting list of pairs.  This makes the judging script more difficult to write.
   *
   * For example, suppose nums1 = [1, 2, 3, 4], nums2 = [1, 2, 3, 4], k = 8, then the sum
   * of all pairs are as follows (grouped by their sum and sorted in ascending order):
   *
   * +--------+
   * | (1, 1) |
   * +--------+
   * | (1, 2) |
   * | (2, 1) |
   * +--------+
   * | (1, 3) |
   * | (2, 2) |
   * | (3, 1) |
   * +--------+
   * | (1, 4) |
   * | (2, 3) |
   * ..........
   * | (3, 2) |
   * | (4, 1) |
   * +--------+
   *
   * The first 6 smallest pairs are obvious, but the 7th and the 8th smallest pairs could
   * be any two of the pairs in the last group: (1, 4), (2, 3), (3, 2), and (4, 1).
   *
   * First, assert that length(actual) == k, then split the pairs in `actual` into groups,
   * assume that the number of groups is g, then assert that the first g-1 groups are the
   * same as those in `expected`, and the last group is a subset of the corresponding
   * group in `expected`.
   */
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    // Queue<int[]> minHeap = new PriorityQueue<>(
    //     (a, b) -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]));
    Queue<int[]> minHeap = new PriorityQueue<>(
        Comparator.comparingInt((int[] a) -> nums1[a[0]] + nums2[a[1]]));
    minHeap.offer(new int[]{ 0, 0 });
    Set<Pair<Integer, Integer>> visited = new HashSet<>(List.of(new Pair<>(0, 0)));
    List<List<Integer>> pairs = new ArrayList<>();
    while (k-- > 0 && !minHeap.isEmpty()) {
      int[] top = minHeap.poll();
      int i = top[0];
      int j = top[1];
      pairs.add(List.of(nums1[i], nums2[j]));
      if (i + 1 < nums1.length && !visited.contains(new Pair<>(i + 1, j))) {
        visited.add(new Pair<>(i + 1, j));
        minHeap.offer(new int[]{ i + 1, j });
      }
      if (j + 1 < nums2.length && !visited.contains(new Pair<>(i, j + 1))) {
        visited.add(new Pair<>(i, j + 1));
        minHeap.offer(new int[]{ i, j + 1 });
      }
    }
    return pairs;
  }
}
