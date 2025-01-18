package org.example;

import java.util.regex.Pattern;

public class MarkdownPatterns {
    // Headings (e.g., # Header, ## Subheader)
    public static final Pattern HEADING = Pattern.compile("^(#{1,6})\\s*(.+)$", Pattern.MULTILINE);

    // Bold (**bold** or __bold__)
    public static final Pattern BOLD = Pattern.compile("\\*\\*(.*?)\\*\\*|__(.*?)__", Pattern.MULTILINE);

    // Italic (*italic* or _italic_)
    public static final Pattern ITALIC = Pattern.compile("\\*(.*?)\\*|_(.*?)_", Pattern.MULTILINE);

    // Bold + Italic (***bold italic*** or ___bold italic___)
    public static final Pattern BOLD_ITALIC = Pattern.compile("\\*\\*\\*(.*?)\\*\\*\\*|___(.*?)___", Pattern.MULTILINE);

    // Unordered List (- item or * item)
    public static final Pattern UNORDERED_LIST = Pattern.compile("^[*-]\\s+(.+)$", Pattern.MULTILINE);

    // Ordered List (1. item, 2. item)
    public static final Pattern ORDERED_LIST = Pattern.compile("^\\d+\\.\\s+(.+)$", Pattern.MULTILINE);

    // Blockquote (> quote)
    public static final Pattern BLOCKQUOTE = Pattern.compile("^>\\s+(.+)$", Pattern.MULTILINE);

    // Inline Code (`code`)
    public static final Pattern INLINE_CODE = Pattern.compile("`([^`]+)`", Pattern.MULTILINE);

    // Code Block (```code```)
    public static final Pattern CODE_BLOCK = Pattern.compile("```(.*?)```", Pattern.DOTALL);

    // Links: [text](url)
    public static final Pattern LINK = Pattern.compile("\\[(.*?)\\]\\((.*?)\\)", Pattern.MULTILINE);

    // Images: ![alt text](url)
    public static final Pattern IMAGE = Pattern.compile("!\\[(.*?)\\]\\((.*?)\\)", Pattern.MULTILINE);

    // Horizontal Rule (--- or ***)
    public static final Pattern HORIZONTAL_RULE = Pattern.compile("^(\\*{3,}|-{3,})$", Pattern.MULTILINE);
}
