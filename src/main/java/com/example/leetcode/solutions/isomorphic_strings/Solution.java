/**
 * Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters.  No two characters may map to the same
 * character but a character may map to itself.
 *
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 *
 * Note: You may assume both s and t have the same length.
 *
 * Tags: Hash Table
 */
package com.example.leetcode.solutions.isomorphic_strings;

public class Solution {
  public boolean isIsomorphic(String s, String t) {
    int[] map1 = new int[128];
    int[] map2 = new int[128];
    for (int i = 0; i < s.length(); i++) {
      if (map1[s.charAt(i)] != map2[t.charAt(i)]) {
        return false;
      }
      map1[s.charAt(i)] = map2[t.charAt(i)] = i + 1;
    }
    return true;
  }
}
