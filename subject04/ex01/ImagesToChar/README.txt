Instructions:

Run mkdir target to create the directory.

javac -d ./target src/java/edu.school21.printer/*/*.java to compile

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

jar cvfm ./target/images-to-chars-printer.jar src/manifest.txt -C target edu/ -C src/ resources

# Tip:
    remember that manifest.txt must end with a new line or carriage return

# launch jar (you don't need to specify the path of the img because is already inside the jar)
    java -jar target/images-to-chars-printer.jar . o