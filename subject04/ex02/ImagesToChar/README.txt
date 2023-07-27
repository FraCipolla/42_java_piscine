jaInstructions:

# Run "mkdir target lib" to create the directories.
# "cp ./src/resources/*.jar ./lib" to cpy .jar lib to /lib

# javac -cp ".:./lib/jcp-5.3.2.jar:./lib/jcommander-1.7.jar" -d ./target/ src/java.edu.school21.printer/*/*.java
# cp flag is the same as classpath, specifies where to find user class files

# jar command doesn't support extracting the file to a specified directory, so we need to cd in
# Than we need to remove the images-to-chars-printer.jar file to avoid corruption and pack everything into  a .jar file

# To simplify the process, run the unpack.sh script. It will execute all the steps before. Run chmod +x unpack.sh before, than ./unpack.sh

# building JAR file from Oracle documentation (link: https://docs.oracle.com/javase/tutorial/deployment/jar/build.html)

                                                                    jar command options
_____________________________________________________________________________________________________________________________________________________________________
|Option	   |                                                            Description                                                                                 |
|__________|________________________________________________________________________________________________________________________________________________________|
|v	       | Produces verbose output on stdout while the JAR file is being built. The verbose output tells you the name of each file as it's added to the JAR file. | 
|__________|________________________________________________________________________________________________________________________________________________________|
|0 (zero)  | Indicates that you don't want the JAR file to be compressed.                                                                                           |
|__________|________________________________________________________________________________________________________________________________________________________|
|M	       | Indicates that the default manifest file should not be produced.                                                                                       |
|__________|________________________________________________________________________________________________________________________________________________________|
||m	       | Used to include manifest information from an existing manifest file. The format for using this option is:                                              |
|          |     jar cmf jar-file existing-manifest input-file(s)                                                                                                   |
|          | See Modifying a Manifest File for more information about this option.                                                                                  |
|          |     Warning: The manifest must end with a new line or carriage return.                                                                                 |
|          |    The last line will not be parsed properly if it does not end with a new line or carriage return.                                                    |
|__________|________________________________________________________________________________________________________________________________________________________|
|-C	       | To change directories during execution of the command.                                                                                                 |
|__________|________________________________________________________________________________________________________________________________________________________|

# Tip:
    remember that manifest.txt must end with a new line or carriage return
    don't use Jcommander 1.7, it doesn't work for some reason

# launch jar (you don't need to specify the path of the img because is already inside the jar)
    java -jar target/images-to-chars-printer.jar --white=BRIGHT_BLACK --black=WHITE