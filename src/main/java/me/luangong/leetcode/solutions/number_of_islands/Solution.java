/**
 * Number of Islands
 *
 * Given a 2d grid map of 1's (land) and 0's (water), count the number of
 * islands.  An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically.  You may assume all four edges of
 * the grid are all surrounded by water.
 *
 * Example 1
 *
 *   11110
 *   11010
 *   11000
 *   00000
 *
 * Answer: 1
 *
 * Example 2
 *
 *   11000
 *   11000
 *   00100
 *   00011
 *
 * Answer: 3
 *
 * CREDITS: Special thanks to @mithmatt for adding this problem and creating all
 * test cases.
 */
package me.luangong.leetcode.solutions.number_of_islands;

import java.util.*;

public class Solution {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int m = grid.length, n = grid[0].length;
    // boolean[][] explored = new boolean[m][n];
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          count += 1;
          dfs2(grid, i, j);
        }
      }
    }
    return count;
  }

  class Position {
    int row;
    int col;

    public Position(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  private boolean isValid(char[][] grid, int i, int j) {
    return 0 <= i && i < grid.length &&
        0 <= j && j < grid[0].length &&
        grid[i][j] == '1';
  }

  private void dfs(char[][] grid, int i, int j) {
    grid[i][j] = '0';
    for (Position pos : new Position[] { new Position(i - 1, j), new Position(i + 1, j), new Position(i, j - 1),
        new Position(i, j + 1) }) {
      if (isValid(grid, pos.row, pos.col)) {
        dfs(grid, pos.row, pos.col);
      }
    }
  }

  private void dfs2(char[][] grid, int row, int col) {
    grid[row][col] = '0';
    Stack<Position> stack = new Stack<>();
    stack.push(new Position(row, col));
    while (!stack.empty()) {
      int i = stack.peek().row;
      int j = stack.peek().col;
      stack.pop();
      for (Position pos : new Position[] { new Position(i - 1, j), new Position(i + 1, j), new Position(i, j - 1),
          new Position(i, j + 1) }) {
        if (isValid(grid, pos.row, pos.col)) {
          grid[pos.row][pos.col] = '0';
          stack.push(pos);
        }
      }
    }
  }

  private void bfs(char[][] grid, int row, int col) {
    grid[row][col] = '0';
    Queue<Position> queue = new LinkedList<>();
    queue.offer(new Position(row, col));
    while (!queue.isEmpty()) {
      int i = queue.peek().row;
      int j = queue.peek().col;
      queue.poll();
      for (var pos : new Position[] { new Position(i - 1, j), new Position(i + 1, j), new Position(i, j - 1),
          new Position(i, j + 1) }) {
        if (isValid(grid, pos.row, pos.col)) {
          grid[pos.row][pos.col] = '0';
          queue.offer(pos);
        }
      }
    }
  }
}
