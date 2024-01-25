/*
 * Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * Hint: A linked list can be reversed either iteratively or recursively.  Could
 * you implement both?
 *
 * Tags: Linked List
 */

package com.example.leetcode.solutions.reverse_linked_list;

import com.example.leetcode.common.linked_list.ListNode;

public class Solution {
  /**
   * Iterative
   */
  public ListNode reverseList(ListNode head) {
    ListNode curr = null;
    ListNode next = head;
    while (next != null) {
      ListNode prev = curr;
      curr = next;
      next = next.next;
      curr.next = prev;
    }
    return curr;
  }

  /**
   * Recursive
   */
  public ListNode reverseList2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode tail = reverseList2(head.next);
    head.next.next = head;
    head.next = null;
    return tail;
  }

  /**
   * Tail recursion
   */
  public ListNode reverseList3(ListNode head) {
    return this.reverseList(head, null);
  }

  private ListNode reverseList(ListNode curr, ListNode prev) {
    if (curr == null) {
      return prev;
    }
    ListNode next = curr.next;
    curr.next = prev;
    return this.reverseList(next, curr);
  }
}
