# Clojure CLI Template


## Setup Native Image

1. [Install GraalVM](https://www.graalvm.org/docs/getting-started/)

2. Execute the following command to change your java environment to use the graalvm virtual machine:

```
# GRAALVM
export JAVA_HOME=/Library/Java/JavaVirtualMachines/<graalvm>/Contents/Home
export GRAALVM_HOME=/Users/<user>/Library/Java/JavaVirtualMachines/<graalvm/Contents/Home
export PATH=$GRAALVM_HOME/bin:$PATH
```

Alternatively you can use use [jenv](https://www.jenv.be/) to manage your java environment without having to deal with `JAVA_HOME environment variable`

3. Install Native Image (if it isn't already on $GRAALVM_HOME/bin)

First, put GraalVM bin folder into the path:

```
 export PATH=/Library/Java/JavaVirtualMachines/<graalvm>/Contents/Home/bin:$PATH
```
Now you have acess to `gu` command in you terimanl. Run:
```
gu install native-image
```
After this additional step, the native-image executable will become available in the `$JAVA_HOME/bin directory` which we already put in the path in the previouse in a former command.

To test fi everything is working:
```
native-image --version
```


# Issues

https://github.com/taylorwood/clojurl/commit/12b96b5e9a722b372f153436b1f6827709d0f2ab
https://www.innoq.com/en/blog/native-clojure-and-graalvm/

Yes, eval will generate classes in a dynamic classloader, load them, then
>> call methods on the newly formed class/object except for

https://github.com/babashka/sci

# Good Examples of CLIS

* https://github.com/taylorwood/clojurl
* https://gist.github.com/taylorwood/23d370f70b8b09dbf6d31cd4f27d31ff