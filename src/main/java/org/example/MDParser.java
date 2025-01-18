package org.example;

import org.example.nodes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MDParser {
    private final List<MDNode> nodes = new ArrayList<>();

    public List<MDNode> parseMDFile(String filePath) throws IOException {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty.");
        }

        String fileContent = String.join("\n", FileUtils.readFile(filePath));

        return parseMDContent(fileContent);
    }

    public List<MDNode> parseMDContent(String content) {
        nodes.clear();
        extractMarkdownElements(content);
        return new ArrayList<MDNode>(nodes);
    }

    private void extractMarkdownElements(String content) {
        Pattern combinedPattern = Pattern.compile(
                "(?<heading>#{1,6} .+)|" +
                        "(?<bold>\\*\\*.*?\\*\\*)|" +
                        "(?<italic>\\*.*?\\*)|" +
                        "(?<boldItalic>\\*\\*\\*.*?\\*\\*\\*)|" +
                        "(?<unorderedList>^[*-]\\s+.+$)|" +
                        "(?<orderedList>^\\d+\\.\\s+.+$)|" +
                        "(?<blockquote>^>\\s+.+$)|" +
                        "(?<inlineCode>`[^`]+`)|" +
                        "(?<codeBlock>```.*?```)|" +
                        "(?<link>\\[.*?\\]\\(.*?\\))|" +
                        "(?<image>!\\[.*?\\]\\(.*?\\))|" +
                        "(?<horizontalRule>^(\\*{3,}|-{3,})$)",
                Pattern.MULTILINE | Pattern.DOTALL
        );

        Matcher matcher = combinedPattern.matcher(content);
        while (matcher.find()) {
            if (matcher.group("heading") != null) {
                String heading = matcher.group("heading");
                int level = (int) heading.chars().filter(ch -> ch == '#').count();
                String text = heading.replaceAll("#", "").trim();
                nodes.add(new HeadingNode((byte) level, text));
            } else if (matcher.group("bold") != null) {
                nodes.add(new BoldNode(matcher.group("bold")));
            } else if (matcher.group("italic") != null) {
                nodes.add(new ItalicNode(matcher.group("italic")));
            } else if (matcher.group("boldItalic") != null) {
                nodes.add(new BoldItalicNode(matcher.group("boldItalic")));
//            } else if (matcher.group("unorderedList") != null) {
//                nodes.add(new UnorderedListNode(matcher.group("unorderedList")));
//            } else if (matcher.group("orderedList") != null) {
//                nodes.add(new OrderedListNode(matcher.group("orderedList")));
//            } else if (matcher.group("blockquote") != null) {
//                nodes.add(new BlockquoteNode(matcher.group("blockquote")));
//            } else if (matcher.group("inlineCode") != null) {
//                nodes.add(new InlineCodeNode(matcher.group("inlineCode")));
//            } else if (matcher.group("codeBlock") != null) {
//                nodes.add(new CodeBlockNode(matcher.group("codeBlock")));
//            } else if (matcher.group("link") != null) {
//                nodes.add(new LinkNode(matcher.group("link")));
//            } else if (matcher.group("image") != null) {
//                nodes.add(new ImageNode(matcher.group("image")));
//            } else if (matcher.group("horizontalRule") != null) {
//                nodes.add(new HorizontalRuleNode(matcher.group("horizontalRule")));
            }
        }
    }

}



