package org.example.nodes;

public class BoldNode implements MDNode {
    String content;
public BoldNode(String content) {
        this.content = content;
    }
    public String getContent() { return content; }
}
