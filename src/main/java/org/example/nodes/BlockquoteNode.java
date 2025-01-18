package org.example.nodes;

public record BlockquoteNode(String content) implements MDNode {
    @Override
    public String content() {
        return "";
    }
}
