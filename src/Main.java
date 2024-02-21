public class Main {
    public static void main(String[] args) {
       // Node node = new Node("https://www.youtube.com/watch?v=dQw4w9WgXcQ","<!DOCTYPE html>");
        Node node1 = new Node("1","1");
        Node node2 = new Node("11","2");
        Node node3 = new Node("111","3");
        Node node4 = new Node("1111","4");
        Node node5 = new Node("11111","5");
        AVLTree avlTree = new AVLTree();
        avlTree.insertNode(node1);
        avlTree.insertNode(node2);
        avlTree.insertNode(node3);
        avlTree.insertNode(node4);
        avlTree.insertNode(node5);

        avlTree.deleteNode(node4);
       // System.out.println(avlTree.findNodeByNode(new Node("11111","5")).getLengthKeyUrl());
        System.out.println("/");
     //  avlTree.printTree();

    }
}