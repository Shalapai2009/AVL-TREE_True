import java.math.BigInteger;

public class Node {

    private String keyUrl;
    private String codeHtml;
    private int height = 0;
    private Node parent; // Батя
    private Node leftChild; // Левый узел потомок
    private Node rightChild; // Правый узел потомок
    public Node(String keyUrl, String codeHtml) {
        this.keyUrl = keyUrl;
        this.codeHtml = codeHtml;
    }

    public String getKeyUrl() {
        return keyUrl;
    }
    public String getCodeHtml(){
        return codeHtml;
    }
    public int getHeight(){
        return height;
    }
    public int getLeftChildHeight(){
        if (leftChild==null) {return -1;}else{
        return height;}//ГОВНИЩЕ А НЕ КОД
    }
    public int getRightChildHeight(){
        if (rightChild==null){return -1;}else{
            return height;}//ТРИЖДЫ ПЕРЕВАРЕННЫЙ КАЛ
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public void setCodeHtml(String codeHtml) {
        this.codeHtml = codeHtml;
    }

    public void setKeyUrl(String keyUrl) {
        this.keyUrl = keyUrl;
    }
    public int getLengthKeyUrl(){
        return keyUrl.length();
    }
    public Node getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
    public Node getParent() {
        return this.parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

}
