import java.util.ArrayList;

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
        if (x >= 0)
            setRootNode(insert(getRootNode(), x));
    }

    private BinaryNode insert(BinaryNode rootNode, Integer x)
    {
        if (rootNode == null) {
            return new BinaryNode(x);
        }

        if (x < rootNode.value)
        {
            rootNode.setLeftNode(insert(rootNode.getLeftNode(), x));
        }

        else {
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

    public Boolean removeDuplicates()
    {
        return null;
    }

    public Boolean hasUniqueElements()
    {
        return null;
    }

    public Integer findMax()
    {
        return Integer.MIN_VALUE;
    }

    public Integer findDepth(BinaryNode node)
    {
        return Integer.MIN_VALUE;
    }
}