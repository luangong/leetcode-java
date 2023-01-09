load("@contrib_rules_jvm//java:defs.bzl", "java_test_suite")

# https://github.com/bazel-contrib/rules_jvm#java_test_suite
# https://github.com/bazel-contrib/rules_jvm#java_junit5_test
java_test_suite(
    name = "all-tests",
    size = "small",
    srcs = glob(["*.java"]),
    resources = ["//:src/test/resources/single_number/data.json"],
    # Data files are not put on the class path, and thus can't be accessed by junit-json-params.
    # https://groups.google.com/g/bazel-discuss/c/VUC8kTEXDYo
    # data = ["//:src/test/resources/two_sum/data.json"],
    runner = "junit5",
    deps = [
        "//src/main/java/com/luangong/leetcode/solution/single_number",
        "@maven//:org_junit_jupiter_junit_jupiter_api",
        "@maven//:org_junit_jupiter_junit_jupiter_engine",
        "@maven//:org_junit_jupiter_junit_jupiter_params",
        "@maven//:org_junit_platform_junit_platform_commons",
        "@maven//:org_junit_platform_junit_platform_launcher",
        "@maven//:org_junit_platform_junit_platform_reporting",
        "@maven//:net_joshka_junit_json_params",
        "@maven//:org_glassfish_javax_json",
    ],
)
