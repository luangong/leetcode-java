/**
 * Container with Most Water
 *
 * Given n non-negative integers a_1, a_2, ..., a_n, where each represents a
 * point at coordinate (i, a_i).  n vertical lines are drawn such that the two
 * endpoints of line i is at (i, a_i) and (i, 0).  Find two lines, which
 * together with x-axis forms a container, such that the container contains the
 * most water.
 *
 * Note: You may not slant the container.
 *
 * Tags: Array, Two Pointers
 */
package com.luangong.leetcode.solution.container_with_most_water;

public class Solution {
  public int maxArea(int[] height) {
    int max_area = 0;
    int left = 0, right = height.length - 1;
    while (left < right) {
      int shorter = Math.min(height[left], height[right]);
      int area = (right - left) * shorter;
      max_area = Math.max(max_area, area);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return max_area;
  }
}
