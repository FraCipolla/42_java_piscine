#!/bin/bash
rm -rf target lib
mkdir target lib
cp ./src/resources/*.jar ./lib
javac -cp ".:./lib/jcommander-1.78.jar:./lib/JColor-5.0.0.jar" -d ./target/ src/java/edu.school21.printer/*/*.java

cd target
jar xf ../lib/jcommander-1.78.jar com
jar xf ../lib/JColor-5.0.0.jar com
cd ..

cp -r src/resources target/.   # required by subject

rm -f ./target/images-to-chars-printer.jar

jar -cvfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .