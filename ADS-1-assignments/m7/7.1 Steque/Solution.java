import java.util.Scanner;
/**
 * Class for steque.
 */
class Steque {
    /**
     * Storing numbers.
     */
    private int[] store;
    /**
     * Top value.
     */
    private int top;
    /**
     * Rear value.
     */
    private int rear;
    /**
     * Constructs the object.
     */
    Steque() {
        final int hundred = 100;
        store = new int[hundred];
        top = -1;
        rear = -1;
    }
    /**
     * Pushes the value at the end.
     *
     * @param      value  The value
     */
    public void push(final int value) {
        if (top == -1) {
            rear++;
        }
        top = top + 1;
        store[top] = value;
    }
    /**
     * Removes the last element.
     */
    public void pop() {
        if (top > -1) {
            if (top == 0) {
                rear--;
            }
            top--;
        }
    }
    /**
     * Pushes the element at first position.
     *
     * @param      value  The value
     */
    public void enqueue(final int value) {
        if (top == -1) {
            top++;
            rear++;
            store[rear] = value;
        } else {
            for (int i = top; i >= 0; i--) {
                store[i + 1] = store[i];
            }
            top = top + 1;
            store[rear] = value;
        }
    }
    /**
     * Prints out the stack.
     */
    public void printSteque() {
        if (top <= -1) {
            System.out.print("Steque is empty.");
        } else {
            for (int i = top; i > -1; i--) {
                if (i == 0) {
                    System.out.print(store[i]);
                } else {
                    System.out.print(store[i] + ", ");
                }
            }
        }
        System.out.println();
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Nothing happens here.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int testcases = s.nextInt();
        s.nextLine();
        int n = 0;
        String str = "";
        while (n < testcases) {
            str = "";
            Steque mySteque = new Steque();
            while (s.hasNext()) {
                String input = s.nextLine();
                if (input.equals("")) {
                    break;
                }
                str += input + "\n";
            }
            String[] inputs = str.split("\n");
            for (int i = 0; i < inputs.length; i++) {
                if (inputs[i].contains("pop")) {
                    mySteque.pop();
                    mySteque.printSteque();
                } else if (inputs[i].contains("push")) {
                    String[] pushed = inputs[i].split(" ");
                    mySteque.push(Integer.parseInt(pushed[1]));
                    mySteque.printSteque();
                } else {
                    String[] enqueued = inputs[i].split(" ");
                    mySteque.enqueue(Integer.parseInt(enqueued[1]));
                    mySteque.printSteque();
                }
            }
            System.out.println();
            n++;
        }
    }
}
