package org.example;

import org.example.nodes.MDNode;

import java.io.IOException;
import java.util.List;

public class Main<T> {
    public static void main(String[] args) throws IOException {
        MDParser parser = new MDParser();
        List<MDNode> list = parser.parseMDFile("C:\\Users\\bogda\\IdeaProjects\\test\\src\\main\\java\\org\\example\\testMarkdown.md");
        list.forEach(e -> System.out.println(e.content()));
//        parser.parseMDContent("""
//                # header 1
//                text
//                """);
    }
}