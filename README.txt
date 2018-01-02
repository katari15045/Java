

1. Install latest java JDK
--------------------------
Go to http://www.oracle.com/technetwork/java/javase/downloads/index.html and download latest JDK
Extract the downloaded tar.gz at /usr/lib/jvm
Follow the instructions at https://askubuntu.com/a/764914/556271


2. Switch b/w multiple java versions
------------------------------------
https://askubuntu.com/a/740782/556271


3. Add external Jars
--------------------
-> Download jar file
-> place it at /usr/lib/jvm/java-8-openjdk-amd64/jre/lib/ext


4. Decompile Java class file
----------------------------

-> Download jar file from http://jd.benow.ca/
-> Execute it($ java -jar sample.jar)


5. What is JAR?
---------------
-> Java Archive
-> Combination of Java class files, resource files(.txt, images etc) & metadata(readme.txt etc)

Commands :

$ java -jar sample.jar -----> Executes JAR file
$ jar -tf sample.jar -----> Displays all files in the Java Archive
$ unzip sample.jar -----> extracts all files in the Java Archive

6. BufferedReader vs Scanner
---------------------------

1. BufferedReader is faster than Scanner. How? BufferedReader has larger buffer than that of Scanner
2. Nothing comes for free. Sometimes(https://www.codechef.com/problems/CHOPRT), you get Runtime Exception with BufferedReader. Why? As it uses bigger buffer it may run out of Main memory(RAM).
3. If you want you can reduce the size of the buffer in BufferedReader by passing new buffer size as second argument while initializing it.

7. Compile and run with external jars
-------------------------------------
Compile with javac -cp .:<path to all external jars> Main.java
Run with java -cp .:<path to all external jars> Main

8. misc
-------
https://stackoverflow.com/questions/15154158/why-collections-sort-uses-merge-sort-instead-of-quicksort?rq=1
