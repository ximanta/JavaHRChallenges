package com.stackroute.hackerrankchallenge;

public class NodeSpecificPositionSinglyLinkedList {
   // private static final Logger logger = LoggerFactory.getLogger(NodeSpecificPosition.class);

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        SinglyLinkedListNode currentNode = head;

        int index = 0;

        while(index < position-1) {
            currentNode = currentNode.next;
            index++;
        }

        newNode.next = currentNode.next;
        currentNode.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode head = new SinglyLinkedListNode();
        SinglyLinkedListNode current = new SinglyLinkedListNode();

        int[] arr = {16, 13, 7};
        for(int i=0; i<arr.length; i++) {

            if(i==0) {
                head.setData(arr[i]);
                head.setNext(head.next);
                current = head;
            }else {
                SinglyLinkedListNode newNode = new SinglyLinkedListNode();
                newNode.data = arr[i];
                newNode.next = current.next;
                current.next = newNode;
                current = newNode;
            }
        }

        insertNodeAtPosition(head, 1, 2); //we have to insert 1 at the position 2

        SinglyLinkedListNode node = head;
        while(node.next != null) {
           // logger.info(String.valueOf(node));
            node = node.next;
        }
        //logger.info(String.valueOf(node));
    }

}

class SinglyLinkedList {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedList(){}

    public SinglyLinkedList(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SinglyLinkedListNode getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

}

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    SinglyLinkedListNode(){}

    SinglyLinkedListNode(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public SinglyLinkedListNode getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
