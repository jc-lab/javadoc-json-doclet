package com.raidandfade.JsonDoclet;

import com.sun.javadoc.*;

import java.util.*;

public class Main {
    public static void main(String... args) {}

    public static int optionLength(String option) {
        List<String> args = Arrays.asList(option.split(" "));
        int optionCount = 0;

        for (Iterator<String> iterator = args.iterator(); iterator.hasNext(); ) {
            String key = iterator.next();
            ArgParser.ArgumentDefine argumentDefine = ArgParser.DEFINE_MAP.get(key);
            if (argumentDefine != null) {
                optionCount += 1 + argumentDefine.getValueCount();
            }
        }

        return optionCount;
    }

    public static boolean start(RootDoc root) throws Exception {
        DocletApp app = new DocletApp(root);
        return app.start();
    }
}
