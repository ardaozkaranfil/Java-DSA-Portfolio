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

/**
 * AVL Tree implementation with self-balancing on insert.
 * Rotation logic is split into four cases: LL, RR, LR, RL.
 */
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

    /**
     * Recursive BST insertion with duplicate rejection.
     * Each recursive call returns through balance to maintain AVL property on the way back up.
     * @time O(log n)
     */
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

    /**
     * Checks the height difference and applies the appropriate single or double rotation.
     * Updates height after rebalancing.
     * @time O(1)
     */
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

    /**
     * Recursive BST search using the AVL tree's ordering property.
     * Returns the node if found, null otherwise.
     * @time O(log n)
     */
    public AVLNode search(int elem, AVLNode root){
        if (root == null){
            return null;
        }
        else if(root.elem == elem){
            return root;
        }
        else if(elem < root.elem){
            return search(elem, root.left);
        }
        else{
            return search(elem, root.right);
        }
    }

    /**
     * Checks balance factor and BST property against immediate children at each node,
     * then recursively validates both subtrees.
     * @time O(n)
     */
    public Boolean isAVL(AVLNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        if (root.left != null && root.left.elem > root.elem) {
            return false;
        }
        if (root.right != null && root.right.elem < root.elem) {
            return false;
        }
        return isAVL(root.left) && isAVL(root.right);
    }

    /**
     * Compares two AVL trees recursively by structure and element equality.
     * @time O(n)
     */
    public static Boolean AVLEquals(AVLNode root1, AVLNode root2){
        if (root1 == null && root2 == null) {
            return true;
        }
        else if(root1 == null || root2 == null){
            return false;
        }
        else if(root1.elem != root2.elem){
            return false;
        }
        else{
            return AVLEquals(root1.left, root2.left) && AVLEquals(root1.right, root2.right);
        }
    }
}
