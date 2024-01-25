/**
 * Implement strStr().
 *
 * Returns a pointer to the first occurrence of pattern in text, or NULL if
 * pattern is not part of text.
 *
 * Update (2014-11-02):
 *
 * The signature of the function had been updated to return the index instead
 * of the pointer.  If you still see your function signature returns a char * or
 * String, please click the reload button  to reset your code definition.
 *
 * Tags: Two Pointers, String
 */
package com.example.leetcode.solutions.implement_strstr;

public class Solution {
  public int strStr(String haystack, String needle) {
    int m = haystack.length();
    int n = needle.length();
    for (int s = 0; s < m-n+1; s++) {
      int i = 0;
      for (; i < n; i++) {
        if (haystack.charAt(s+i) != needle.charAt(i)) {
          break;
        }
      }
      if (i == n) {
        return s;
      }
    }
    return -1;
  }

  public int strStr2(String haystack, String needle) {
    int i = 0, j = 0;
    while (i < haystack.length() && j < needle.length()) {
      if (haystack.charAt(i) == needle.charAt(j)) {
        i++; j++;
      } else {
        i = i - j + 1;
        j = 0;
      }
    }
    if (j == needle.length()) {
      return i - needle.length();
    }
    return -1;
  }
}
