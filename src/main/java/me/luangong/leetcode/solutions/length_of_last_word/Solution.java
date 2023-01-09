/*
 * Length of Last Word
 *
 * Given a string s consists of upper/lower-case alphabets and space characters
 * ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 *
 * For example, given s = "Hello World", return 5
 *
 * Tags: String
 */
package me.luangong.leetcode.solutions.length_of_last_word;

public class Solution {
  public int lengthOfLastWord(String s) {
    int end = s.length() - 1;
    while (end >= 0 && Character.isWhitespace(s.charAt(end))) {
      --end;
    }
    if (end < 0)
      return 0;
    int start = end - 1;
    while (start >= 0 && !Character.isWhitespace(s.charAt(start))) {
      --start;
    }
    return end - start;
  }
}
