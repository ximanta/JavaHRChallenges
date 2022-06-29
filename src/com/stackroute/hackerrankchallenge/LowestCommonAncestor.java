package com.stackroute.hackerrankchallenge;
public class LowestCommonAncestor {

//    private static final Logger logger = LoggerFactory.getLogger(LowestCommonAncestor.class);
//
//    public static void main(String[] args) {
//
//        Node root = new Node(4);
//        root.left = new Node(2);
//        root.right = new Node(7);
//        root.left.left = new Node(1);
//        root.left.right = new Node(3);
//        root.right.left = new Node(6);
//
//        logger.info(String.valueOf(lca(root, 1, 7)));
//    }

    public static Node lca(Node root, int v1, int v2) {
        if(v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        }
        if(v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        }
        return root;
    }
}

//class Node {
//
//    int data;
//    Node left;
//    Node right;
//
//    public Node(int data) {
//        this.data = data;
//    }
//
//    @Override
//    public String toString() {
//        return String.valueOf(data);
//    }
//}