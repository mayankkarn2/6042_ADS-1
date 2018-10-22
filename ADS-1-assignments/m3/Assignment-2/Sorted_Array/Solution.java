import java.util.Scanner;
/**
 * item_description.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        /**
         * item_description.
         */
    }
    /**
     * Main function_description.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
    Scanner s = new Scanner(System.in);
    String s1 = s.nextLine();
    String s2 = s.nextLine();
    int number1 = Integer.parseInt(s1);
    int number2 = Integer.parseInt(s2);
    int total = number1 + number2;
    String[] token = s.nextLine().split(",");
    int[] a = new int[number1];
    int[] b = new int[number2];
    if (number1 > 0) {
    for (int i = 0; i < token.length; i++) {
        a[i] = Integer.parseInt(token[i]);
    }
}
    if (number2 > 0) {
    String[] tokens = s.nextLine().split(",");
    for (int j = 0; j < tokens.length; j++) {
        b[j] = Integer.parseInt(tokens[j]);
    }
}
    int[] c = new int[total];
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < number1 && j < number2) {
        if (a[i] < b[j]) {
            c[k] = a[i];
            i++;
            k++;
        } else {
            c[k] = b[j];
            k++;
            j++;
        }
    }
    while (j < number2) {
        c[k] = b[j];
        k++;
        j++;
    }
    while (i < number1) {
        c[k] = a[i];
        k++;
        i++;
    }
    for (int l = 0; l < c.length - 1; l++) {
        System.out.print(c[l] + ",");
    }
     System.out.print(c[c.length - 1]);
    }
}

