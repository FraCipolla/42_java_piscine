Instructions:

Run mkdir target to create the directory.

javac -d ./target src/java/edu.school21.print/*/*.java to compile

java -cp ./target edu.school21.printer.Program 'white color' 'black color' 'black/white BMP img'

example:
    java -cp ./target edu.school21.printer.Program . 0 /it.bmp