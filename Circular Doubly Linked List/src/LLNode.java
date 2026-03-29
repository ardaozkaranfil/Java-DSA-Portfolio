class LLNode {
    private int element;
    private LLNode nextElement;
    private LLNode prevElement;

    public LLNode(int element)
    {
        this.element = element;
        this.nextElement = null;
        this.prevElement = null;
    }

    public LLNode(int element, LLNode nextElement, LLNode prevElement) {
        this.element = element;
        this.nextElement = nextElement;
        this.prevElement = prevElement;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public LLNode getNextElement() {
        return nextElement;
    }

    public void setNextElement(LLNode nextElement) {
        this.nextElement = nextElement;
    }

    public LLNode getPrevElement() {
        return prevElement;
    }

    public void setPrevElement(LLNode prevElement) {
        this.prevElement = prevElement;
    }
}