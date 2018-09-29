import java.util.Scanner;
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
class AddLargeNumbers {
    
    public static LinkedList numberToDigits(String number) {
        // System.out.println(number);
        LinkedList num = new LinkedList();
        for(int i = 0; i < number.length(); i++) {
            num.addAtHead(number.charAt(i));
        }
        return num;
    }

    public static String digitsToNumber(LinkedList list) {
        StringBuilder sb = new StringBuilder(list.returnNumber(list));
        return sb.reverse().toString();
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        return null;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
