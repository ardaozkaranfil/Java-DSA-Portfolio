import java.util.ArrayList;
import java.util.Objects;

class BinaryNode
{
    Integer value;
    BinaryNode leftNode;
    BinaryNode rightNode;

    public BinaryNode(Integer value)
    {
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }

    public BinaryNode(Integer value, BinaryNode leftNode, BinaryNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public BinaryNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryNode rightNode) {
        this.rightNode = rightNode;
    }
}

public class BST
{
    private BinaryNode rootNode;

    public BST() {
        this.rootNode = null;
    }
	public BST(BinaryNode rootNode) {
        this.rootNode = rootNode;
    }

    public BinaryNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(BinaryNode rootNode) {
        this.rootNode = rootNode;
    }

    public void insert(Integer x)
    {
        if (x == null){
            throw new IllegalArgumentException("Value cannot be null");
        }
        setRootNode(insert(getRootNode(), x));
    }

    private BinaryNode insert(BinaryNode rootNode, Integer x)
    {
        if (rootNode == null) {
            return new BinaryNode(x);
        }

        if (x < rootNode.value) {
            rootNode.setLeftNode(insert(rootNode.getLeftNode(), x));
        }
        else if (x > rootNode.value) {
            rootNode.setRightNode(insert(rootNode.getRightNode(), x));
        }
        
        return rootNode;
    }

    public void printTreeInorder(BinaryNode root)
    {
        if (root == null) {
            return;
        }

        printTreeInorder(root.leftNode);
        System.out.print(root.value + " ");
        printTreeInorder(root.rightNode);
    }

    protected ArrayList<Integer> toInorderList(BinaryNode parent, ArrayList<Integer> list)
    {
        if(parent == null){
            return list;
        }
        toInorderList(parent.leftNode, list);
        list.add(parent.getValue());
        toInorderList(parent.rightNode, list);
        return list;
    }

    public void removeDuplicates()
    {
        if(rootNode == null){
            throw new IllegalStateException("BST is empty.");
        }
        else{
            ArrayList<Integer> list = toInorderList(rootNode, new ArrayList<>());
            for(int i = 0; i < list.size(); i++){
                if(i == 0){
                    continue;
                }
                else if(Objects.equals(list.get(i), list.get(i - 1))){
                    list.remove(i-1);
                    i--;
                }
            }

            rootNode = null;
            for(int i = 0; i < list.size(); i++){
                insert(list.get(i));
            }
        }
    }

    public Boolean hasUniqueElements() {
        if(rootNode == null){
            throw new IllegalStateException("BST is empty.");
        }
        else {
            ArrayList<Integer> list = toInorderList(rootNode, new ArrayList<>());
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    continue;
                } else if (Objects.equals(list.get(i), list.get(i - 1))) {
                    return false;
                }
            }
            return true;
        }
    }

    public Integer findMax()
    {
        if(rootNode == null){
            throw new IllegalStateException("BST is empty.");
        }
        else {
            BinaryNode node = rootNode;
            while(!(node.rightNode == null)){
                node = node.rightNode;
            }
            return node.getValue();
        }
    }

    public Integer findDepth(BinaryNode node) {
        if(node == null){
            return -1;
        }
        return 1 + Math.max(findDepth(node.leftNode), findDepth(node.rightNode));
    }
}