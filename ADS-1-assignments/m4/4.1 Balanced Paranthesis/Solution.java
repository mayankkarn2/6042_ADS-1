import java.util.Scanner;
/**
 * Class for stack.
 */
class Stack {
    /**
     *  Array of Strings.
     */
    private String[] data;
    /**
     * Top value.
     */
    private int top;
    /**
     * Constructs the object.
     *
     * @param      size  The size of Stack
     */
    Stack(final int size) {
        data = new String[size];
        top = -1;
    }
    /**
     * pushes the element into the stack for valid inputs.
     *
     * @param      input  The input
     *
     * @return     1 if input is valid, else false
     */
    public int push(final char input) {
        String val = Character.toString(input);
        if (top == -1) {
            if (val.equals("(") || val.equals("[") || val.equals("{")) {
                top++;
                data[top] = val;
                return 1;
            } else {
                return 0;
            }
        }
        switch (val) {
            case "(":
            if (data[top].equals("(") || data[top].equals("[")
                || data[top].equals("{")) {
                top++;
                data[top] = val;
                return 1;
            }
            return 0;
            case ")":
            if (data[top].equals("(")) {
                pop();
                return 1;
            }
            return 0;
            case "[":
            if (data[top].equals("(") || data[top].equals("[")
                || data[top].equals("{")) {
                top++;
                data[top] = val;
                return 1;
            }
            return 0;
            case "]":
            if (data[top].equals("[")) {
                pop();
                return 1;
            }
            return 0;
            case "{":
            if (data[top].equals("(") || data[top].equals("[")
                || data[top].equals("{")) {
                top++;
                data[top] = val;
                return 1;
            }
            return 0;
            case "}":
            if (data[top].equals("{")) {
                pop();
                return 1;
            }
            return 0;
            default:
        }
        return 0;
    }
    /**
     * Pops the element.
     */
    public void pop() {
        top--;
    }
    /**
     * Gets the top.
     *
     * @return     The top.
     */
    public int getTop() {
        return top;
    }
    /**
     * Sets the top.
     *
     * @param      i     given value.
     */
    public void setTop(final int i) {
        top = i;
    }
}
/**
 * Class for Solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Nothing happens here.
    }
    /**
     * The main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // Stack st = new Stack(2000);
        Scanner s = new Scanner(System.in);
        int lines = s.nextInt();
        s.nextLine();
        int i = 0;
        while (i < lines) {
            String inputs = "";
            inputs = s.nextLine();
            Stack st = new Stack(inputs.length());
            int j = 0, f = 0;
            st.setTop(-1);
            for (j = 0; j < inputs.length(); j++) {
                f = st.push(inputs.charAt(j));
                if (f == 0) {
                    System.out.println("NO");
                    break;
                }
            }
            if (f != 0) {
                if (j == inputs.length() && st.getTop() == -1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            i++;
        }
    }
}
