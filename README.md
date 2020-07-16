# Java 2 Micro Edition (emulator)

J2ME action games were my entertainment source in my middle school. They had some interesting adventure story and I want to bring the experience back.

The goal is to make a open source emulator for the MIDP platform to play old J2ME games.

# Why do I make another emulator while there are already some out there?

Even though I can pull all the source code, I know nothing about how the code work. I have never program for MIDP platform before. It is overwhelming with all sort of features and very little documentation on about what is going on. I also don't know what to ask and who to ask. Because of that, I think I will start from scratch.

# What is going on?

- I am reading [MIDP 2.0 - JSR118](https://docs.oracle.com/javame/config/cldc/ref-impl/midp2.0/jsr118/index.html) and adding it for implementation reference.
- After reading and defining all the classes, methods, and documenting those, I will create a archive branch with no implementation so that someone can start from there.

# References

There are some JSRs relevant to the MIDP platform.

- CLDC 1.0 ([JSR 30](https://jcp.org/en/jsr/detail?id=30))
- CLDC 1.1 ([JSR 139](https://jcp.org/en/jsr/detail?id=139))
- MIDP 1.0 ([JSR 37](https://jcp.org/en/jsr/detail?id=37))
- MIDP 2.0 ([JSR 118](https://jcp.org/en/jsr/detail?id=118))
- Mobile 3D Graphics API for J2ME ([JSR 184](https://jcp.org/en/jsr/detail?id=184))
- MIDP 3.0 ([JSR 271](https://jcp.org/en/jsr/detail?id=271))

## [Java ME](https://en.wikipedia.org/wiki/Java_Platform,_Micro_Edition)

## [Mobile Information Device Profile](https://en.wikipedia.org/wiki/Mobile_Information_Device_Profile)

## [freej2me](https://github.com/hex007/freej2me)

- `freej2me` uses [ant](https://ant.apache.org/) as build tool.
- Requires Oracle Java 8 as it is shipped with JavaFX.

## [microemu](https://code.google.com/archive/p/microemu/)

- `maven2` build tool for `microemu` on [Windows](https://archive.apache.org/dist/maven/binaries/apache-maven-2.2.1-bin.zip) and [Linux](https://archive.apache.org/dist/maven/binaries/apache-maven-2.2.0-bin.tar.gz)
- `microemu` lacks messaging function. This means that apps want to send message will crash.
    - We can either implement fake `Message` functionality or modify the app's Java bytecode to remove messaging API calls.
