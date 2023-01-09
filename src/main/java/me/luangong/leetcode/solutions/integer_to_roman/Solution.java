/**
 * Integer to Roman
 *
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Tags: Math, String
 */
package me.luangong.leetcode.solutions.integer_to_roman;

public class Solution {
  public String intToRoman(int num) {
    String[] thousands = { "", "M", "MM", "MMM" };
    String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    String[] individuals = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
    return new String() + thousands[num / 1000]
        + hundreds[num % 1000 / 100]
        + tens[num % 100 / 10]
        + individuals[num % 10];
  }
}
