package com.example.leetcode.common.binary_tree;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TreeNodeTest {
  @ParameterizedTest
  @MethodSource("provideTestCasesForSerialization")
  public void testSerialization(List<Integer> expected, TreeNode root) {
    assertEquals(expected, TreeNode.serialize(root));
  }

  @ParameterizedTest
  @MethodSource("provideTestCasesForDeserialization")
  public void testDeserialization(List<Integer> values) {
    assertEquals(values, TreeNode.serialize(TreeNode.deserialize(values)));
  }

  private static List<Arguments> provideTestCasesForSerialization() {
    return List.of(
      Arguments.of(Stream.of().toList(),           null),
      Arguments.of(Stream.of(1).toList(),          new TreeNode(1)),
      Arguments.of(Stream.of(1, 2).toList(),       new TreeNode(1, new TreeNode(2))),
      Arguments.of(Stream.of(1, null, 3).toList(), new TreeNode(
        1, null, new TreeNode(3)
      )),
      Arguments.of(Stream.of(1, 2, 3).toList(),    new TreeNode(
        1, new TreeNode(2), new TreeNode(3)
      )),
      Arguments.of(Stream.of(1, 2, null, 4).toList(), new TreeNode(
        1, new TreeNode(2, new TreeNode(4))
      )),
      Arguments.of(Stream.of(1, 2, 3, null, null, 4, 5).toList(), new TreeNode(
        1,
        new TreeNode(2),
        new TreeNode(3, new TreeNode(4), new TreeNode(5))
      )),
      Arguments.of(Stream.of(1, null, 3, null, 7).toList(), new TreeNode(
        1, null, new TreeNode(3, null, new TreeNode(7))
      )),
      Arguments.of(
        Stream.of(5, 4, 7, 3, null, 2, null, -1, null, 9).toList(),
        new TreeNode(
          5,
          new TreeNode(4, new TreeNode(3, new TreeNode(-1))),
          new TreeNode(7, new TreeNode(2, new TreeNode(9)))
        )
      ),
      Arguments.of(Stream.of(3, 9, 20, null, null, 15, 7).toList(), new TreeNode(
        3,
        new TreeNode(9),
        new TreeNode(20, new TreeNode(15), new TreeNode(7))
      ))
    );
  }

  private static List<Arguments> provideTestCasesForDeserialization() {
    return List.of(
      Arguments.of(Stream.of().toList()),
      Arguments.of(Stream.of(1).toList()),
      Arguments.of(Stream.of(1, 2).toList()),
      Arguments.of(Stream.of(1, null, 3).toList()),
      Arguments.of(Stream.of(1, 2, 3).toList()),
      Arguments.of(Stream.of(1, 2, null, 4).toList()),
      Arguments.of(Stream.of(1, 2, 3, null, null, 4, 5).toList()),
      Arguments.of(Stream.of(1, null, 3, null, 7).toList()),
      Arguments.of(Stream.of(5, 4, 7, 3, null, 2, null, -1, null, 9).toList()),
      Arguments.of(Stream.of(3, 9, 20, null, null, 15, 7).toList())
    );
  }
}
