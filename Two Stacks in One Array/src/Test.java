public class Test {
    public static void main(String[] args) {

        System.out.println("=== Test 1: Initialization ===");
        TwoStacks ts = new TwoStacks(6);
        System.out.println("Stack 1 empty: " + ts.isStackOneEmpty()); // true
        System.out.println("Stack 2 empty: " + ts.isStackTwoEmpty()); // true
        System.out.println("Both empty: " + ts.isBothStacksEmpty());  // true
        System.out.println("Full: " + ts.isTwoStacksFull());          // false

        System.out.println("\n=== Test 2: Push ===");
        ts.pushToStackOne(10);
        ts.pushToStackOne(20);
        ts.pushToStackOne(30);
        ts.pushToStackTwo(100);
        ts.pushToStackTwo(200);
        ts.pushToStackTwo(300);
        System.out.println("Top 1: " + ts.topStackOne()); // 30
        System.out.println("Top 2: " + ts.topStackTwo()); // 300
        System.out.println("Full: " + ts.isTwoStacksFull()); // true

        System.out.println("\n=== Test 3: Push when full ===");
        ts.pushToStackOne(999);
        ts.pushToStackTwo(999);
        System.out.println("Top 1: " + ts.topStackOne()); // 30
        System.out.println("Top 2: " + ts.topStackTwo()); // 300

        System.out.println("\n=== Test 4: Pop ===");
        ts.popFromStackOne();
        ts.popFromStackTwo();
        System.out.println("Top 1: " + ts.topStackOne()); // 20
        System.out.println("Top 2: " + ts.topStackTwo()); // 200
        System.out.println("Full: " + ts.isTwoStacksFull()); // false

        System.out.println("\n=== Test 5: SwapTops ===");
        System.out.println("Swap result: " + ts.swapTops()); // true
        System.out.println("Top 1: " + ts.topStackOne()); // 200
        System.out.println("Top 2: " + ts.topStackTwo()); // 20

        System.out.println("\n=== Test 6: makeStackOneEmpty ===");
        ts.makeStackOneEmpty();
        System.out.println("Stack 1 empty: " + ts.isStackOneEmpty()); // true
        System.out.println("Stack 2 empty: " + ts.isStackTwoEmpty()); // false
        ts.makeStackOneEmpty();

        System.out.println("\n=== Test 7: Top on empty stack ===");
        System.out.println("Top 1: " + ts.topStackOne()); // Integer.MAX_VALUE

        System.out.println("\n=== Test 8: SwapTops when one stack empty ===");
        System.out.println("Swap result: " + ts.swapTops()); // false

        System.out.println("\n=== Test 9: pushToStackTwoFromStackOne ===");
        ts.pushToStackOne(1);
        ts.pushToStackOne(2);
        ts.pushToStackTwoFromStackOne(2);
        System.out.println("Stack 1 empty: " + ts.isStackOneEmpty()); // true
        System.out.println("Top 2: " + ts.topStackTwo()); // 1
    }
}