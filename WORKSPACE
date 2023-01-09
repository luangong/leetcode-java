load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

##########################################################################################
# External dependencies for Java
# https://github.com/bazelbuild/rules_jvm_external

RULES_JVM_EXTERNAL_TAG = "5.2"
RULES_JVM_EXTERNAL_SHA = "f86fd42a809e1871ca0aabe89db0d440451219c3ce46c58da240c7dcdc00125f"

http_archive(
    name = "rules_jvm_external",
    url = "https://github.com/bazelbuild/rules_jvm_external/releases/download/%s/rules_jvm_external-%s.tar.gz" % (RULES_JVM_EXTERNAL_TAG, RULES_JVM_EXTERNAL_TAG),
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

CONTRIB_RULES_JVM_TAG = "0.13.0"
CONTRIB_RULES_JVM_SHA = "2b710518847279f655a18a51a1629b033e4406f29609e73eb07ecfb6f0138d25"

http_archive(
    name = "contrib_rules_jvm",
    url = "https://github.com/bazel-contrib/rules_jvm/releases/download/v%s/rules_jvm-v%s.tar.gz" % (CONTRIB_RULES_JVM_TAG, CONTRIB_RULES_JVM_TAG),
    sha256 = CONTRIB_RULES_JVM_SHA,
    strip_prefix = "rules_jvm-%s" % CONTRIB_RULES_JVM_TAG,
)

load("@contrib_rules_jvm//:repositories.bzl", "contrib_rules_jvm_deps")

contrib_rules_jvm_deps()

load("@contrib_rules_jvm//:setup.bzl", "contrib_rules_jvm_setup")

contrib_rules_jvm_setup()
