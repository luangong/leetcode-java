/*
 * Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.
 *
 * For example,
 *
 *   Given s = "the sky is blue",
 *   return "blue is sky the".
 *
 * Clarification:
 *
 *   - What constitutes a word?
 *     A sequence of non-space characters constitutes a word.
 *
 *   - Could the input string contain leading or trailing spaces?
 *     Yes. However, your reversed string should not contain leading or trailing
 *     spaces.
 *
 *   - How about multiple spaces between two words?
 *     Reduce them to a single space in the reversed string.
 *
 * Tags: String
 */
package me.luangong.leetcode.solutions.reverse_words_in_a_string;

import java.util.*;

public class Solution {
  public String reverseWords(String sentence) {
    if (sentence.isEmpty()) {
      return "";
    }

    // Split into words by whitespace
    var words = List.of(sentence.trim().split("\\s+"));

    // Reverse words
    Collections.reverse(words);

    // Join words by spaces (Java 8 new feature)
    return String.join(" ", words);
  }
}
