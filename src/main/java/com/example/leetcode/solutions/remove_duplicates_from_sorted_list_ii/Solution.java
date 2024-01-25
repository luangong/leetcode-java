package com.example.leetcode.solutions.remove_duplicates_from_sorted_list_ii;

import com.example.leetcode.common.linked_list.ListNode;

public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode prev = dummy;
    ListNode curr = head;
    while (curr != null) {
      boolean duplicated = false;
      while (curr.next != null && curr.val == curr.next.val) {
        duplicated = true;
        ListNode tmp = curr;
        curr = curr.next;
        tmp.next = null;
      }
      if (duplicated) {
        curr = curr.next;
      } else {
        prev.next = curr;
        prev = prev.next;
        curr = curr.next;
      }
    }
    prev.next = curr;
    return dummy.next;
  }
}
