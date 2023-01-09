package com.luangong.leetcode.solution.insert_delete_getrandom;

import java.util.*;

public class RandomizedSet {
  private List<Integer> keys = new ArrayList<>();
  private Map<Integer, Integer> map = new HashMap<>();

  /**
   * Initialize your data structure here.
   */
  public RandomizedSet() {
  }

  /**
   * Inserts the specified key to the set.
   *
   * @return {boolean} {@code true} if the set did not contain the specified key.
   */
  public boolean insert(int key) {
    if (map.containsKey(key)) {
      return false;
    }
    map.put(key, keys.size());
    keys.add(key);
    return true;
  }

  /**
   * Removes the specified key from the set.
   *
   * @return {boolean} {@code true} if the set contained the specified element.
   */
  public boolean remove(int key) {
    if (!map.containsKey(key)) {
      return false;
    }

    Integer index = map.get(key);
    Integer lastKey = keys.get(keys.size() - 1);
    map.put(lastKey, index);
    keys.set(index, lastKey);

    keys.remove(keys.size() - 1);
    map.remove(key);

    return true;
  }

  /**
   * Randomly picks a key from the set and returns it.
   */
  public int getRandom() {
    int i = (new Random()).nextInt(keys.size());
    return keys.get(i);
  }
}
