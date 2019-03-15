package com.codecool.javabst;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;



public class BinarySearchTreeTest {

    public List<Integer> generateNumbers(int size) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(i * 2 + 5);
        }

        return numbers;
    }

    @Test
    public void searchReturnsTrueForExistingElement() {

        int size = 10;
        List<Integer> numbers = generateNumbers(size);
        BinarySearchTree binarySearchTree = new BinarySearchTree(numbers);
        assertTrue(binarySearchTree.search(9));

    }

    @Test
    public void searchReturnsFalseForNonExistingElement() {

        int size = 10;
        List<Integer> numbers = generateNumbers(size);
        BinarySearchTree binarySearchTree = new BinarySearchTree(numbers);
        assertFalse(binarySearchTree.search(79));

    }

    @Test
    public void BTSBuilderUsesEveryNumber() {

        int size = 100;
        List<Integer> numbers = generateNumbers(size);
        BinarySearchTree binarySearchTree = new BinarySearchTree(numbers);
        for (Integer number: numbers) { assertTrue(binarySearchTree.search(number)); }

    }

    @Test
    public void addIsaddingNewElement() {

        int size = 10;
        List<Integer> numbers = generateNumbers(size);
        BinarySearchTree binarySearchTree = new BinarySearchTree(numbers);
        assertFalse(binarySearchTree.search(1500));
        binarySearchTree.add(1500);
        assertTrue(binarySearchTree.search(1500));

    }

    @Test
    public void addThrowsExceptionIfElementExistsInTree() {

        int size = 10;
        List<Integer> numbers = generateNumbers(size);
        BinarySearchTree binarySearchTree = new BinarySearchTree(numbers);
        assertThrows(ElementAlreadyExists.class, () -> binarySearchTree.add(7));

    }

    @Test
    public void removeRemovesElement() {

        int size = 10;
        List<Integer> numbers = generateNumbers(size);
        BinarySearchTree binarySearchTree = new BinarySearchTree(numbers);
        assertTrue(binarySearchTree.search(7));
        binarySearchTree.remove(7);
        assertFalse(binarySearchTree.search(7));

    }

    @Test
    public void removeThrowsElementNotFoundException() {

        int size = 10;
        List<Integer> numbers = generateNumbers(size);
        BinarySearchTree binarySearchTree = new BinarySearchTree(numbers);
        assertFalse(binarySearchTree.search(87));
        assertThrows(ElementNotFound.class, () -> binarySearchTree.remove(87));

    }



}
