package com.stackroute.hackerrankchallenge;

import com.stackroute.hackerrankchallenge.doublylinkedlist.DoublyLinkedListNode;

public class InsertDoublyLinkedListNode {
  //  private static final Logger logger = LoggerFactory.getLogger(InsertDoublyLinkedList.class);

//    public static void main(String[] args) {
//        DoublyLinkedListNode head = new DoublyLinkedListNode(1);
//        head.setNext(new DoublyLinkedListNode(3));
//        head.getNext().setNext(new DoublyLinkedListNode(4));
//        head.getNext().getNext().setNext(new DoublyLinkedListNode(10));
//
//        logger.info(String.valueOf(sortedInsert(head, 5)));
//
//    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

        if(head == null) return head;

        DoublyLinkedListNode current = head;
        DoublyLinkedListNode previous = null;
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        while (current != null && current.getData() < data) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            head = newNode;
        } else {
            // re-link previous node
            previous.setNext(newNode);
            newNode.setPrev(previous);
        }

        if (current != null) {
            // re-link next node
            current.setPrev(newNode);
            newNode.setNext(current);
        }

        return head;
    }
}
