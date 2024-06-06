public class LinkedList {
    Node head;

    public LinkedList(int data){
        head = new Node(data);
    }

    public void append(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void prepend(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void insert(int data , int index){
        Node newNode = new Node(data);
        Node current = head;

        for(int i = 0 ; i < index-1 ; i++){
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public Node getNode(int data){
        Node current = head;
        while(current != null && current.data != data){
            current = current.next;
        }

        return current;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("null");
    }
}

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        next = null;
    }
}
