class LinkedList {
    class Node {
        char data;
        Node next;
    }
    Node head, tail;
    public void addAtHead(char data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        if(head == null) tail = node;
        head = node;
    }

    public static String returnNumber(LinkedList list) {
        String numer = "";
        Node thead = list.head;
        while(thead != null) {
            numer += Character.toString(thead.data);
            thead = thead.next;
        }
        return numer;
    }
}