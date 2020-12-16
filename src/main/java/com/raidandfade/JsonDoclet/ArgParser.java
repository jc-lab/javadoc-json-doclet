package com.raidandfade.JsonDoclet;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class ArgParser {
    public interface ArgumentHandler {
        default void setOutputDirectory(File dir) {}
        default void setWindowTitle(String windowTitle) {}
        default void setDocTitle(String docTitle) {}
    }

    @FunctionalInterface
    private interface SingleArgumentHandler {
        void handle(ArgumentHandler handler, List<String> value);
    }

    public static class ArgumentDefine {
        private final String name;
        private final int valueCount;
        private final SingleArgumentHandler handler;
        public ArgumentDefine(String name, int valueCount, SingleArgumentHandler handler) {
            this.name = name;
            this.valueCount = valueCount;
            this.handler = handler;
        }

        public String getName() {
            return name;
        }

        public int getValueCount() {
            return valueCount;
        }

        public SingleArgumentHandler getHandler() {
            return handler;
        }
    }

    public static List<ArgumentDefine> DEFINES = Collections.unmodifiableList(Arrays.asList(
            new ArgumentDefine("-d", 1, (handler, value) -> handler.setOutputDirectory(new File(value.get(0)))),
            new ArgumentDefine("-windowtitle", 1, (handler, value) -> handler.setWindowTitle(value.get(0))),
            new ArgumentDefine("-doctitle", 1, (handler, value) -> handler.setDocTitle(value.get(0)))
    ));
    public static Map<String, ArgumentDefine> DEFINE_MAP = Collections.unmodifiableMap(
            DEFINES
                    .stream()
            .collect(Collectors.toMap(ArgumentDefine::getName, v -> v))
    );

    public static void parseArguments(ArgumentHandler handler, String[][] options) {
        List<List<String>> optionList = Arrays.stream(options)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        for(Iterator<List<String>> iterator = optionList.iterator(); iterator.hasNext(); ) {
            List<String> keyValues = iterator.next();
            String key = keyValues.get(0);
            ArgumentDefine argumentDefine = DEFINE_MAP.get(key);
            if (argumentDefine != null) {
                argumentDefine.getHandler().handle(handler, keyValues.subList(1, keyValues.size()));
            }
        }
    }
}
