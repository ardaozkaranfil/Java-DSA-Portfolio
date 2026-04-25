import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(3);
        bst.insert(1);
        bst.insert(7);

        System.out.println("Inorder: " + bst.toInorderList(bst.getRootNode(), new ArrayList<>()));
        System.out.println("Has unique elements: " + bst.hasUniqueElements());
        System.out.println("Max: " + bst.findMax());
        System.out.println("Depth: " + bst.findDepth(bst.getRootNode()));

        bst.removeDuplicates();
        System.out.println("After removeDuplicates: " + bst.toInorderList(bst.getRootNode(), new ArrayList<>()));
        System.out.println("Has unique elements: " + bst.hasUniqueElements());
    }
}