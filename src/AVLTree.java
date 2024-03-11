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
            updateHeight(node);
        }
        else {
            Node currentNode = rootNode; // начинаем с корневого узла
            while (true) {
                if (currentNode.getLengthKeyUrl() > node.getLengthKeyUrl()) {
                    if (currentNode.getLeftChild() == null){

                        currentNode.setLeftChild(node);
                        currentNode.getLeftChild().setParent(currentNode);
                        updateHeight(currentNode);
                        balance(currentNode);
                        return;}
                    else {
                        currentNode = currentNode.getLeftChild();
                    }
                }
                else {
                    if (currentNode.getRightChild() == null){
                        currentNode.setRightChild(node);
                        currentNode.getRightChild().setParent(currentNode);
                        updateHeight(currentNode);
                        balance(currentNode);
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
        if (currentNode.getParent()==null){// Мы хотим удалить первый член дерева
            if (currentNode.getLeftChild() == null & currentNode.getRightChild() == null) {//если у узла не было потомков
                rootNode = null;
            }
            else if (currentNode.getLeftChild() == null & currentNode.getRightChild() != null){//если у узла был только ПРАВЫЙ один потомок
                rootNode = currentNode.getRightChild();
                rootNode.setParent(null);
            }  else if (currentNode.getLeftChild() != null & currentNode.getRightChild() == null){//если у узла был только ЛЕВЫЙ один потомок
                rootNode = currentNode.getLeftChild();
                rootNode.setParent(null);
            }
            else {//но что желать если существуют два ребенка
                if (currentNode.getRightChild().getLeftChild() != null){//проверяем правого ребенка есть ли у него левый ребенок
//если да, то идем по левому до конца и меняем удаляемый на найденый
                    Node rightNode = currentNode.getRightChild();
                    while (rightNode.getLeftChild() != null){
                        rightNode = rightNode.getLeftChild();
                    }
                    deleteNode(rightNode);
                    currentNode.setCodeHtml(rightNode.getCodeHtml());
                    currentNode.setKeyUrl(rightNode.getKeyUrl());

                } else {
                    //если нет, то перезаписываем дерево на правого ребенка, и даем ему левого ребенка начального дерева, попутно перезаписывая отца левого ребенка на правого ребенка
                    Node leftNode =  currentNode.getLeftChild();
                    rootNode = currentNode.getRightChild();
                    leftNode.setParent(rootNode);
                    rootNode.setLeftChild(leftNode);
                    rootNode.setParent(null);
                    //updateHeight(currentNode.getLeftChild());
                    // АХТУНГ КОРРЕКТНАЯ РАБОТА СЧЕТЧИКА ВЫСОТЫ НЕ ПРОВЕРЯЛАСЬ В ПОЛНОЙ МЕРЕ
                }
            }
        } else {
            if (currentNode.getRightChild() == null & currentNode.getLeftChild() == null){// если же у узла нет детей, то
                if (currentNode.getParent().getRightChild() == currentNode){
                    currentNode.getParent().setRightChild(null);
                } else currentNode.getParent().setLeftChild(null);
                updateHeight(currentNode.getParent());
                balance(currentNode.getParent());
            } else if (currentNode.getRightChild() == null & currentNode.getLeftChild() != null) { // если есть только ЛЕВЫЙ ребенок
                if (currentNode.getParent().getRightChild() == currentNode){
                    currentNode.getParent().setRightChild(null);
                } else {currentNode.getParent().setLeftChild(null);}
                insertNode(currentNode.getLeftChild());
                balance(currentNode.getParent());
            }
            else if (currentNode.getRightChild() != null & currentNode.getLeftChild() == null) { // если есть только ПРАВЫЙ ребенок
                if (currentNode.getParent().getRightChild() == currentNode){
                    currentNode.getParent().setRightChild(null);
                    insertNode(currentNode.getRightChild());
                } else {currentNode.getParent().setLeftChild(null);}
                insertNode(currentNode.getRightChild());
                balance(rootNode);
            }
            else if (currentNode.getRightChild() != null & currentNode.getLeftChild() != null){//но что желать если существуют два ребенка
                if (currentNode.getRightChild().getLeftChild() != null){//проверяем правого ребенка есть ли у него дети
//если да, то идем по левому до конца и меняем удаляемый на найденый
                    Node rightNode = currentNode.getRightChild();
                    while (rightNode.getLeftChild() != null){
                        rightNode = rightNode.getLeftChild();
                    }
                    deleteNode(rightNode);
                    currentNode.setCodeHtml(rightNode.getCodeHtml());
                    currentNode.setKeyUrl(rightNode.getKeyUrl());
                    balance(rootNode);
                    /*if (rightNode.getRightChild() != null){
                        rightNode.getParent().setLeftChild(rightNode.getRightChild());
                        rightNode.getRightChild().setParent(rightNode.getParent());
                        currentNode.setCodeHtml(rightNode.getCodeHtml());
                        currentNode.setKeyUrl(rightNode.getKeyUrl());
                        //updateHeight(rightNode.getRightChild());// ВОЗМОЖНА НЕСОСТЫКОВКА НЕОБХОДИМО ПРОВЕРИТЬ И ПОФИКСИТЬ

                    } else  {
                    deleteNode(rightNode);// хехе недорекурсия
                    currentNode.setCodeHtml(rightNode.getCodeHtml());
                    currentNode.setKeyUrl(rightNode.getKeyUrl());
                     //   updateHeight(rightNode.getParent());
                    }*/
                } else {
                    //если нет, то перезаписываем дерево на правого ребенка, и даем ему левого ребенка начального дерева попутно перезаписывая отца левого ребенка на правого ребенка
                    Node leftNode =  currentNode.getLeftChild();
                    currentNode.getParent().setRightChild(currentNode.getRightChild());
                    leftNode.setParent(currentNode.getRightChild());
                    currentNode.getRightChild().setLeftChild(leftNode);
                    currentNode.getRightChild().setParent(currentNode.getParent());
                    balance(rootNode);
                    // updateHeight(currentNode.getLeftChild());
                    //СТРАШНОЕ НЕДОПРОВЕРЕННОЕ МЕСТО
                    // АХТУНГ КОРРЕКТНАЯ РАБОТА СЧЕТЧИКА ВЫСОТЫ НЕ ПРОВЕРЯЛАСЬ В ПОЛНОЙ МЕРЕ
                }
            }
        }}
    private void updateHeight(Node node){
        Node currentNode = node;
        while (currentNode != null) {
            int rightChild;
            int leftChild;
            if (currentNode.getRightChild() ==null){
                rightChild = -1;
            } else {rightChild = currentNode.getRightChild().getHeight();}
            if (currentNode.getLeftChild() ==null){
                leftChild = -1;
            } else {leftChild = currentNode.getLeftChild().getHeight();}
            int maxHeight = (Math.max(rightChild, leftChild) + 1);
            currentNode.setHeight(maxHeight);
            currentNode = currentNode.getParent();
        }
    }
    public int getBalance(Node node){
        Node currentNode = node;
        int rightChild;
        int leftChild;
        if (currentNode.getRightChild() == null){
            rightChild = -1;
        } else {rightChild = currentNode.getRightChild().getHeight();}
        if (currentNode.getLeftChild() ==null){
            leftChild = -1;
        } else {leftChild = currentNode.getLeftChild().getHeight();}
        return rightChild - leftChild;
    }
    private void supportingSwap(Node firstNode, Node secondNode){
        String firstKey = firstNode.getKeyUrl();
        String firstCode = firstNode.getCodeHtml();
        Node firstParent = firstNode.getParent();

        String secondKey = secondNode.getKeyUrl();
        String secondCode = secondNode.getCodeHtml();
        Node secondParent = secondNode.getParent();
        firstNode.setKeyUrl(secondKey);
        firstNode.setCodeHtml(secondCode);
        //firstNode.setParent(secondParent);

        secondNode.setKeyUrl(firstKey);
        secondNode.setCodeHtml(firstCode);
        //secondNode.setParent(firstParent);
    }
    private void rightRotate(Node node){
        supportingSwap(node, node.getLeftChild());

        //
        Node buffer = node.getRightChild();
        //
        node.setRightChild(node.getLeftChild());
        node.setLeftChild(node.getRightChild().getLeftChild());
        if (node.getLeftChild()!= null){
        node.getLeftChild().setParent(node);}
        node.getRightChild().setLeftChild(node.getRightChild().getRightChild());
        node.getRightChild().setRightChild(buffer);
        if (buffer != null){
        buffer.setParent(node.getRightChild());}
        updateHeight(node.getRightChild());
    }
    private void leftRotate(Node node){
        supportingSwap(node,node.getRightChild());
        //
       // node.getLeftChild().setParent(null);
        Node buffer = node.getLeftChild();
        //buffer.setParent(null);
        //
        node.setLeftChild(node.getRightChild());
        node.setRightChild(node.getLeftChild().getRightChild());
        if (node.getRightChild() != null){
        node.getRightChild().setParent(node);}
        node.getLeftChild().setRightChild(node.getLeftChild().getLeftChild());
        node.getLeftChild().setLeftChild(buffer);
        if (buffer != null){
        buffer.setParent(node.getLeftChild());}
        updateHeight(node.getLeftChild());
    }
    private void balance(Node node){
        Node currentNode = node;
        while (currentNode != null) {
            int balance = getBalance(currentNode);
            if (balance == -2) {
                if (getBalance(currentNode.getLeftChild()) == 1) {
                    leftRotate(currentNode.getLeftChild());
                }
                rightRotate(currentNode);
            } else if (balance == 2) {
                if (getBalance(currentNode.getRightChild()) == -1) {
                    rightRotate(currentNode.getRightChild());
                }
                leftRotate(currentNode);
            }
            currentNode = currentNode.getParent();
        }
    }
    private void RecalculationBalanceFactor(Node node){
        findNodeByNode(node);
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
