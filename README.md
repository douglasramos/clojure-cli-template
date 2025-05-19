# Clojure CLI Template


## Setup Native Image

1. [Install GraalVM](https://www.graalvm.org/docs/getting-started/)

2. Test that everything is working:
```
native-image --version
```

## Project Aliases

The project includes several useful aliases that can be run using the Clojure CLI. Here's how to use each one:

### Test Runner

Run all tests in the project:
```shell
clojure -M:test
```

### Build Tool

Build the project using tools.build:
```shell
clojure -T:build jar
```

### Native Image Generation

Create a native binary using GraalVM native-image:
```shell
clojure -M:native-image
```

This will create a native executable that can run without the JVM.

## Understanding Clojure CLI Modes

The Clojure CLI provides different execution modes, each suited for specific use cases. Here's how they work:

### Main Mode (-M)
- Used for running programs with a `-main` function
- Relevant alias options:
  - `:main-opts`: Arguments passed to the program (e.g., `["-m" "my.namespace"]`)
  - `:extra-deps`: Additional dependencies
  - `:extra-paths`: Additional classpath entries

Example:
```shell
clojure -M:test    # Runs test runner via its -main function
```

### Tool Mode (-T)
- Used for running functions as tools with named arguments
- Running a tool with -T will create a classpath that does not include the project :paths and :deps. -T:build will use only the :paths and :deps from the :build alias. The root deps.edn is still included
- Relevant alias options:
  - `:ns-default`: Default namespace for the tool
  - `:exec-fn`: Function to execute (if different from default)
  - `:exec-args`: Default arguments to pass

Example:
```shell
clojure -T:build jar    # 'jar' is passed as argument to the build function
```

### Execute Mode (-X)
- Modern way to run functions with map arguments
- Relevant alias options:
  - `:exec-fn`: Function to execute (required)
  - `:exec-args`: Default arguments as a map
  - `:extra-deps`: Additional dependencies

Example:
```shell
clojure -X:my-task {:arg1 "value"}    # Passes map as arguments
```

### Classic Mode (-A)
- Deprecated but still supported
- Only adds dependencies/paths without executing
- Relevant alias options:
  - `:extra-deps`: Additional dependencies
  - `:extra-paths`: Additional classpath entries

Example:
```shell
clojure -A:deps    # Just adds dependencies to classpath
```

Choose the appropriate mode based on how your tool/library expects to be invoked:
- Use `-M` for traditional main function entry points
- Use `-T` for modern tools that take named arguments
- Use `-X` for functions designed to take map arguments
- Avoid `-A` in favor of more explicit modes

More information [here](https://clojure.org/guides/deps_and_cli)

