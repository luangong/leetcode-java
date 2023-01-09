"""
This module contains definitions of wrapper macros around java_library and java_test_suite
so that we can avoid duplications and enforce consistency in BUILD.bazel for each solution
package and for each test package.
"""

load("@contrib_rules_jvm//java:defs.bzl", "java_junit5_test", "java_test_suite")

def my_java_library(**kwargs):
    native.java_library(
        name = native.package_name().split("/")[-1],
        srcs = native.glob(["*.java"]),
        visibility = ["//%s:__pkg__" % native.package_name().replace("main", "test", 1)],
        **kwargs,
    )

def java_solutions_libraries(name, srcs = [], **kwargs):
    for src in srcs:
        problem_slug = src.split("/")[-2]
        native.java_library(
            name = 'solution_' + problem_slug,
            srcs = native.glob([
                "src/main/java/me/luangong/leetcode/solutions/%s/*.java" % problem_slug,
            ]),
            # deps = [":common"],
            visibility = ["//visibility:public"],
            **kwargs,
        )

def java_solutions_test_suite(name, srcs = [], deps = [], **kwargs):
    for src in srcs:
        problem_slug = src.split("/")[-2]
        package_name = "me.luangong.leetcode.solutions.%s" % problem_slug
        java_junit5_test(
            name = "test_%s" % src.split("/")[-2],
            size = "small",
            srcs = [src],
            resources = [
                "//:src/test/resources/%s.yml" % problem_slug,
            ],
            test_class = "%s.%s" % (package_name, src.split("/")[-1].split(".")[0]),
            deps = deps + [
                # "//%s" % native.package_name().replace("test", "main", 1),
                "//:solution_%s" % problem_slug,
                "//:common",
                "//:test_util",
                "@maven//:org_junit_jupiter_junit_jupiter_api",
                "@maven//:org_junit_jupiter_junit_jupiter_engine",
                "@maven//:org_junit_jupiter_junit_jupiter_params",
                "@maven//:org_junit_platform_junit_platform_commons",
                "@maven//:org_junit_platform_junit_platform_launcher",
                "@maven//:org_junit_platform_junit_platform_reporting",
            ],
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
            ":test_util",
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
