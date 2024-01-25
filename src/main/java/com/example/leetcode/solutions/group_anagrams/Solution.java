/**
 * Anagrams
 *
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 *
 * Tags: String, Hash Table
 */
package com.example.leetcode.solutions.group_anagrams;

import java.util.*;

public class Solution {
  public List<String> groupAnagrams(String[] strs) {
    List<String> result = new ArrayList<String>();
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    for (String s : strs) {
      char[] array = s.toCharArray();
      Arrays.sort(array);
      String normalized = new String(array);
      if (map.containsKey(normalized)) {
        map.get(normalized).add(s);
      } else {
        List<String> list = new ArrayList<>();
        list.add(s);
        map.put(normalized, list);
      }
    }
    for (Collection<String> group : map.values()) {
      if (group.size() >= 2) {
        result.addAll(group);
      }
    }
    return result;
  }
}
