# javadoc-json-doclet

forked from [RaidAndFade/javadoc-json-doclet](https://github.com/RaidAndFade/javadoc-json-doclet)

Json Doclet for Javadoc (Turn regular JavaDoc Comments into json using the `javadoc` command and the `Gson` library)

## What's it do?

Usually, javadoc creates crappy lil html files. With this, you get a JSON file for each class (including internal classes) with all the information you could possibly desire.

The JSON files are stored into a folder called "docs" in the same directory as the command is run, and they're all named in the same format as you would import them with json as the extension.
(ie: `java.util.ArrayList.json`)

## Where can I get it?

There's a precompiled .jar in the builds folder that includes all required libraries and should work fine, but if you want to compile it yourself feel free. the Gson.jar used to build is included in the libs folder.

## Usage

`javadoc -doclet com.raidandfade.JsonDoclet.Main -docletpath json-jdoc.jar ...`

## Something wrong? Need extra information from the javadoc?

You can either make an issue or a pull request and I'll get to it eventually.

## Why did you do this, you crazy man?

Well you see, i have this wonderful API Endpoint at [My Public Api](https://dash.api.gocode.it/javadoc/). And I get my docs for all of Java's stdlib from there. You can do the same by following the instructions in [STDDocs](STDDocs.md)