public class Test {
    public static void main(String[] args) {
        AVL avl = new AVL();

        avl.root = avl.insert(10, avl.root);
        avl.root = avl.insert(5, avl.root);
        avl.root = avl.insert(15, avl.root);
        avl.root = avl.insert(3, avl.root);
        avl.root = avl.insert(7, avl.root);

        System.out.println(avl.search(7, avl.root) != null);   // true
        System.out.println(avl.search(99, avl.root) == null);  // true

        System.out.println(avl.isAVL(avl.root));               // true

        AVLNode badRoot = new AVLNode(10, null, null);
        badRoot.left = new AVLNode(12, null, null);
        System.out.println(avl.isAVL(badRoot));                // false

        AVL avl2 = new AVL();
        avl2.root = avl2.insert(10, avl2.root);
        avl2.root = avl2.insert(5, avl2.root);
        avl2.root = avl2.insert(15, avl2.root);
        avl2.root = avl2.insert(3, avl2.root);
        avl2.root = avl2.insert(7, avl2.root);
        System.out.println(AVL.AVLEquals(avl.root, avl2.root)); // true

        avl2.root = avl2.insert(99, avl2.root);
        System.out.println(AVL.AVLEquals(avl.root, avl2.root)); // false

        System.out.println(avl.isAVL(null));                    // true
        System.out.println(AVL.AVLEquals(null, null));          // true
        System.out.println(AVL.AVLEquals(null, avl.root));      // false
    }
}