import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("ALL")
public class LL01 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.append(6);
        ll.append(7);

        // connect the last node to one of the previous nodes to form a loop
        Node loopOrigin = ll.getNode(4);
        Node current = ll.head;
        while(current.next != null){
            current = current.next;
        }

        current.next = loopOrigin;

//        ll.printList();    a linked list containing a loop is created.
        System.out.println("does loop exists : "+loopExists_turtleAlgo(ll));
    }

    public static boolean loopExists_hashMap(LinkedList ll){
        Set<Node> visitedNodes = new HashSet<>();
        Node current = ll.head;
        while(current != null){
            if(visitedNodes.contains(current)){
                return true;
            }else{
                visitedNodes.add(current);
            }
            current = current.next;
        }
        return false;
    }

    //turtle-Hair Algo
    public static boolean loopExists_turtleAlgo(LinkedList ll){
        Node slowPointer = ll.head;
        Node fastPointer = ll.head;

        do{
            if (slowPointer.next == null || fastPointer.next == null || fastPointer.next.next == null) {
                return false;
            }
            else{
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
        }while(!slowPointer.equals(fastPointer));

        return true;
    }
}

