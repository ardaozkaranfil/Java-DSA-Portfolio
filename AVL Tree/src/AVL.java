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
        root.left = rotateRR(root.left);
        return rotateLL(root);
    }

    private AVLNode rotateRL(AVLNode root){
        root.right = rotateLL(root.right);
        return rotateRR(root);
    }

    public AVLNode insert(int elem, AVLNode root){
        if (root == null) {
            return new AVLNode(elem, null, null);
        }
        else if (elem < root.elem) {
            root.left = insert(elem, root.left);
        }
        else if (elem > root.elem) {
            root.right = insert(elem, root.right);
        }
        return balance(root);
    }

    public AVLNode balance(AVLNode root){
        if (root != null){
            if(getHeight(root.left) - getHeight(root.right) >= 2){
                if (getHeight(root.left.left) >= getHeight(root.left.right)) {
                    root = rotateLL(root);
                }
                else {
                    root = rotateLR(root);
                }
            }
            else if(getHeight(root.left) - getHeight(root.right) <= -2){
                if (getHeight(root.right.right) >= getHeight(root.right.left)) {
                    root = rotateRR(root);
                }
                else {
                    root = rotateRL(root);
                }
            }
            root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
        return root;
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
