package org.example.nodes;

public class HeadingNode implements MDNode {
    private final byte level;
    private final String content;

    public HeadingNode(byte level, String text) {
        if (level < 1 || level > 7) {
            throw new IllegalArgumentException("level must be 1 to 6");
        }
        this.level = level;
        this.content = text;
    }

    public byte getLevel() { return level; }
    public String content() { return content; }
}
