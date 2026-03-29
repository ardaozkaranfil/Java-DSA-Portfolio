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

    private void initializeLinksAndCircularity() {
    }
}