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
            setChildNode("SMALLER",actualNode, nodesToSet);
            setChildNode("GREATER", actualNode, nodesToSet);
            nodesToSet.remove(actualNode);

        }

    }

    public boolean search(Integer toFind) {
        // TODO return true if the element has been found, false if its not in the tree.
        Node actualNode = rootNode;
        while (actualNode != null) {

            if (toFind.equals(actualNode.getValue())) { return true; }
            if (toFind > actualNode.getValue()) { actualNode = actualNode.getGreaterNode(); } else { actualNode = actualNode.getSmallerNode(); }

        }
        return false;
    }

    public void add(Integer toAdd) {
        // TODO adds an element. Throws an error if it exist.
        Node actualNode = rootNode;
        boolean foundPlaceForNewNode = false;
        while (!foundPlaceForNewNode) {

            if (actualNode.getValue().equals(toAdd)) { throw new ElementAlreadyExists("This element is already in the tree"); }
            if (toAdd > actualNode.getValue()) {

                if (actualNode.getGreaterNode() == null) {

                    actualNode.setGreaterNode(new Node(toAdd));
                    System.out.println(actualNode);
                    foundPlaceForNewNode = true;

                } else { actualNode = actualNode.getGreaterNode(); }

            } else {

                if (actualNode.getSmallerNode() == null) {

                    actualNode.setSmallerNode(new Node(toAdd));
                    System.out.println(actualNode);
                    foundPlaceForNewNode = true;

                } else { actualNode = actualNode.getSmallerNode(); }
            }

        }

    }

    public void remove(Integer toRemove) {
        // TODO removes an element. Throws an error if its not on the tree.
        if(!search(toRemove)) { throw new ElementNotFound("Element is not in the tree"); }
        Node actualNode = rootNode;
        while (actualNode != null) {

            if (toRemove > actualNode.getValue()) {

                if (actualNode.getGreaterNode().getValue().equals(toRemove)) { actualNode.setGreaterNode(null); }
                actualNode = actualNode.getGreaterNode();

            } else {

                if (actualNode.getSmallerNode().getValue().equals(toRemove)) { actualNode.setSmallerNode(null); }
                actualNode = actualNode.getSmallerNode();

            }

        }
    }

    private Node createRootNode() {

        Integer meanValue = originalElements.get(originalElements.size()/2);
        usedIndices.add(originalElements.size()/2);
        return new Node(meanValue, 0, originalElements.size() - 1);

    }

    private void setChildNode(String smallerOrGreater, Node actualNode, List<Node> nodesToSet) {

        Integer indexOfActualNode = originalElements.indexOf(actualNode.getValue());
        Integer index;
        Integer startIndex;
        Integer endIndex;
        boolean isSmaller;
        switch (smallerOrGreater.toLowerCase()){

            case "smaller" :
                index = (indexOfActualNode + actualNode.getStartIndex())/2;
                startIndex = actualNode.getStartIndex();
                endIndex = indexOfActualNode - 1;
                isSmaller = true;
                break;
            case "greater" :
                index = (actualNode.getEndIndex() + indexOfActualNode + 1)/2;
                startIndex = indexOfActualNode + 1;
                endIndex = actualNode.getEndIndex();
                isSmaller = false;
                break;
            default:
                throw new IllegalArgumentException("Illegal value: " + smallerOrGreater);

        }

        if (isValidIndex(index, actualNode)) {

            Node newNode = new Node(originalElements.get(index), startIndex, endIndex);
            nodesToSet.add(newNode);
            if (isSmaller) { actualNode.setSmallerNode(newNode); } else { actualNode.setGreaterNode(newNode); }
            usedIndices.add(index);

        }

    }

    private boolean isValidIndex(Integer index, Node actualNode) {

        if (index > 0 && !usedIndices.contains(index)) { return true; }
        if (index == 0 && actualNode.getStartIndex() == 0 && !usedIndices.contains(index)) { return true; }
        return false;
    }

}
