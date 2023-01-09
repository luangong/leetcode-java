load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

##########################################################################################
# External dependencies for Java
# External dependencies for Java

RULES_JVM_EXTERNAL_TAG = "4.5"
RULES_JVM_EXTERNAL_SHA = "b17d7388feb9bfa7f2fa09031b32707df529f26c91ab9e5d909eb1676badd9a6"

http_archive(
    name = "rules_jvm_external",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

load("@rules_jvm_external//:defs.bzl", "maven_install")

# https://github.com/junit-team/junit5-samples/tree/main/junit5-jupiter-starter-bazel/WORKSPACE
JUNIT_JUPITER_VERSION = "5.9.2"
JUNIT_PLATFORM_VERSION = "1.9.2"
JACKSON_VERSION = "2.14.2"

maven_install(
    artifacts = [
        "org.junit.jupiter:junit-jupiter:%s" % JUNIT_JUPITER_VERSION,
        # "org.junit.jupiter:junit-jupiter-api:%s" % JUNIT_JUPITER_VERSION,
        # "org.junit.jupiter:junit-jupiter-engine:%s" % JUNIT_JUPITER_VERSION,
        # "org.junit.jupiter:junit-jupiter-params:%s" % JUNIT_JUPITER_VERSION,
        "org.junit.platform:junit-platform-launcher:%s" % JUNIT_PLATFORM_VERSION,
        "org.junit.platform:junit-platform-reporting:%s" % JUNIT_PLATFORM_VERSION,
        "com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:%s" % JACKSON_VERSION,
    ],
    repositories = [
        "https://repo.maven.apache.org/maven2",
    ],
    maven_install_json = "//:maven_install.json",
    fail_if_repin_required = True,
)

load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()

##########################################################################################
# contrib_rules_jvm works with JUnit 5 while the built-in java_test rule does not.
# https://github.com/bazel-contrib/rules_jvm

# 2023-01-12
CONTRIB_RULES_JVM_REF = "e470d8b92e6e80cd1925b64a24497626942331ad"
CONTRIB_RULES_JVM_SHA = "ddd0a2a611e71c1a8d8a765999725f403d53c228f568988de26029e781438ab2"

http_archive(
    name = "contrib_rules_jvm",
    url = "https://github.com/bazel-contrib/rules_jvm/archive/%s.zip" % CONTRIB_RULES_JVM_REF,
    sha256 = CONTRIB_RULES_JVM_SHA,
    strip_prefix = "rules_jvm-%s" % CONTRIB_RULES_JVM_REF,
)

load("@contrib_rules_jvm//:repositories.bzl", "contrib_rules_jvm_deps")

contrib_rules_jvm_deps()

load("@contrib_rules_jvm//:setup.bzl", "contrib_rules_jvm_setup")

contrib_rules_jvm_setup()
