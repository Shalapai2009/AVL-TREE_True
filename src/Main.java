public class Main {
    public static void main(String[] args) {
       // Node node = new Node("https://www.youtube.com/watch?v=dQw4w9WgXcQ","<!DOCTYPE html>");
        Node node = new Node("11111","5");
        AVLTree avlTree = new AVLTree();
        avlTree.insertNode(new Node("1","1"));
        avlTree.insertNode(new Node("11","2"));
        avlTree.insertNode(new Node("111","3"));
        avlTree.insertNode(new Node("1111","4"));
        avlTree.insertNode(node);

        avlTree.deleteNode(node);
       // System.out.println(avlTree.findNodeByNode(new Node("11111","5")).getLengthKeyUrl());
        System.out.println("/");
       avlTree.printTree();

    }
}