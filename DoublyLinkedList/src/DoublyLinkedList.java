import java.util.Random;

public class DoublyLinkedList {

    public  Node head;
    public  Node tail;
    public  int length = 0;

    static class Node{
        int data;
        Node previous;
        Node next;

        public Node(int data){
            this.data = data;
            previous = null;
            next = null;
        }
    }

    public void append(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;
            length++;
            return;
        }

        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        newNode.previous = current;
        current.next = newNode;
        tail = newNode;
    }

    public void printList(){
        Node current = head;

        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void printListReverse(){
        Node current = tail;

        while(current != null){
            System.out.println(current.data);
            current = current.previous;
        }
    }

    public Node createdDoublyLinkedList(int[] arr){
        for(int i : arr){
            append(i);
        }
        return head;
    }

    public Node createDoublyLinkedList(int size){
        DoublyLinkedList dll = new DoublyLinkedList();

        for(int i = 0 ; i < size ; i++){
            Random rand = new Random();
            append(rand.nextInt(20));
        }
        return head;
    }

    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append(11);
        dll.append(12);
        dll.append(13);

        dll.printList();

        System.out.println("now in reverse hopefully");

        dll.printListReverse();
    }
}
