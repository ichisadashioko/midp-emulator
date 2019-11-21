# What is going on?

I am reading [MIDP 2.x - JSR118](https://docs.oracle.com/javame/config/cldc/ref-impl/midp2.0/jsr118/index.html) and adding it for implementation reference.

# References

## [Java ME](https://en.wikipedia.org/wiki/Java_Platform,_Micro_Edition)

## [Mobile Information Device Profile](https://en.wikipedia.org/wiki/Mobile_Information_Device_Profile)

## [freej2me](https://github.com/hex007/freej2me)

- `freej2me` uses [ant](https://ant.apache.org/) as build tool.
- Requires Oracle Java 8 as it is shipped with JavaFX.

## [microemu](https://code.google.com/archive/p/microemu/)

- `maven2` build tool for `microemu` on [Windows](https://archive.apache.org/dist/maven/binaries/apache-maven-2.2.1-bin.zip) and [Linux](https://archive.apache.org/dist/maven/binaries/apache-maven-2.2.0-bin.tar.gz)
- `microemu` lacks messaging function. This means that apps want to send message will crash.
    - We can either implement fake `Message` functionality or modify the app's Java bytecode to remove messaging API calls.