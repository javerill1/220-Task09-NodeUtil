package edu.ithaca.dragon.datastructures.node;

public class RecursiveTraceMain {

    public static int recursion(LinkedNode<Integer> current){
        if (current == null){
            return 0;
        }
        else {
            int tr = recursion(current.getNext());
            int nt = tr + current.getItem();
            return nt;
        }
    }

    public static int recursionTail(LinkedNode<Integer> current, int total){
        if (current == null){
            return total;
        } else {
            int nt = total + current.getItem();
            return recursionTail(current.getNext(), nt);
        }
    }

    public static int recursionTail(LinkedNode<Integer> current){
        return recursionTail(current, 0);
    }

    public static void main(String[] args){
        LinkedNode<Integer> example = new LinkedNode<>(1, new LinkedNode<>(2, new LinkedNode<>(3, new LinkedNode<>(4))));

        int recursionAnswer = recursion(example);
        System.out.println(recursionAnswer);

        int recursionTailAnswer = recursionTail(example);
        System.out.println(recursionTailAnswer);
    }
    
}
