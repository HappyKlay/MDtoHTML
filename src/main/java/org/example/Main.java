package org.example;

import java.io.IOException;
import java.util.List;

public class Main<T> {
    public static void main(String[] args) throws IOException {
        MDParser parser = new MDParser();
        List<Object> list = parser.parseMDFile("C:\\Users\\bogda\\IdeaProjects\\test\\src\\main\\java\\org\\example\\testMarkdown.md");
        list.forEach(System.out::println);
//        parser.parseMDContent("""
//                # header 1
//                text
//                """);
    }
}