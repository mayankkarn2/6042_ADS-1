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

class Stack {
    
    char[] data = new char[500];
    int top = -1;
    public void push(char input) {
        top++;
        data[top] = input;
    }

    public char pop() {
        char r = data[top];
        top--;
        return r;
    }
    public int size() {
        return top+1;
    }
    public String print() {
        String s = "";
        for(int i = 0; i <= top; i++) {
            s = s + (data[i]);
        }
        return s;
    }
}
class AddLargeNumbers {
    
    public static LinkedList numberToDigits(String number) {
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
        String first = digitsToNumber(list1);
        String second = digitsToNumber(list2);
        Stack one = new Stack();
        Stack two = new Stack();
        Stack carry = new Stack();
        int difference = first.length() - second.length();
        if(difference < 0) {
            difference = -1 * (difference);
        }

        if (first.length() - second.length() > 0) {
            for(int i = 0; i < first.length(); i++) {
                one.push(first.charAt(i));
            }
            for(int i = 0; i < difference; i++) {
                two.push('0');
            }
            for(int i = 0 ; i < second.length(); i++) {
                two.push(second.charAt(i));
            }
        }
        else if (first.length() - second.length() == 0) {
            for(int i = 0; i < first.length(); i++) {
                one.push(first.charAt(i));
            }
            for(int i = 0; i < second.length(); i++) {
                two.push(second.charAt(i));
            }
        }
        else {
            for(int i = 0; i < difference; i++) {
                one.push('0');
            }
            for(int i = 0 ; i < first.length(); i++) {
                one.push(first.charAt(i));
            }
            for(int i = 0; i < second.length(); i++) {
                two.push(second.charAt(i));
            }
        }
        one.print();
        two.print();
        carry.push('0');
        Stack res = new Stack();
        while(one.top != -1) {
            int n1 = Integer.parseInt(String.valueOf(one.pop()));
            int n2 = Integer.parseInt(String.valueOf(two.pop()));
            int sum = n1 + n2 + Integer.parseInt(String.valueOf(carry.pop()));
            // if(Integer.parseInt(String.valueOf(carry.pop())) > 0) {
            //     sum = n1 + n2 + Integer.parseInt(String.valueOf(carry.pop()));
            //     char c = carry.pop();
            // }
            res.push(Character.forDigit(sum % 10, 10));
            carry.push(Character.forDigit(sum / 10, 10));
        }
        StringBuilder sbs = new StringBuilder(res.print());
        String result = sbs.reverse().toString();
        LinkedList ret = AddLargeNumbers.numberToDigits(result);
        return ret;
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
