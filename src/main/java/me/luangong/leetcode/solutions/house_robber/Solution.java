/**
 * House Robber
 *
 * You are a professional robber planning to rob houses along a street.  Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 * Credits: Special thanks to @ifanchu for adding this problem and creating all
 * test cases.  Also thanks to @ts for adding additional test cases.
 *
 * Tags: Dynamic Programming
 */
package me.luangong.leetcode.solutions.house_robber;

public class Solution {
  public int rob2(int[] num) {
    int n = num.length;
    if (n == 0) {
      return 0;
    }
    int[] money = new int[n];
    money[n - 1] = num[n - 1];
    if (n >= 2) {
      money[n - 2] = Math.max(num[n - 2], num[n - 1]);
    }
    for (int i = n - 3; i >= 0; i--) {
      money[i] = Math.max(money[i + 1], num[i] + money[i + 2]);
    }
    return money[0];
  }

  public int rob(int[] num) {
    int n = num.length;
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return num[0];
    }
    int z = num[n - 1];
    int y = Math.max(num[n - 2], num[n - 1]);
    for (int i = n - 3; i >= 0; i--) {
      int x = Math.max(y, num[i] + z);
      z = y;
      y = x;
    }
    return y;
  }
}
