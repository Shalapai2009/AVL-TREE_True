import javax.swing.plaf.PanelUI;
import java.util.Stack;

public class AVLTree {
    private Node rootNode; // корневой узел

    public AVLTree() { // Пустое дерево
        rootNode = null;
    }
    public void insertNode(Node node){
        if (rootNode == null){
            rootNode = node;
        }
        else {
            Node currentNode = rootNode; // начинаем с корневого узла
            while (true) {
                if (currentNode.getLengthKeyUrl() > node.getLengthKeyUrl()) {
                    if (currentNode.getLeftChild() == null){

                        currentNode.setLeftChild(node);
                        currentNode.getLeftChild().setParent(currentNode);
                    return;}
                    else {
                        currentNode = currentNode.getLeftChild();
                    }
                } else {
                    if (currentNode.getRightChild() == null){
                        currentNode.setRightChild(node);
                        currentNode.getRightChild().setParent(currentNode);
                        return;
                    }
                    else {
                        currentNode = currentNode.getRightChild();

                    }
                }
            }
        }
    }
    public Node findNodeByKey(String keyUrl){
            String key = keyUrl;
            int keyLength = key.length();
                Node currentNode = rootNode;
                while (currentNode != null){
                    if (currentNode.getLengthKeyUrl() == keyLength  & currentNode.getKeyUrl().equals(key)) {
                        return currentNode;
                    } else if (currentNode.getLengthKeyUrl() >= keyLength) {
                        currentNode = currentNode.getLeftChild();
                    }
                      else if ( currentNode.getLengthKeyUrl() < keyLength) {
                    currentNode = currentNode.getRightChild();
                }

                }
                throw new NullPointerException("Не существует такого URL");
                //return null;
    }
    public Node findNodeByNode(Node node){
        Node currentNode = rootNode;
        while (currentNode != null){
            if (currentNode.getLengthKeyUrl() == node.getLengthKeyUrl()) {
                return currentNode;
            } else if (currentNode.getLengthKeyUrl() >= node.getLengthKeyUrl()) {
                currentNode = currentNode.getLeftChild();
            }
            else if ( currentNode.getLengthKeyUrl() < node.getLengthKeyUrl()) {
                currentNode = currentNode.getRightChild();
            }
        }
        throw new NullPointerException("Не существует такой ячейки");
        //return null;
    }
    public void deleteNode(Node node){
       Node currentNode = findNodeByNode(node);
        if (currentNode.getRightChild() == null & currentNode.getLeftChild() == null){
            currentNode = currentNode.getParent();
            if (currentNode.getRightChild() == null & currentNode.getLeftChild() != null){
            currentNode.setLeftChild(null);}
            else {currentNode.setRightChild(null);}

        } else if (currentNode.getRightChild() == null & currentNode.getLeftChild() != null) {
            currentNode.getParent().setLeftChild(currentNode.getLeftChild());
            currentNode.getLeftChild().setParent(currentNode.getParent());// Вот это строка мне вообще не нравится. Неразумно; upd: Исправил находящуюся там ересь, но все равно кривовато
        }
        else if (currentNode.getRightChild() != null & currentNode.getLeftChild() == null) {
            currentNode.getParent().setRightChild(currentNode.getRightChild());
            currentNode.getRightChild().setParent(currentNode.getParent());// Вот это строка мне вообще не нравится. Неразумно; upd: Исправил находящуюся там ересь, но все равно кривовато
        }
        else {

        }
    }


    public void printTree() { // метод для вывода дерева в консоль
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(rootNode);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getLengthKeyUrl()); // выводим его значение в консоли
                    localStack.push(temp.getLeftChild()); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }


}
