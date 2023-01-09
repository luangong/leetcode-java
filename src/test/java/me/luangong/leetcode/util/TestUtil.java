package me.luangong.leetcode.util;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class TestUtil {
  /**
   * Given "me.luangong.leetcode.solutions.two_sum.SolutionTest" class, return test cases
   * loaded from {@code src/test/resources/two_sum.yml}
   *
   * @see https://www.baeldung.com/jackson-yaml
   * @see https://stackoverflow.com/a/6349488
   */
  public static <S, T> List<T> loadTestCases(Class<S> clazz, Class<T> testCaseClass)
      throws Exception {
    var problemSlug = TestUtil.getProblemSlug(clazz);
    var inputStream = TestUtil.class.getResourceAsStream("/" + problemSlug + ".yml");
    var mapper = new ObjectMapper(new YAMLFactory());
    var typeFactory = mapper.getTypeFactory();
    return mapper.readValue(
        inputStream,
        typeFactory.constructCollectionType(List.class, testCaseClass));
  }

  /**
   * Get the slug of the problem title (e.g., {@code "two_sum"}).
   *
   * <p>The problem slug is usually the last field of the package name (e.g., {@code
   * "me.luangong.leetcode.solutions.two_sum.SolutionTest"} -> {@code "two_sum"}).
   */
  public static <S> String getProblemSlug(Class<S> clazz) {
    String[] fields = clazz.getPackageName().split("\\.");
    return fields[fields.length - 1];
  }
}
