package com.codecool.javabst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Skeleton for the Binary search tree. Feel free to modify this class.
public class BinarySearchTree {

    private List<Integer> originalElements;
    private Node rootNode;
    private List<Integer> usedIndices = new ArrayList<>();

    public BinarySearchTree(List<Integer> elements) {

        this.originalElements = elements;
        build();

    }

    public void build() {
        // TODO construct a binary search tree here
        rootNode = createRootNode();
        List<Node> nodesToSet = new LinkedList<>();
        nodesToSet.add(rootNode);
        while (nodesToSet.size() > 0) {

            Node actualNode = ((LinkedList<Node>) nodesToSet).getFirst();
            setSmallerChild(actualNode, nodesToSet);
            setGreaterChild(actualNode, nodesToSet);
            nodesToSet.remove(actualNode);

        }


    }

    public boolean search(Integer toFind) {
        // TODO return true if the element has been found, false if its not in the tree.
        Node actualNode = rootNode;
        while (actualNode != null) {

            if (toFind == actualNode.getValue()) { return true; }
            if (toFind > actualNode.getValue()) { actualNode = actualNode.getGreaterNode(); } else { actualNode = actualNode.getSmallerNode(); }

        }
        return false;
    }

    public void add(Integer toAdd) {
        // TODO adds an element. Throws an error if it exist.
        Node actualNode = rootNode;
        while (true) {

            if (actualNode.getValue() == toAdd) { throw new ElementAlreadyExists("This element is already in the tree"); }
            if (toAdd > actualNode.getValue()) {

                if (actualNode.getGreaterNode() == null) {

                    actualNode.setGreaterNode(new Node(toAdd));
                    System.out.println(actualNode);
                    break;

                } else { actualNode = actualNode.getGreaterNode(); }

            } else {

                if (actualNode.getSmallerNode() == null) {

                    actualNode.setSmallerNode(new Node(toAdd));
                    System.out.println(actualNode);
                    break;

                } else { actualNode = actualNode.getSmallerNode(); }
            }

        }

    }

    public void remove(Integer toRemove) {
        // TODO removes an element. Throws an error if its not on the tree.
    }

    private Node createRootNode() {

        Integer meanValue = originalElements.get(originalElements.size()/2);
        usedIndices.add(originalElements.size()/2);
        return new Node(meanValue, 0, originalElements.size() - 1);

    }

    private void setSmallerChild(Node actualNode, List<Node> nodesToSet) {

        Integer indexOfActualNode = originalElements.indexOf(actualNode.getValue());
        Integer indexOfSmallerChild = (indexOfActualNode + actualNode.getStartIndex())/2;
        if (isValidIndex(indexOfSmallerChild, actualNode)) {

            Node newSmallerNode = new Node(originalElements.get(indexOfSmallerChild), actualNode.getStartIndex(), indexOfActualNode - 1);
            nodesToSet.add(newSmallerNode);
            actualNode.setSmallerNode(newSmallerNode);
            usedIndices.add(indexOfSmallerChild);

        }

    }

    private void setGreaterChild(Node actualNode, List<Node> nodesToSet) {

        Integer indexOfActualNode = originalElements.indexOf(actualNode.getValue());
        Integer indexOfGreaterChild = (actualNode.getEndIndex() + indexOfActualNode + 1)/2;
        if (isValidIndex(indexOfGreaterChild, actualNode)) {

            Node newGreaterNode = new Node(originalElements.get(indexOfGreaterChild), indexOfActualNode + 1, actualNode.getEndIndex());
            nodesToSet.add(newGreaterNode);
            actualNode.setGreaterNode(newGreaterNode);
            usedIndices.add(indexOfGreaterChild);

        }

    }

    private boolean isValidIndex(Integer index, Node actualNode) {

        if (index > 0 && !usedIndices.contains(index)) { return true; }
        if (index == 0 && actualNode.getStartIndex() == 0 && !usedIndices.contains(index)) { return true; }
        return false;
    }

}
