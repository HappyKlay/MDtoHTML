package org.example;

import org.example.nodes.BoldItalicNode;
import org.example.nodes.BoldNode;
import org.example.nodes.HeadingNode;
import org.example.nodes.ItalicNode;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MDParser {
    private final List<Object> list = new ArrayList<>();

    public List<Object> parseMDFile(String filePath) throws IOException {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty.");
        }

        List<String> fileLines = FileUtils.readFile(filePath);
        String fileContent = String.join("\n", fileLines);

        Matcher headingMatcher = MarkdownPatterns.HEADING.matcher(fileContent);
        Matcher boldMatcher = MarkdownPatterns.BOLD.matcher(fileContent);
        Matcher italicMatcher = MarkdownPatterns.ITALIC.matcher(fileContent);
        Matcher boldItalicMatcher = MarkdownPatterns.BOLD_ITALIC.matcher(fileContent);
        Matcher unorderedListMatcher = MarkdownPatterns.UNORDERED_LIST.matcher(fileContent);
        Matcher orderedListMatcher = MarkdownPatterns.ORDERED_LIST.matcher(fileContent);
        Matcher blockquoteMatcher = MarkdownPatterns.BLOCKQUOTE.matcher(fileContent);
        Matcher inlineCodeMatcher = MarkdownPatterns.INLINE_CODE.matcher(fileContent);
        Matcher codeBlockMatcher = MarkdownPatterns.CODE_BLOCK.matcher(fileContent);
        Matcher linkMatcher = MarkdownPatterns.LINK.matcher(fileContent);
        Matcher imageMatcher = MarkdownPatterns.IMAGE.matcher(fileContent);
        Matcher horizontalRuleMatcher = MarkdownPatterns.HORIZONTAL_RULE.matcher(fileContent);

        while (headingMatcher.find()) {
            String heading = headingMatcher.group();
            long level = heading.chars().filter(ch -> ch == '#').count();
            String content = heading.replaceAll("#", "").trim();
            list.add(new HeadingNode((byte) level, content));
        }

        while (boldMatcher.find()) {
            list.add(new BoldNode(boldMatcher.group()));
        }

        while (italicMatcher.find()) {
            list.add(new ItalicNode(italicMatcher.group()));
        }

        while (boldItalicMatcher.find()) {
            list.add(new BoldItalicNode(boldItalicMatcher.group()));
        }

        return list;
    }

    public void parseMDContent(String content) {
        Matcher headingMatcher = MarkdownPatterns.HEADING.matcher(content);
        while (headingMatcher.find()) {
            list.add(headingMatcher.group());
        }
        list.forEach(System.out::println);
    }
}



