public class DLL00 {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.createdDoublyLinkedList(new int[]{1,2,3,4,5,6,7});

        while(dll.head != null){
            System.out.println(dll.head.data);
            dll.head = dll.head.next;
        }
        System.out.println("-------creating new linked list --------------");
        DoublyLinkedList dll2 = new DoublyLinkedList();
        dll.createDoublyLinkedList(10);
        while(dll2.head != null){
            System.out.println(dll2.head.data);
            dll2.head = dll2.head.next;
        }
    }
}
