package com.codecool.javabst;

public class Node {

    private Integer value;
    private Node smallerNode;
    private Node greaterNode;
    private Integer startIndexOfRemainingNodes;
    private Integer endIndexOfRemainingNodes;

    public Node(Integer value, Integer startIndexOfRemainingNodes, Integer endIndexOfRemainingNodes) {
        this.value = value;
        this.startIndexOfRemainingNodes = startIndexOfRemainingNodes;
        this.endIndexOfRemainingNodes = endIndexOfRemainingNodes;
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

    public Integer getStartIndexOfRemainingNodes() {
        return startIndexOfRemainingNodes;
    }


    public Integer getEndIndexOfRemainingNodes() {
        return endIndexOfRemainingNodes;
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
