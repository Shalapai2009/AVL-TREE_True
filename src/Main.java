public class Main {
    public static void main(String[] args) {
       // Node node = new Node("https://www.youtube.com/watch?v=dQw4w9WgXcQ","<!DOCTYPE html>");
        Node node0 = new Node("","0");
        Node node1 = new Node("1","1");
        Node node2 = new Node("11","2");
        Node node3 = new Node("111","3");
        Node node4 = new Node("1111","4");
        Node node5 = new Node("11111","5");
        Node node6 = new Node("111111","6");

        Node node8 = new Node("11111111","8");
        Node node7 = new Node("1111111","7");
        Node node10 = new Node("1111111111","10");
        Node node9 = new Node("111111111","9");
        Node node15 = new Node("111111111111111","15");
        Node node16 = new Node("1111111111111111","16");
        Node node13 = new Node("1111111111111","13");
        Node node12 = new Node("111111111111","12");
        Node node14 = new Node("11111111111111","14");
        AVLTree avlTree = new AVLTree();

        /*avlTree.insertNode(node0);
        avlTree.insertNode(node2);
        avlTree.insertNode(node1);
        avlTree.insertNode(node6);
        avlTree.insertNode(node7);
        avlTree.insertNode(node8);
        avlTree.insertNode(node3);
        avlTree.insertNode(node5);
        avlTree.insertNode(node4);*/

            avlTree.insertNode(node4);
            avlTree.insertNode(node2);
            avlTree.insertNode(node7);
            avlTree.insertNode(node1);
        avlTree.insertNode(node3);
       avlTree.insertNode(node8);
        avlTree.insertNode(node9);
        avlTree.insertNode(node10);
        /*avlTree.insertNode(node1);
        avlTree.insertNode(node2);
        avlTree.insertNode(node3);
        avlTree.insertNode(node4);*/
        //avlTree.deleteNode(node2);
        //avlTree.findNodeByNode(node4);
        //System.out.println(avlTree.findNodeByKey("11111111111111").getLengthKeyUrl());
       //System.out.println(avlTree.findNodeByNode(new Node("11111","5")).getLengthKeyUrl());
        System.out.println("/");
     //  avlTree.printTree();

    }
}