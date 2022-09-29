package edu.ithaca.dragon.datastructures.node;

public class RecursiveNodeUtil<T> implements NodeUtil<T>{

    @Override
    public int countNodes(LinkedNode<T> aNode) {
        int count = 0;
        if (aNode.getItem() == null){
            return count;
        } else {
        count++;
        countNodes(aNode);
        }
        return count;
    }

    @Override
    public boolean contains(LinkedNode<T> aNode, T itemToFind) {
        // Tail recursion
        if (aNode == null){  
            return false;
        } 
        else if (aNode.getItem().equals(itemToFind)){
            return true;
        } 
        else {
            boolean ans = contains(aNode.getNext(), itemToFind);
            return ans;
        }
        // Normal Recursion
 /*     if (aNode == null){  
            return false;
        } else {
            boolean checkRest = contains(aNode.getNext(), itemToFind);
            if (aNode.getItem().equals(itemToFind)){
                return true;
            } else {
                return false;
            }
        }
*/
    }

    @Override
    public int countOccurrences(LinkedNode<T> aNode, T itemToFind) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public LinkedNode<T> nodeAtIndex(LinkedNode<T> aNode, int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int indexOfFirstNodeContaining(LinkedNode<T> aNode, T itemToFind) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int indexOfLastNodeContaining(LinkedNode<T> aNode, T itemToFind) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public LinkedNode<T> removeFirst(LinkedNode<T> aNode, T itemToRemove) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LinkedNode<T> removeAll(LinkedNode<T> aNode, T itemToRemove) {
        // TODO Auto-generated method stub
        return null;
    }
    



    
}
