class AVLNode{

    int elem, height;
    AVLNode left, right;

    AVLNode(int elem, AVLNode leftTree, AVLNode rightTree){
        this.elem = elem;
        height = 0;
        left = leftTree;
        right = rightTree;
    }
}

public class AVL {

    AVLNode root;

    public AVL(AVLNode root){
        this.root = root;
    }

    public AVL(){
        this.root = null;
    }

    private int getHeight(AVLNode node){
        if (node == null)
            return -1;
        return node.height;
    }

    private AVLNode rotateLL(AVLNode root){
        AVLNode newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;

        return newRoot;
    }

    private AVLNode rotateRR(AVLNode root){
        AVLNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;

        return newRoot;
    }

    private AVLNode rotateLR(AVLNode root){
        return null;
    }

    private AVLNode rotateRL(AVLNode root){
        return null;
    }

    public AVLNode insert(int elem, AVLNode root){
        return null;
    }

    public AVLNode balance(AVLNode root){
        return null;
    }

    public AVLNode search(int elem, AVLNode root){
        return null;
    }

    public Boolean isAVL(AVLNode root){
        return null;
    }

    public static Boolean AVLEquals(AVLNode root1, AVLNode root2){
        return null;
    }
}
