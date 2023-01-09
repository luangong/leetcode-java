"""
This module contains definitions of wrapper macros around java_library and java_test_suite
so that we can avoid duplications and enforce consistency in the BUILD.bazel file for each
solution package and for each test package.
"""

load("@contrib_rules_jvm//java:defs.bzl", "java_test_suite")

def my_java_library(**kwargs):
    native.java_library(
        name = native.package_name().split("/")[-1],
        srcs = native.glob(["*.java"]),
        visibility = ["//%s:__pkg__" % native.package_name().replace("main", "test", 1)],
        **kwargs,
    )

def my_java_solution_test_suite(deps = [], **kwargs):
    my_java_test_suite(
        resources = [
            "//:src/test/resources/%s.yml" % native.package_name().split("/")[-1],
        ],
        # Data files are not put on the class path, and thus cannot be accessed by
        # junit-json-params.
        #
        # See https://groups.google.com/g/bazel-discuss/c/VUC8kTEXDYo.
        #
        # data = ["//:src/test/resources/%s.yml" % problem_slug],
        deps = deps + [
            "//src/test/java/me/luangong/leetcode/util",
        ],
        **kwargs,
    )

def my_java_test_suite(deps = [], **kwargs):
    # https://github.com/bazel-contrib/rules_jvm#java_test_suite
    # https://github.com/bazel-contrib/rules_jvm#java_junit5_test
    java_test_suite(
        name = "all-tests",
        size = "small",
        srcs = native.glob(["*.java"]),
        runner = "junit5",
        deps = deps + [
            "//%s" % native.package_name().replace("test", "main", 1),
            "@maven//:org_junit_jupiter_junit_jupiter_api",
            "@maven//:org_junit_jupiter_junit_jupiter_engine",
            "@maven//:org_junit_jupiter_junit_jupiter_params",
            "@maven//:org_junit_platform_junit_platform_commons",
            "@maven//:org_junit_platform_junit_platform_launcher",
            "@maven//:org_junit_platform_junit_platform_reporting",
        ],
        **kwargs,
    )
