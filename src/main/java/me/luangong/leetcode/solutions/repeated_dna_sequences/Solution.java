package me.luangong.leetcode.solutions.repeated_dna_sequences;

import java.util.*;

public class Solution {
  private static final int power = 262144; // 4 ^ 9

  public List<String> findRepeatedDnaSequences(String s) {
    List<String> result = new ArrayList<>();
    if (s.length() <= 10) {
      return result;
    }
    int h = hash(s.substring(0, 10));
    int[] count = new int[1048576]; // 4 ^ 10
    count[h] = 1;
    for (int i = 1; i <= s.length() - 10; i++) {
      h = 4 * (h - power * digit(s.charAt(i - 1))) + digit(s.charAt(i + 9));
      if (++count[h] == 2) {
        result.add(s.substring(i, i + 10));
      }
    }
    return result;
  }

  private int digit(char c) {
    return (c - 'A' + 1) % 5;
  }

  private int hash(String s) {
    int h = 0;
    for (int i = 0; i < s.length(); i++) {
      h = h * 4 + digit(s.charAt(i));
    }
    return h;
  }
}
