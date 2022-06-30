package com.stackroute.hackerrankchallenge;

class HuffNode {

    public int frequency; // the frequency of this tree
    public char data;
    public HuffNode left, right;

    public HuffNode() {}

    public HuffNode(int frequency) {
        this.frequency = frequency;
    }

    public HuffNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }
}
public class HuffManDecoding {
    public static void main(String[] args) {

        HuffNode node = new HuffNode();

        node.frequency = 5;

        node.left = new HuffNode(2);
        node.right = new HuffNode('A', 3);

        node.left.left = new HuffNode('B', 1);
        node.left.right = new HuffNode('C', 1);

        decode("1001011", node);
    }

    static void decode(String s, HuffNode root) {

        StringBuilder sb = new StringBuilder();
        HuffNode huffCode = root;
        for (int i = 0; i < s.length(); i++) {
            huffCode = s.charAt(i) == '1' ? huffCode.right : huffCode.left;
            if (huffCode.left == null && huffCode.right == null) {
                sb.append(huffCode.data);
                huffCode = root;
            }
        }

        System.out.print(sb);
    }

}
