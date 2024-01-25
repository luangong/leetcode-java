"""
This module contains definitions of wrapper macros around java_library and java_test_suite
so that we can avoid duplications and enforce consistency in BUILD.bazel for each solution
package and for each test package.
"""

load("@contrib_rules_jvm//java:defs.bzl", "java_junit5_test", "java_test_suite")

def java_solution_library(**kwargs):
    native.java_library(
        name = native.package_name().split("/")[-1],
        srcs = native.glob(["*.java"]),
        visibility = ["//%s:__pkg__" % native.package_name().replace("main", "test", 1)],
        **kwargs,
    )

def java_common_test_suite(**kwargs):
    java_test_suite(
        name = "AllTests",
        size = "small",
        srcs = native.glob(["*.java"]),
        runner = "junit5",
        deps = [
            "//%s" % native.package_name().replace("test", "main", 1),
            "@mvn//:org_junit_jupiter_junit_jupiter_api",
            "@mvn//:org_junit_jupiter_junit_jupiter_engine",
            "@mvn//:org_junit_jupiter_junit_jupiter_params",
            "@mvn//:org_junit_platform_junit_platform_commons",
            "@mvn//:org_junit_platform_junit_platform_launcher",
            "@mvn//:org_junit_platform_junit_platform_reporting",
        ],
        **kwargs,
    )

def java_solution_test_suite(deps = [], **kwargs):
    problem_slug = native.package_name().split("/")[-1]
    # https://github.com/bazel-contrib/rules_jvm#java_test_suite
    # https://github.com/bazel-contrib/rules_jvm#java_junit5_test
    java_test_suite(
        name = "AllTests",
        srcs = native.glob(["*.java"]),
        runner = "junit5",
        # Data files are not put on the class path, and thus cannot be accessed by
        # junit-json-params.
        #
        # See https://groups.google.com/g/bazel-discuss/c/VUC8kTEXDYo.
        #
        # data = ["//:src/test/resources/%s.yml" % problem_slug],
        resources = [
            "//:src/test/resources/%s.yml" % problem_slug,
        ],
        deps = deps + [
            "//%s" % native.package_name().replace("test", "main", 1),
            "//src/test/java/com/example/leetcode/util",
            "@mvn//:org_junit_jupiter_junit_jupiter_api",
            "@mvn//:org_junit_jupiter_junit_jupiter_engine",
            "@mvn//:org_junit_jupiter_junit_jupiter_params",
            "@mvn//:org_junit_platform_junit_platform_commons",
            "@mvn//:org_junit_platform_junit_platform_launcher",
            "@mvn//:org_junit_platform_junit_platform_reporting",
        ],
        **kwargs,
    )
