package edu.ithaca.dragon.datastructures.node;

import java.util.NoSuchElementException;

public class RecursiveNodeUtil<T> implements NodeUtil<T>{

    @Override
    public int countNodes(LinkedNode<T> aNode) {
        LinkedNode<T> current = aNode;
        int count = 0;
        if (current == null){
            return 0;
        } 
        else {
        count = countNodes(current.getNext());
        count++;
        return count;
        }
    }

    @Override
    public boolean contains(LinkedNode<T> aNode, T itemToFind) {
        LinkedNode<T> current = aNode;
        // Tail recursion
        if (current == null){  
            return false;
        } 
        else if (current.getItem().equals(itemToFind)){
            return true;
        }
        else {
            boolean ans = contains(current.getNext(), itemToFind);
            return ans;
        }
        // Normal Recursion
 /*     if (current == null){  
            return false;
        } else {
            boolean checkRest = contains(current.getNext(), itemToFind);
            if (current.getItem().equals(itemToFind)){
                return true;
            } else {
                return false;
            }
        }
*/
    }

    @Override
    public int countOccurrences(LinkedNode<T> aNode, T itemToFind) {
        LinkedNode<T> current = aNode;
        if (current == null){  
            return 0;
        }
        if (current.getItem() == itemToFind){
                return 1+countOccurrences(current.getNext(), itemToFind);
        }
        return countOccurrences(current.getNext(), itemToFind);
    }


    public LinkedNode<T> nodeAtIndex(LinkedNode<T> aNode, int index, int count) {
        LinkedNode<T> current = aNode;
        if (current == null){  
            throw new IndexOutOfBoundsException();
        }
        else if (count == index){
            return current;
        }
        else {
            count++;
            LinkedNode<T> theNode = nodeAtIndex(current.getNext(), index, count);
            return theNode;
        }
    }

    @Override
    public LinkedNode<T> nodeAtIndex(LinkedNode<T> aNode, int index) {
        int count = 0;
        return nodeAtIndex(aNode, index, count);
    }

    
    @Override
    public int indexOfFirstNodeContaining(LinkedNode<T> aNode, T itemToFind) {
        LinkedNode<T> current = aNode;
        RecursiveNodeUtil<T> index = new RecursiveNodeUtil<>();
        if (index.contains(current, itemToFind) == false){
            return -1;
        }
        else if (current.getItem() == itemToFind){
            return 0;
        }
        else {
            int nextNode = indexOfFirstNodeContaining(current.getNext(), itemToFind);
            return 1+nextNode;
        }
    }


    public int indexOfLastNodeContaining(LinkedNode<T> aNode, T itemToFind, int index, int count) {
        LinkedNode<T> current = aNode;
        if(current == null){
            return index;
        }
        else if(current.getItem() == itemToFind){
            index = count;
            return indexOfLastNodeContaining(current.getNext(), itemToFind, index, count+1);
        }
        else {
            return indexOfLastNodeContaining(current.getNext(), itemToFind, index, count+1);
        }
    }


    @Override
    public int indexOfLastNodeContaining(LinkedNode<T> aNode, T itemToFind) {
        LinkedNode<T> current = aNode;
        if (this.contains(current, itemToFind) == false){
            return -1;
        } else {
            return indexOfLastNodeContaining(aNode, itemToFind, 0, 0);
        }
    }

    @Override
    public LinkedNode<T> removeFirst(LinkedNode<T> aNode, T itemToRemove) { // non-tail recursive way
        // if the LinkedList doesn't contain
        if (!contains(aNode, itemToRemove)){
            throw new NoSuchElementException();
        }
        // if there are no nodes at all
        if (aNode == null) {
            return null;
        }
        // if the current node is the thing to remove then return a pointer to the following node
        if (aNode.getItem() == itemToRemove) {
            aNode = aNode.getNext();
            return aNode;
        }
        // if its not then all you want to do is make a recursive call on this function and then set next to where the pointer is
        aNode.setNext(removeFirst(aNode.getNext(), itemToRemove));
        return aNode;
    }

    @Override
    public LinkedNode<T> removeAll(LinkedNode<T> aNode, T itemToRemove) {
        // if the LinkedList is empty
        if (aNode == null) {
            return null;
        }
        // if the node is equal to itemToRemove make recursive call of removeAll
        // removing the node
        if (aNode.getItem() == itemToRemove) {
            return removeAll(aNode.getNext(), itemToRemove);
        }
        // setting the next node and making a recursive call
        // setting the pointer to the next node
        aNode.setNext(removeAll(aNode.getNext(), itemToRemove));
        return aNode;
    }

}
