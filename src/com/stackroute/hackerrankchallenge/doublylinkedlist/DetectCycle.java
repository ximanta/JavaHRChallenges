package com.stackroute.hackerrankchallenge.doublylinkedlist;

public class DetectCycle {
//    private static final Logger logger = LoggerFactory.getLogger(DetectCycle.class);
//
//    public static void main(String[] args) {
//
//        //Test first list - 1 -> null
//        Node test = new Node(1);
//
//        logger.info(String.valueOf(hasCycle(test)));
//
//        //Test second list - 1 -> 2 -> 3 -> 2 -> 3 [...]
//        Node head = new Node(1);
//        Node next = new Node(2);
//        head.setNext(next);
//        head.getNext().setNext(new Node(3));
//        head.getNext().getNext().setNext(next);
//
//        logger.info(String.valueOf(hasCycle(head)));
  //  }

    /**
     * Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
     */
    static boolean hasCycle(Node head) {

        if(head == null) return false;

        //Using the concept of one pointer moving faster than another, since at some point both will meet
        //at the same point and close a cycle (if any).
        Node slowPointerNode = head;
        Node fastPointerNode = head.getNext();

        while(fastPointerNode != null && fastPointerNode.getNext() != null) {
            if(slowPointerNode == fastPointerNode) {
                return true;
            }
            slowPointerNode = slowPointerNode.getNext();
            fastPointerNode = fastPointerNode.getNext().getNext();
        }

        return false;
    }
}
