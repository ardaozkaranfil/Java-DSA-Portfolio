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

    private void initializeLinksAndCircularity() {
    }
}