package com.codecool.javabst;

public class Node {

    private Integer value;
    private Node smallerNode;
    private Node greaterNode;
    private Integer startIndex;
    private Integer endIndex;

    public Node(Integer value, Integer startIndex, Integer endIndex) {
        this.value = value;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public Node(Integer value) {
        this.value = value;
    }

    public Node getSmallerNode() {
        return smallerNode;
    }

    public void setSmallerNode(Node smallerNode) {
        this.smallerNode = smallerNode;
    }

    public Node getGreaterNode() {
        return greaterNode;
    }

    public void setGreaterNode(Node greaterNode) {
        this.greaterNode = greaterNode;
    }

    public Integer getStartIndex() {
        return startIndex;
    }


    public Integer getEndIndex() {
        return endIndex;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", smallerNode=" + smallerNode +
                ", greaterNode=" + greaterNode +
                '}';
    }
}
