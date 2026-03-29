public class Test {
    public static void main(String[] args) {

        System.out.println("=== Test 1: Initialization ===");
        CDLinkedList list = new CDLinkedList(1, 2);
        list.printCDLL();

        System.out.println("\n=== Test 2: addElement ===");
        list.addElement(3);
        list.addElement(4);
        list.addElement(5);
        list.printCDLL();
        System.out.println("Size: " + list.getSize()); // 5

        System.out.println("\n=== Test 3: getElement (forward) ===");
        System.out.println(list.getElement(0, true));  // 1
        System.out.println(list.getElement(3, true));  // 4
        System.out.println(list.getElement(4, true));  // 5

        System.out.println("\n=== Test 4: getElement (backward) ===");
        System.out.println(list.getElement(0, false)); // 5
        System.out.println(list.getElement(3, false)); // 2

        System.out.println("\n=== Test 5: getElement (out of bounds) ===");
        System.out.println(list.getElement(5, true));  // -1
        System.out.println(list.getElement(-1, true)); // -1

        System.out.println("\n=== Test 6: deleteMiddleElement (size=5, mid=2) ===");
        list.deleteMiddleElement(); // index 2 = 3 must be deleted
        list.printCDLL();
        System.out.println("Size: " + list.getSize()); // 4

        System.out.println("\n=== Test 7: deleteMiddleElement (size=4, mid=2) ===");
        list.deleteMiddleElement(); // index 2 = 4 must be deleted
        list.printCDLL();
        System.out.println("Size: " + list.getSize()); // 3
    }
}