public class Main {
    public static void main(String[] args) {
       // Node node = new Node("https://www.youtube.com/watch?v=dQw4w9WgXcQ","<!DOCTYPE html>");
        AVLTree avlTree = new AVLTree();
        avlTree.insertNode(new Node("111","111"));
        avlTree.insertNode(new Node("1111","1111"));
        avlTree.insertNode(new Node("1111111","111111"));
        avlTree.insertNode(new Node("1","1"));
        avlTree.insertNode(new Node("1","1"));
        avlTree.insertNode(new Node("1","1"));
        avlTree.insertNode(new Node("1","1"));
        avlTree.insertNode(new Node("11","11"));

        avlTree.insertNode(new Node("11111111","1111111"));

        avlTree.printTree();

    }
}