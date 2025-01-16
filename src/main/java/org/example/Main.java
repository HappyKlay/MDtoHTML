package org.example;

import java.io.IOException;

public class Main<T> {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        parser.parse("C:\\Users\\bogda\\IdeaProjects\\test\\src\\main\\java\\org\\example\\testMarkdown.md");
    }
}