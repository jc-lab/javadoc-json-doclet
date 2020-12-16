package com.raidandfade.JsonDoclet;

import com.sun.javadoc.*;
import com.google.gson.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String... args) {}

    public static int optionLength(String option) {
        List<String> args = Arrays.asList(option.split(" "));
        int optionCount = 0;

        for (Iterator<String> iterator = args.iterator(); iterator.hasNext(); ) {
            String key = iterator.next();
            if ("-d".equals(key)) {
                optionCount += 2;
            }
        }

        return optionCount;
    }

    public static boolean start(RootDoc root) throws Exception {
        DocletApp app = new DocletApp(root);
        return app.start();
    }
}
