package org.example.nodes;

public class TextNode implements MDNode {
    String content;

    public TextNode(String content) {
        this.content = content;
    }

    public String getContent() { return content; }
}
