/**
 * Search for a Range
 *
 * @author 李立群
 */
package com.luangong.leetcode.solution.find_first_and_last_position_of_element_in_sorted_array;

public class Solution {
  public int[] searchRange(int[] A, int target) {
    if ( A == null || A.length == 0) {
      return null;
    }

    int[] bound = new int[2];

    // Search for lower bound
    int start = 0;
    int end = A.length - 1;
    int mid = 0;
    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (A[mid] >= target) {
        end = mid;
      } else  {
        start = mid;
      }
    }
    if (A[start] == target) {
      bound[0] = start;
    } else if (A[end] == target) {
      bound[0] = end;
    } else {
      bound[0] = bound[1] = -1;
      return bound;
    }

    // Search for upper bound
    start = 0;
    end = A.length - 1;
    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (A[mid] <= target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (A[end] == target) {
      bound[1] = end;
    } else if (A[start] == target) {
      bound[1] = start;
    } else {
      bound[0] = bound[1] = -1;
      return bound;
    }
    return bound;
  }
}
