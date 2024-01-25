package com.example.leetcode.solutions.evaluate_reverse_polish_notation;

import java.util.*;

public class Solution {
  public int evalRPN(String[] tokens) {
    Stack<String> stack = new Stack<String>();
    for (String token : tokens) {
      // RegExp is too slow in Java
      // Numbers can also have '+' or '-' characters
      // if (!token.matches("[*/+-]")) {
      if ("+-*/".indexOf(token) == -1) {
        stack.push(token);
      } else {
        int b = Integer.parseInt(stack.pop());
        int a = Integer.parseInt(stack.pop());
        stack.push(String.valueOf(evaluate(a, token, b)));
      }
    }
    return Integer.parseInt(stack.pop());
  }

  private int evaluate(int a, String op, int b) {
    if (op.equals("+")) {
      return a + b;
    }
    if (op.equals("-")) {
      return a - b;
    }
    if (op.equals("*")) {
      return a * b;
    }
    if (op.equals("/")) {
      return a / b;
    }
    return 0;
  }
}
