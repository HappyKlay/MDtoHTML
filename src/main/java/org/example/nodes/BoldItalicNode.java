package org.example.nodes;

public class BoldItalicNode  implements MDNode{
    String content;
    public BoldItalicNode(String content) {
        this.content = content;
    }
    public String getContent() { return content; }
}
