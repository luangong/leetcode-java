/**
 * LRU Cache
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 *
 * - get(key)
 *
 *   Get the value (will always be positive) of the key if the key exists in
 *   the cache, otherwise return -1.
 *
 * - set(key, value)
 *
 *   Set or insert the value if the key is not already present.  When the
 *   cache reached its capacity, it should invalidate the least recently used
 *   item before inserting a new item.
 *
 * Tags: Data Structure
 */
package com.luangong.leetcode.solution.lru_cache;

import java.util.*;

public class LRUCache {
  /**
   * There is no way to swap two nodes in a Java LinkedList using iterators, so we have to
   * implement our own doubly-linked list.
   */
  class Node {
    public int key;
    public int value;
    public Node prev = null;
    public Node next = null;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  // The capacity of the cache
  private int capacity;

  // A doubly-linked list of key-value pairs, with the head node being the
  // most recently used item, and the tail node being the least recently used
  // item
  private Node head = new Node(0, 0);     // a dummy node
  private Node tail = new Node(0, 0);     // another dummy node

  // Maps keys to nodes in the doubly-linked list
  private Map<Integer, Node> map = new HashMap<>();

  public LRUCache(int capacity) {
    this.capacity = capacity;
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }

    // Move the key-value node before the head of the list
    this.moveToHead(map.get(key));
    return map.get(key).value;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      map.get(key).value = value;
      moveToHead(map.get(key));
    } else {
      // Remove the least frequently used item if the cache is full
      if (map.size() == capacity) {
        map.remove(tail.prev.key);
        this.removeFromList(tail.prev);
      }

      // Add a new node to the head of the list
      this.insertBeforeHead(new Node(key, value));
      map.put(key, head.next);
    }
  }

  private void removeFromList(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void insertBeforeHead(Node node) {
    node.prev = head;
    node.next = head.next;
    node.prev.next = node;
    node.next.prev = node;
  }

  private void moveToHead(Node node) {
    this.removeFromList(node);
    this.insertBeforeHead(node);
  }
}

// public class LRUCache extends LinkedHashMap<Integer, Integer> {
//   private int capacity;

//   public LRUCache(int capacity) {
//     super(capacity, 1, true);
//     this.capacity = capacity;
//   }

//   public int get(int key) {
//     if (!containsKey(key)) {
//       return -1;
//     }
//     return super.get(key);
//   }

//   public void put(int key, int value) {
//     super.put(key, value);
//   }

//   @Override
//   protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//     return size() > capacity;
//   }
// }

// public class LRUCache {
//   private int capacity;
//   private Map<Integer, Integer> map;

//   public LRUCache(int capacity) {
//     this.capacity = capacity;
//     this.map = new LinkedHashMap<>(capacity, 1, true);
//   }

//   public int get(int key) {
//     if (!this.map.containsKey(key)) {
//       return -1;
//     }
//     return this.map.get(key);
//   }

//   public void put(int key, int value) {
//     this.map.put(key, value);
//     if (this.map.size() > this.capacity) {
//       this.map.remove(this.map.keySet().iterator().next());
//     }
//   }
// }
