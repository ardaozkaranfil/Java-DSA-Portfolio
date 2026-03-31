public class TwoStacks {
    private Integer[] twoStacks;
    private int capacity;
    public int top1;
    public int top2;

    public TwoStacks(int capacity) {
        this.twoStacks = new Integer[capacity];
        this.capacity = capacity;
        this.top1 = -1;
        this.top2 = capacity;
    }

    public Integer[] getTwoStacks() {
        return twoStacks;
    }

    public void setTwoStacks(Integer[] twoStacks) {
        boolean isStackNull = true;
        if (twoStacks.length == this.capacity) {
            for (Integer element : twoStacks) {
                if (element != null) {
                    isStackNull = false;
                    break;
                }
            }
            if (!isStackNull) {
                if (twoStacks.length % 2 == 0) {
                    this.twoStacks = twoStacks;
                    this.top1 = (twoStacks.length / 2) - 1;
                    for (int i = this.top1; i > -1; i--) {
                        if (this.twoStacks[i] == null)
                            this.top1--;
                    }
                    this.top2 = this.top1 + 1;
                    for (int i = this.top2; i < getCapacity(); i++) {
                        if (this.twoStacks[i] == null)
                            this.top2++;
                    }
                } else {
                    this.twoStacks = twoStacks;
                    this.top1 = (int) Math.floor((twoStacks.length / 2.0));
                    for (int i = this.top1; i > -1; i--) {
                        if (this.twoStacks[i] == null)
                            this.top1--;
                    }
                    this.top2 = this.top1 + 1;
                    for (int i = this.top2; i < getCapacity(); i++) {
                        if (this.twoStacks[i] == null)
                            this.top2++;
                    }
                }
            } else {
                this.top1 = -1;
                this.top2 = getCapacity();
            }
        } else
            System.out.println("You cannot set a shorter or a longer integer array to this TwoStacks object.");
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }




    public boolean isStackOneEmpty() {
        return top1 == -1;
    }

    public boolean isStackTwoEmpty() {
        return top2 == getCapacity();
    }

    public boolean isTwoStacksFull() {
        return top1 + 1 == top2;
    }

    public void pushToStackOne(int value) {

    }

    public void pushToStackTwo(int value) {

    }

    public void popFromStackOne() {

    }

    public void popFromStackTwo() {

    }

    public int topStackOne() {
        return 0;
    }

    public int topStackTwo() {
        return 0;
    }

    public boolean swapTops() {
        return true;
    }

    public void makeStackOneEmpty() {

    }

    public boolean isBothStacksEmpty() {
        return true;
    }

    public void pushToStackTwoFromStackOne(int elementCount) {

    }
}