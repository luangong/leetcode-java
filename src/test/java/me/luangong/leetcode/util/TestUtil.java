package me.luangong.leetcode.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;

public class TestUtil {
  /**
   * Given "me.luangong.leetcode.solutions.two_sum.SolutionTest" class, return test cases
   * loaded from src/test/resources/two_sum_test_cass.yml
   */
  public static <T> List<Map<String, Object>> loadTestCasesFromYamlFile(Class<T> clazz)
      throws IOException {
    // Get the last field of the package name (e.g., "a.b.c.SolutionTest" -> "c")
    String[] fields = clazz.getPackageName().split("\\.");
    String problemSlug = fields[fields.length - 1];
    var inputStream = TestUtil.class.getResourceAsStream("/" + problemSlug + ".yml");
    LoadSettings settings = LoadSettings.builder().build();
    Load load = new Load(settings);
    return (List<Map<String, Object>>) load.loadFromInputStream(inputStream);
  }

  public static int[] listOfIntegersToIntArray(List<Integer> list) {
    return list.stream().mapToInt(Integer::intValue).toArray();
  }

  public static int[] getIntArray(Map<String, Object> map, String key) {
    return ((List<Integer>) map.get(key)).stream().mapToInt(Integer::intValue).toArray();
  }

  // public static String[] getStringArray(Map<String, Object> map, String key) {
  //   return ((List<String>) map.get(key)).toArray()
  // }

  public static int getInt(Map<String, Object> map, String key) {
    return ((Integer) map.get(key)).intValue();
  }

  public static boolean getBoolean(Map<String, Object> map, String key) {
    return ((Boolean) map.get(key)).booleanValue();
  }
}
