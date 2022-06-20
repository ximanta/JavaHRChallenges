package com.stackroute.hackerrankchallenge.doublylinkedlist;

public class ReverseDoublyLinkedList {
//    private static final Logger logger = LoggerFactory.getLogger(ReverseDoublyLinkedList.class);

//    public static void main(String[] args) {
//
//        DoublyLinkedListNode head = new DoublyLinkedListNode(1);
//        head.setNext(new DoublyLinkedListNode(2));
//        head.getNext().setNext(new DoublyLinkedListNode(3));
//        head.getNext().getNext().setNext(new DoublyLinkedListNode(4));
//
////        logger.info(String.valueOf(reverse(head)));
//    }

    // Complete the reverse function below.
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {

        if(head == null) return head;

        DoublyLinkedListNode currentNode = head;
        DoublyLinkedListNode newHead = head;

        while (currentNode != null) {
            DoublyLinkedListNode prev = currentNode.getPrev();
            currentNode.setPrev(currentNode.getNext());
            currentNode.setNext(prev);
            newHead = currentNode;

            //Because we are reversing the list
            currentNode = currentNode.getPrev();
        }

        return newHead;
    }
}
