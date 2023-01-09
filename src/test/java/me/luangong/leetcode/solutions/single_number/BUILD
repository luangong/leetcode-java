load("@contrib_rules_jvm//java:defs.bzl", "java_test_suite")

# https://github.com/bazel-contrib/rules_jvm#java_test_suite
# https://github.com/bazel-contrib/rules_jvm#java_junit5_test
java_test_suite(
    name = "all-tests",
    size = "small",
    srcs = glob(["*.java"]),
    resources = ["//:src/test/resources/single_number.yml"],
    runner = "junit5",
    deps = [
        "//src/main/java/me/luangong/leetcode/solutions/single_number",
        "//src/test/java/me/luangong/leetcode/util",
        "@maven//:org_junit_jupiter_junit_jupiter_api",
        "@maven//:org_junit_jupiter_junit_jupiter_engine",
        "@maven//:org_junit_jupiter_junit_jupiter_params",
        "@maven//:org_junit_platform_junit_platform_commons",
        "@maven//:org_junit_platform_junit_platform_launcher",
        "@maven//:org_junit_platform_junit_platform_reporting",
    ],
)
