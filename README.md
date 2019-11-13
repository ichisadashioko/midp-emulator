# Reference

- [freej2me](https://github.com/hex007/freej2me)

    - `freej2me` uses [ant](https://ant.apache.org/) as build tool.
    - Requires Oracle Java 8 as it is shipped with JavaFX.

- [microemu](https://code.google.com/archive/p/microemu/)

    - `maven2` build tool for `microemu` on [Windows](https://archive.apache.org/dist/maven/binaries/apache-maven-2.2.1-bin.zip) and [Linux](https://archive.apache.org/dist/maven/binaries/apache-maven-2.2.0-bin.tar.gz)
    - `microemu` lacks messaging function. This means that apps want to send message will crash.
        - We can either implement fake `Message` functionality or modify the app's Java bytecode to remove messaging API calls.