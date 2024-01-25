package com.example.leetcode.solutions.insert_delete_getrandom_o1;

import java.util.*;

public class RandomizedSet {
  private List<Integer> keys;
  private Map<Integer, Integer> map;

  /**
   * Initialize your data structure here.
   */
  public RandomizedSet() {
    this.keys = new ArrayList<>();
    this.map = new HashMap<>();
  }

  /**
   * Inserts the specified key into the set.
   *
   * @return {boolean} {@code true} if the set did not contain the specified key.
   */
  public boolean insert(int key) {
    if (this.map.containsKey(key)) {
      return false;
    }
    this.map.put(key, this.keys.size());
    this.keys.add(key);
    return true;
  }

  /**
   * Removes the specified key from the set.
   *
   * @return {boolean} {@code true} if the set contained the specified element.
   */
  public boolean remove(int key) {
    if (!this.map.containsKey(key)) {
      return false;
    }

    var index = this.map.get(key);
    var lastKey = this.keys.get(this.keys.size() - 1);
    this.map.put(lastKey, index);
    this.keys.set(index, lastKey);

    this.keys.remove(this.keys.size() - 1);
    this.map.remove(key);

    return true;
  }

  /**
   * Randomly picks a key from the set and returns it.
   */
  public int getRandom() {
    var i = (new Random()).nextInt(this.keys.size());
    return this.keys.get(i);
  }
}
