/**
 * Count Primes
 *
 * Count the number of prime numbers less than a non-negative number, n
 *
 * References:
 *
 *   - How Many Primes Are There? (https://primes.utm.edu/howmany.html)
 *   - Sieve of Eratosthenes (http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)
 *
 * Credits: Special thanks to @mithmatt for adding this problem and creating all
 * test cases.
 *
 * Tags: Hash Table, Math
 */
package com.example.leetcode.solutions.count_primes;

import java.util.Arrays;

public class Solution {
  public int countPrimes(int n) {
    boolean[] primes = new boolean[n];
    Arrays.fill(primes, 2, n, true);
    filter(primes, 2);
    long p = 3;
    while (p * p < n) {
      while (p * p < n && !primes[(int) p]) {
        p += 2;
      }
      if (p * p >= n) {
        break;
      }
      filter(primes, p);
      p += 2;
    }
    int count = 0;
    for (boolean b : primes) {
      count += b ? 1 : 0;
    }
    return count;
  }

  private void filter(boolean[] primes, long p) {
    long multiple = p * p;
    while (multiple < primes.length) {
      primes[(int) multiple] = false;
      multiple += p;
    }
  }
}
