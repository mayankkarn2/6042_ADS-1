import java.util.Scanner;
/**
 * List of linkeds.
 *
 * @param      <E>   generic variable.
 */
class LinkedList<E> {
    /**
     * Class for node.
     */
    /**
     * Class for node.
     */
    private class Node {
        /**
         * To store data.
         */
        private E data;
        /**
         * Next node reference.
         */
        private Node next;
    }
    /**
     * Head and Tail.
     */
    private Node head, tail;
    /**
     * A temporary head.
     */
    private Node thead = head;
    /**
     * Count of nodes.
     */
    private int count = 0;
    /**
     * Size of linked list.
     */
    private int size = 0;
    /**
     * Adds an at head.
     *
     * @param      data  The data
     */
    public void addAtHead(final E data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        if (head == null) {
          tail = node;
        }
        head = node;
        size++;
        print();
        thead = head;
    }
    /**
     * inserts the element at the required position.
     *
     * @param      index  The index
     * @param      data   The data
     */
    public void insertAt(final int index, final E data) {
        try {
            if (index >= 0 && index <= size) {
                if (index == 0) {
                    addAtHead(data);
                    return;
                }
                if (count == index - 1) {
                    Node node = new Node();
                    node.data = data;
                    node.next = thead.next;
                    thead.next = node;
                    size++;
                    print();
                    thead = head;
                } else {
                    count++;
                    if (thead.next != null) {
                        thead = thead.next;
                    }
                    insertAt(index, data);
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (Exception e) {
            System.out.println("Can't insert at this position.");
            thead = head;
        }
    }
    /**
     * prints the linked list.
     */
    public void print() {
        Node theads = head;
        while (theads != null && theads.next != null) {
            System.out.print(theads.data + ", ");
            theads = thead.next;
        }
        System.out.println(thead.data);
        count = 0;
    }
    /**
     * reverse the given linked list.
     */
    void reverse() {
        head = reverseHelper(head);
        thead = head;
        print();
    }
/**
 * it helps the reveerse function to reverse the linked list.
 *
 * @param      head  The head
 *
 * @return     returns the head.
 */
    Node reverseHelper(Node head) {
        if (head == null || head.next == null) {
         return head;
            }
        Node ahead = reverseHelper(head.next);
        head.next.next = head;
        head.next = null;
        return ahead;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * reads the input and calls the mnethods.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList li = new LinkedList();
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String[] arr1 = str1.split(" ");
            switch (arr1[0]) {
                case "insertAt":
                    li.insertAt(Integer.parseInt(arr1[1]), Integer.parseInt(arr1[2]));
                    break;
                case "reverse":
                    try {
                        li.reverse();
                    } catch (Exception e) {
                        System.out.println("No elements to reverse.");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
