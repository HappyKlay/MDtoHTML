package org.example.nodes;

public class ItalicNode implements MDNode {
    String content;
    public ItalicNode(String content) {
        this.content = content;
    }
    public String getContent() { return content; }
}
