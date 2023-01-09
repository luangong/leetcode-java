/**
 * Remove Nth Node from End of List
 *
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 *
 * For example, given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.

 * Note: Given n will always be valid.  Try to do this in one pass.
 *
 * Tags: Linked List, Two Pointers
 */
package me.luangong.leetcode.solutions.remove_nth_node_from_end_of_list;

import me.luangong.leetcode.common.linked_list.ListNode;

public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode p = dummy;
    for (int i = 0; i < n; i++) {
      p = p.next;
    }
    ListNode q = dummy;
    while (p.next != null) {
      q = q.next;
      p = p.next;
    }
    q.next = q.next.next;
    return dummy.next;
  }
}
