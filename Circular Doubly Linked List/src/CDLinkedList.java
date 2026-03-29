import java.util.Arrays;

public class CDLinkedList {

    private LLNode headNode;
    private LLNode tailNode;
    private int size;

    public CDLinkedList(int headValue, int tailValue) {
        this.headNode = new LLNode(headValue);
        this.tailNode = new LLNode(tailValue);
        initializeLinksAndCircularity();
        this.size = 2;
    }

    public LLNode getHeadNode() {
        return headNode;
    }

    public void setHeadNode(LLNode headNode) {
        this.headNode = headNode;
    }

    public LLNode getTailNode() {
        return tailNode;
    }

    public void setTailNode(LLNode tailNode) {
        this.tailNode = tailNode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addElement(int data)
    {
        LLNode newNode = new LLNode(data);

        if (getSize() < 0)
        {
            System.out.println("Illegal size (<0). There must a wrong operation in size calculation.");
            return;
        }

        else if (getSize() == 0 || getSize() == 1)
        {
            System.out.println("There must be something wrong, since size cannot be 0 or 1 at any time.");
            return;
        }
        else
        {
            getTailNode().setNextElement(newNode);

            newNode.setPrevElement(getTailNode());
            newNode.setNextElement(getHeadNode());

            getHeadNode().setPrevElement(newNode);

            setTailNode(newNode);
            setSize(getSize() + 1);

        }
    }

    public void printCDLL()
    {
        LLNode temp = getHeadNode();
        int increase = String.valueOf(temp.getElement()).length() - 3;
        for (int i = 0; i < getSize(); i++)
        {
            if (temp != getTailNode())
            {
                System.out.print(temp.getElement() + " --> ");
                temp = temp.getNextElement();
                increase = increase + 2 + (String.valueOf(temp.getElement()).length() - 1);
            }
            else
            {
                System.out.println(temp.getElement() + ".");
                if (getTailNode().getNextElement().equals(getHeadNode()))
                    printCircularNextConnection(increase);
                else
                    System.out.println("No circular connection.");
            }

        }
    }

    private void printCircularNextConnection(int increase) {
        char[] data = new char[getSize() * 4 + (increase - 1)];
        char c = '-';
        Arrays.fill(data, c);
        data[0] = '^';
        data[data.length - 1] = '|';
        System.out.println(new String(data));
    }

    private void initializeLinksAndCircularity() {
        headNode.setNextElement(tailNode);
        headNode.setPrevElement(tailNode);
        tailNode.setPrevElement(headNode);
        tailNode.setNextElement(headNode);
    }

    public boolean deleteMiddleElement (){
        if(size <= 2){
            System.out.println("Circular Linked List is empty or have less than 3 members because of that system can not delete middle element.");
            return false;
        }
        else {
            int midElementPosition = size / 2;
            LLNode currentNode = headNode;

            for (int i = 0; i < midElementPosition; i++) {
                currentNode = currentNode.getNextElement();
            }

            currentNode.getPrevElement().setNextElement(currentNode.getNextElement());
            currentNode.getNextElement().setPrevElement(currentNode.getPrevElement());
            setSize(getSize() - 1);

            return true;
        }
    }
}