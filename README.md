# Java Solutions to LeetCode Problems

## Quickstart

First, ensure JDK 17 is installed, then run `./mvnw test` (`mvnw test` on Windows):

```bash
./mvn test
```

You can also build and test with [Bazel](https://bazel.build/):

```bash
bazel test //...
```

Bazel automatically downloads JDK 17 from Internet to compile and run your code so you don’t have to install it locally to run Bazel.  You may still need to install JDK 17 locally in order to browse the code in an IDE, though.

## Runtime Environment

As stated in [What are the environments for the programming languages](https://support.leetcode.com/hc/en-us/articles/360011833974-What-are-the-environments-for-the-programming-languages-):

- LeetCode compiles and runs submitted Java code with JDK 17.
- Java 8 features such as lambda expressions and the Streams API can be used.
- Most standard library classes are already imported automatically for convenience.
- The [`javafx.util.Pair`](https://docs.oracle.com/javase/8/javafx/api/javafx/util/Pair.html) class is also included.

## Unit Testing

This repo uses JUnit 5 parameterized testing feature to load test cases from external YAML files.  The reason of externalizing test data is to make it easy for projects written in different languages to share the test data.

For each problem, there is one YAML file with a path like `src/test/resources/<name>.yml`, where `<name>` is the title of the problem but with letters converted to lowercase and spaces replaced with undercores (e.g., `src/test/resources/two_sum.yml`).

## Updating Maven Dependencies

- If you use Maven to build and test the project, you can run `mvn versions:display-dependency-updates` to check if there are outdated dependencies and then manually edit `pom.xml` if there are any.

- If you use Bazel to build and test the project, you can run `bazel run @maven//:outdated` to see if there are any outdated dependencies from Maven.  After updating dependencies by manually editing `WORKSPACE`, you should run `REPIN=1 bazel run @unpinned_maven//:pin` and commit `maven_install.json`.

## TODOs

- [x] Put test cases files directly under `src/test/resources` rather than in the problem-specific directory (i.e., put test cases in `src/test/resources/two_sum.json` rather than `src/test/resources/two_sum/data.json`)
- [x] Add support for loading test cases from YAML files because:
  - YAML is more concise
  - YAML is a superset of JSON, so any valid JSON is also valid YAML
  - YAML supports adding comments
- [x] Take a look at [eo-yaml](https://github.com/decorators-squad/eo-yaml) and [Jackson Data Format YAML](https://github.com/FasterXML/jackson-dataformats-text/tree/master/yaml) for handling YAML files
  - [x] eo-yaml Doesn’t support flow sequences and flow mappings
  - [x] Jackson Data Format YAML is based on [SnakeYAML Engine](https://bitbucket.org/snakeyaml/snakeyaml-engine/)
- [ ] Add the ability to show code coverage
- [x] Remove JSON-related code and dependencies
- [x] Enable Bzlmod
- [ ] Try Gazelle to see if we can generate `BUILD.bazel` files automatically
- [ ] Improve CI performance by using
  - [x] [Bazel Remoe Caching](https://bazel.build/remote/caching) and
  - [ ] [Bazel Remote Execution](https://bazel.build/remote/rbe)

## Related Projects

- [leetcode-cpp](https://github.com/luangong/leetcode-cpp)
- [leetcode-python](https://github.com/luangong/leetcode-python)
- [leetcode-ts](https://github.com/luangong/leetcode-ts)
