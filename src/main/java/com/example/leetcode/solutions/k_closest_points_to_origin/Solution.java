package com.example.leetcode.solutions.k_closest_points_to_origin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public int[][] kClosest(int[][] points, int k) {
    Arrays.sort(points, Comparator.comparingInt(p -> p[0] * p[0] + p[1] * p[1]));
    return Arrays.copyOfRange(points, 0, k);
  }

  public int[][] kClosest2(int[][] points, int k) {
    Queue<int[]> minHeap = new PriorityQueue<>(
        (a, b) -> a[0] * a[0] + a[1] * a[1] - (b[0] * b[0] + b[1] * b[1]));
    for (int i = 0; i < points.length; i++) {
      minHeap.offer(points[i]);
    }
    List<int[]> closest = new ArrayList<>();
    while (k-- > 0 && !minHeap.isEmpty()) {
      closest.add(minHeap.poll());
    }
    return closest.toArray(int[][]::new);
  }
}
