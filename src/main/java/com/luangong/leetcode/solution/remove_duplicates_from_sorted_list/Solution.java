package com.luangong.leetcode.solution.remove_duplicates_from_sorted_list;

import com.luangong.leetcode.common.linkedlist.ListNode;

public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode tail = head;
    for (ListNode p = head.next; p != null; p = p.next) {
      if (p.val != tail.val) {
        tail.next = p;
        tail = tail.next;
      }
    }
    tail.next = null;
    return head;
  }
}
