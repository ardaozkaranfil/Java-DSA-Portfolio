class Node{
    int priority;
    String name;
    Node next;

    public Node(int priority, String name){
        this.priority = priority;
        this.name = name;
    }

    public Node(int priority, String name, Node next){
        this.priority = priority;
        this.name = name;
        this.next = next;
    }


    public int getPriority(){
        return this.priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Node getNext(){
        return this.next;
    }

    public void setNext(Node next){
        this.next = next;
    }

}

public class PriorityQueue {

    Node headNode;
    int size;

    public PriorityQueue(){
        headNode = null;
        size = 0;
    }

    public Node getHeadNode(){
        return headNode;
    }

    public void setHeadNode(Node newHeadNode){
        headNode = newHeadNode;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int newSize){
        size = newSize;
    }


    public void printQueue(){

        System.out.print("Size of the queue is: " + getSize() + "\n");

        Node cursor = getHeadNode();

        System.out.print("[headNode] ---> ");

        while(cursor != null){
            System.out.print("[" + cursor.getPriority() + ", " + cursor.getName() + "] ---> ");
            cursor = cursor.getNext();
        }

        System.out.print("NULL");
        System.out.println("\n\n");
    }

    public boolean enqueue(int priority, String name){
        return true;
    }

    public String dequeue(){
        return "";
    }

    public int findPlace(String name){
        return -2;
    }

    public boolean promote(String name){
        return true;
    }
}
