/**
 * Merge Sorted Array
 *
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 * Note: You may assume that A has enough space to hold additional elements from
 * B. The number of elements initialized in A and B are m and n respectively.
 *
 * Tags: Array, Two Pointers
 */
package com.example.leetcode.solutions.merge_sorted_array;

public class Solution {
  public void merge(int A[], int m, int B[], int n) {
    int i = m - 1, j = n - 1, k = m + n - 1;
    while (i >= 0 && j >= 0) {
      A[k--] = (A[i] > B[j] ? A[i--] : B[j--]);
    }
    while (j >= 0) {
      A[k--] = B[j--];
    }
  }
};
