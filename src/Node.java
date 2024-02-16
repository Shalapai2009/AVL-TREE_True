import java.math.BigInteger;

public class Node {
    private String keyUrl;
    private String codeHtml;
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

    public void setLeftChild(final Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(final Node rightChild) {
        this.rightChild = rightChild;
    }

}
