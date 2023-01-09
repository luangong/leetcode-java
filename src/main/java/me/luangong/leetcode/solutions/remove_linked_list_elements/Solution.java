/**
 * Remove Linked List Elements
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example
 *
 * Given:
 *    1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6, val = 6
 *
 * Return:
 *    1 -> 2 -> 3 -> 4 -> 5
 *
 * Credits: Special thanks to @mithmatt for adding this problem and creating all
 * test cases.
 *
 * Tags: Linked List
 */
package me.luangong.leetcode.solutions.remove_linked_list_elements;

import me.luangong.leetcode.common.linked_list.ListNode;

public class Solution {
  public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    for (ListNode curr = head; curr != null; curr = curr.next) {
      if (curr.val != val) {
        tail.next = curr;
        tail = tail.next;
      }
    }
    tail.next = null;
    return dummy.next;
  }
}
